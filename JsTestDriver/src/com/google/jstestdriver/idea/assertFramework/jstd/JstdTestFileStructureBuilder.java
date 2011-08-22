package com.google.jstestdriver.idea.assertFramework.jstd;

import com.google.jstestdriver.idea.assertFramework.AbstractTestFileStructureBuilder;
import com.google.jstestdriver.idea.assertFramework.BaseTestCaseStructure;
import com.google.jstestdriver.idea.assertFramework.BaseTestStructure;
import com.google.jstestdriver.idea.assertFramework.JsTestFileStructure;
import com.google.jstestdriver.idea.util.CastUtils;
import com.google.jstestdriver.idea.util.JsPsiUtils;
import com.google.jstestdriver.idea.util.ObjectUtils;
import com.intellij.lang.javascript.JSTokenTypes;
import com.intellij.lang.javascript.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JstdTestFileStructureBuilder extends AbstractTestFileStructureBuilder {

  public static final JstdTestFileStructureBuilder INSTANCE = new JstdTestFileStructureBuilder();

  private JstdTestFileStructureBuilder() {}

  @NotNull
  @Override
  public JsTestFileStructure buildTestFileStructure(@NotNull JSFile jsFile) {
    JsTestFileStructure jsTestFileStructure = new JsTestFileStructure(jsFile);
    List<JSElement> jsElements = JsPsiUtils.listJsElementsInExecutionOrder(jsFile);
    for (JSElement jsElement : jsElements) {
      fillJsTestFileStructure(jsTestFileStructure, jsElement);
    }
    return jsTestFileStructure;
  }

  private static void fillJsTestFileStructure(JsTestFileStructure jsTestFileStructure, JSElement jsElement) {
    {
      JSExpressionStatement jsExpressionStatement = CastUtils.tryCast(jsElement, JSExpressionStatement.class);
      if (jsExpressionStatement != null) {
        {
          JSCallExpression callExpression = CastUtils.tryCast(jsExpressionStatement.getExpression(), JSCallExpression.class);
          if (callExpression != null) {
            // TestCase("testCaseName", { test1: function() {} });
            createTestCaseStructure(jsTestFileStructure, callExpression);
          }
        }
        {
          // testCase = TestCase("testCaseName");
          JSAssignmentExpression jsAssignmentExpression = CastUtils.tryCast(jsExpressionStatement.getExpression(), JSAssignmentExpression.class);
          if (jsAssignmentExpression != null) {
            JSCallExpression jsCallExpression = CastUtils.tryCast(jsAssignmentExpression.getROperand(), JSCallExpression.class);
            if (jsCallExpression != null) {
              BaseTestCaseStructure testCaseStructure = createTestCaseStructure(jsTestFileStructure, jsCallExpression);
              if (testCaseStructure != null) {
                JSDefinitionExpression jsDefinitionExpression = CastUtils.tryCast(jsAssignmentExpression.getLOperand(), JSDefinitionExpression.class);
                if (jsDefinitionExpression != null) {
                  JSReferenceExpression jsReferenceExpression = CastUtils.tryCast(jsDefinitionExpression.getExpression(), JSReferenceExpression.class);
                  if (jsReferenceExpression != null) {
                    PsiElement psiElement = JsPsiUtils.resolveUniquely(jsReferenceExpression);
                    JSVariable testCastJsVariable = CastUtils.tryCast(psiElement, JSVariable.class);
                    if (testCastJsVariable != null) {
                      addPrototypeTests(testCaseStructure, testCastJsVariable);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      // var testCase = TestCase("testCaseName");
      JSVarStatement jsVarStatement = CastUtils.tryCast(jsElement, JSVarStatement.class);
      if (jsVarStatement != null) {
        JSVariable[] jsVariables = ObjectUtils.notNull(jsVarStatement.getVariables(), JSVariable.EMPTY_ARRAY);
        for (JSVariable jsVariable : jsVariables) {
          JSCallExpression jsCallExpression = CastUtils.tryCast(jsVariable.getInitializer(), JSCallExpression.class);
          if (jsCallExpression != null) {
            BaseTestCaseStructure testCaseStructure = createTestCaseStructure(jsTestFileStructure, jsCallExpression);
            if (testCaseStructure != null) {
              addPrototypeTests(testCaseStructure, jsVariable);
            }
          }
        }
      }
    }
  }

  private static void addPrototypeTests(@NotNull final BaseTestCaseStructure testCaseStructure, @NotNull final JSVariable jsVariable) {
    Query<PsiReference> referenceQuery = ReferencesSearch.search(jsVariable);
    referenceQuery.forEach(new Processor<PsiReference>() {
      @Override
      public boolean process(PsiReference psiReference) {
        JSReferenceExpression testCaseJsReferenceExpression = CastUtils.tryCast(psiReference, JSReferenceExpression.class);
        if (testCaseJsReferenceExpression != null) {
          JSReferenceExpression prototypeJsReferenceExpression =
            CastUtils.tryCast(testCaseJsReferenceExpression.getParent(), JSReferenceExpression.class);
          if (prototypeJsReferenceExpression != null && "prototype".equals(prototypeJsReferenceExpression.getReferencedName())) {
            JSReferenceExpression testOnPrototypeJsReferenceExpression =
              CastUtils.tryCast(prototypeJsReferenceExpression.getParent(), JSReferenceExpression.class);
            if (testOnPrototypeJsReferenceExpression != null) {
              addPrototypeTest(testCaseStructure, testOnPrototypeJsReferenceExpression);
            }
          }
        }
        return true;
      }
    });
  }

  private static void addPrototypeTest(BaseTestCaseStructure testCaseStructure, JSReferenceExpression testOnPrototypeJsReferenceExpression) {
    JSDefinitionExpression testJsDefinitionExpression =
      CastUtils.tryCast(testOnPrototypeJsReferenceExpression.getParent(), JSDefinitionExpression.class);
    if (testJsDefinitionExpression != null) {
      JSAssignmentExpression testJsAssignmentExpression =
        CastUtils.tryCast(testJsDefinitionExpression.getParent(), JSAssignmentExpression.class);
      if (testJsAssignmentExpression != null) {
        LeafPsiElement testMethodIdentifierPsiElement =
          CastUtils.tryCast(testOnPrototypeJsReferenceExpression.getLastChild(), LeafPsiElement.class);
        if (testMethodIdentifierPsiElement != null &&
            testMethodIdentifierPsiElement.getElementType() == JSTokenTypes.IDENTIFIER) {
          JSFunctionExpression jsFunctionExpression = JsPsiUtils.extractFunctionExpression(
            testJsAssignmentExpression.getROperand()
          );
          JstdTestStructure jstdTestStructure = JstdTestStructure.newPrototypeBasedStructure(testMethodIdentifierPsiElement, jsFunctionExpression);
          testCaseStructure.addTestStructure(jstdTestStructure);
        }
      }
    }
  }

  private static BaseTestCaseStructure createTestCaseStructure(@NotNull JsTestFileStructure jsTestFileStructure,
                                                               @NotNull JSCallExpression testCaseCallExpression) {
    JSReferenceExpression referenceExpression = CastUtils.tryCast(testCaseCallExpression.getMethodExpression(), JSReferenceExpression.class);
    if (referenceExpression != null) {
      String referenceName = referenceExpression.getReferencedName();
      if ("TestCase".equals(referenceName) || "AsyncTestCase".equals(referenceName)) {
        JSArgumentList jsArgumentList = testCaseCallExpression.getArgumentList();
        if (jsArgumentList != null) {
          JSExpression[] arguments = ObjectUtils.notNull(jsArgumentList.getArguments(), JSExpression.EMPTY_ARRAY);
          if (arguments.length >= 1) {
            String testCaseName = JsPsiUtils.extractStringValue(arguments[0]);
            if (testCaseName != null) {
              BaseTestCaseStructure testCaseStructure = new BaseTestCaseStructure(jsTestFileStructure, testCaseName, testCaseCallExpression);
              jsTestFileStructure.addTestCaseStructure(testCaseStructure);
              if (arguments.length >= 2) {
                JSObjectLiteralExpression testsObjectLiteral = JsPsiUtils.extractObjectLiteralExpression(arguments[1]);
                fillTestCaseStructureByObjectLiteral(testCaseStructure, testsObjectLiteral);
              }
              return testCaseStructure;
            }
          }
        }
      }
    }
    return null;
  }

  private static void fillTestCaseStructureByObjectLiteral(
    BaseTestCaseStructure testCaseStructure, JSObjectLiteralExpression testsObjectLiteral
  ) {
    JSProperty[] properties = testsObjectLiteral.getProperties();
    for (JSProperty property : properties) {
      BaseTestStructure testStructure = JstdTestStructure.newPropertyBasedStructure(property);
      if (testStructure != null) {
        testCaseStructure.addTestStructure(testStructure);
      }
    }
  }

}
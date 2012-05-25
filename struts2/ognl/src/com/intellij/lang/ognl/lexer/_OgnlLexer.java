/* The following code was generated by JFlex 1.4.3 on 09.08.11 22:31 */

/* Generated code. Do not modify it. */
package com.intellij.lang.ognl.lexer;

import com.intellij.lang.ognl.psi.OgnlTokenTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 09.08.11 22:31 from the specification file
 * <tt>/Users/yann/idea-ultimate/ultimate/contrib/struts2/plugin/src/com/intellij/lang/ognl/lexer/_OgnlLexer.flex</tt>
 */
public class _OgnlLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int SEQUENCE_EXPRESSION = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\4\1\3\1\15\1\0\1\3\1\15\16\4\4\0\1\41\1\52"+
    "\1\16\1\61\1\1\1\17\1\66\1\13\1\46\1\47\1\64\1\12"+
    "\1\56\1\65\1\10\1\63\1\5\11\2\1\60\1\0\1\54\1\53"+
    "\1\55\1\57\1\62\1\1\1\7\2\1\1\11\2\1\1\6\22\1"+
    "\1\50\1\14\1\51\1\70\1\1\1\0\1\27\1\32\1\45\1\31"+
    "\1\35\1\44\1\40\1\23\1\42\2\1\1\24\1\1\1\30\1\33"+
    "\1\1\1\36\1\25\1\22\1\37\1\26\1\1\1\43\1\34\2\1"+
    "\1\20\1\67\1\21\1\71\41\4\2\0\4\1\4\0\1\1\2\0"+
    "\1\4\7\0\1\1\4\0\1\1\5\0\27\1\1\0\37\1\1\0"+
    "\u013f\1\31\0\162\1\4\0\14\1\16\0\5\1\11\0\1\1\21\0"+
    "\130\4\5\0\23\4\12\0\1\1\13\0\1\1\1\0\3\1\1\0"+
    "\1\1\1\0\24\1\1\0\54\1\1\0\46\1\1\0\5\1\4\0"+
    "\202\1\1\0\4\4\3\0\105\1\1\0\46\1\2\0\2\1\6\0"+
    "\20\1\41\0\46\1\2\0\1\1\7\0\47\1\11\0\21\4\1\0"+
    "\27\4\1\0\3\4\1\0\1\4\1\0\2\4\1\0\1\4\13\0"+
    "\33\1\5\0\3\1\15\0\4\4\14\0\6\4\13\0\32\1\5\0"+
    "\13\1\16\4\7\0\12\4\4\0\2\1\1\4\143\1\1\0\1\1"+
    "\10\4\1\0\6\4\2\1\2\4\1\0\4\4\2\1\12\4\3\1"+
    "\2\0\1\1\17\0\1\4\1\1\1\4\36\1\33\4\2\0\3\1"+
    "\60\0\46\1\13\4\1\1\u014f\0\3\4\66\1\2\0\1\4\1\1"+
    "\20\4\2\0\1\1\4\4\3\0\12\1\2\4\2\0\12\4\21\0"+
    "\3\4\1\0\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0"+
    "\1\1\3\0\4\1\2\0\1\4\1\1\7\4\2\0\2\4\2\0"+
    "\3\4\11\0\1\4\4\0\2\1\1\0\3\1\2\4\2\0\12\4"+
    "\2\1\2\1\15\0\3\4\1\0\6\1\4\0\2\1\2\0\26\1"+
    "\1\0\7\1\1\0\2\1\1\0\2\1\1\0\2\1\2\0\1\4"+
    "\1\0\5\4\4\0\2\4\2\0\3\4\13\0\4\1\1\0\1\1"+
    "\7\0\14\4\3\1\14\0\3\4\1\0\11\1\1\0\3\1\1\0"+
    "\26\1\1\0\7\1\1\0\2\1\1\0\5\1\2\0\1\4\1\1"+
    "\10\4\1\0\3\4\1\0\3\4\2\0\1\1\17\0\2\1\2\4"+
    "\2\0\12\4\1\0\1\1\17\0\3\4\1\0\10\1\2\0\2\1"+
    "\2\0\26\1\1\0\7\1\1\0\2\1\1\0\5\1\2\0\1\4"+
    "\1\1\6\4\3\0\2\4\2\0\3\4\10\0\2\4\4\0\2\1"+
    "\1\0\3\1\4\0\12\4\1\0\1\1\20\0\1\4\1\1\1\0"+
    "\6\1\3\0\3\1\1\0\4\1\3\0\2\1\1\0\1\1\1\0"+
    "\2\1\3\0\2\1\3\0\3\1\3\0\10\1\1\0\3\1\4\0"+
    "\5\4\3\0\3\4\1\0\4\4\11\0\1\4\17\0\11\4\11\0"+
    "\1\1\7\0\3\4\1\0\10\1\1\0\3\1\1\0\27\1\1\0"+
    "\12\1\1\0\5\1\4\0\7\4\1\0\3\4\1\0\4\4\7\0"+
    "\2\4\11\0\2\1\4\0\12\4\22\0\2\4\1\0\10\1\1\0"+
    "\3\1\1\0\27\1\1\0\12\1\1\0\5\1\2\0\1\4\1\1"+
    "\7\4\1\0\3\4\1\0\4\4\7\0\2\4\7\0\1\1\1\0"+
    "\2\1\4\0\12\4\22\0\2\4\1\0\10\1\1\0\3\1\1\0"+
    "\27\1\1\0\20\1\4\0\6\4\2\0\3\4\1\0\4\4\11\0"+
    "\1\4\10\0\2\1\4\0\12\4\22\0\2\4\1\0\22\1\3\0"+
    "\30\1\1\0\11\1\1\0\1\1\2\0\7\1\3\0\1\4\4\0"+
    "\6\4\1\0\1\4\1\0\10\4\22\0\2\4\15\0\60\1\1\4"+
    "\2\1\7\4\4\0\1\1\7\1\10\4\1\0\12\4\47\0\2\1"+
    "\1\0\1\1\2\0\2\1\1\0\1\1\2\0\1\1\6\0\4\1"+
    "\1\0\7\1\1\0\3\1\1\0\1\1\1\0\1\1\2\0\2\1"+
    "\1\0\4\1\1\4\2\1\6\4\1\0\2\4\1\1\2\0\5\1"+
    "\1\0\1\1\1\0\6\4\2\0\12\4\2\0\2\1\42\0\1\1"+
    "\27\0\2\4\6\0\12\4\13\0\1\4\1\0\1\4\1\0\1\4"+
    "\4\0\2\4\10\1\1\0\42\1\6\0\24\4\1\0\2\4\4\1"+
    "\4\0\10\4\1\0\44\4\11\0\1\4\71\0\42\1\1\0\5\1"+
    "\1\0\2\1\1\0\7\4\3\0\4\4\6\0\12\4\6\0\6\1"+
    "\4\4\106\0\46\1\12\0\51\1\7\0\132\1\5\0\104\1\5\0"+
    "\122\1\6\0\7\1\1\0\77\1\1\0\1\1\1\0\4\1\2\0"+
    "\7\1\1\0\1\1\1\0\4\1\2\0\47\1\1\0\1\1\1\0"+
    "\4\1\2\0\37\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0"+
    "\1\1\1\0\4\1\2\0\7\1\1\0\7\1\1\0\27\1\1\0"+
    "\37\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0\47\1\1\0"+
    "\23\1\16\0\11\4\56\0\125\1\14\0\u026c\1\2\0\10\1\12\0"+
    "\32\1\5\0\113\1\3\0\3\1\17\0\15\1\1\0\4\1\3\4"+
    "\13\0\22\1\3\4\13\0\22\1\2\4\14\0\15\1\1\0\3\1"+
    "\1\0\2\4\14\0\64\1\40\4\3\0\1\1\3\0\1\1\1\1"+
    "\1\4\2\0\12\4\41\0\3\4\2\0\12\4\6\0\130\1\10\0"+
    "\51\1\1\4\126\0\35\1\3\0\14\4\4\0\14\4\12\0\12\4"+
    "\36\1\2\0\5\1\u038b\0\154\1\224\0\234\1\4\0\132\1\6\0"+
    "\26\1\2\0\6\1\2\0\46\1\2\0\6\1\2\0\10\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\37\1\2\0\65\1\1\0"+
    "\7\1\1\0\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0"+
    "\6\1\4\0\15\1\5\0\3\1\1\0\7\1\17\0\4\4\32\0"+
    "\5\4\20\0\2\1\23\0\1\1\13\0\4\4\6\0\6\4\1\0"+
    "\1\1\15\0\1\1\40\0\22\1\36\0\15\4\4\0\1\4\3\0"+
    "\6\4\27\0\1\1\4\0\1\1\2\0\12\1\1\0\1\1\3\0"+
    "\5\1\6\0\1\1\1\0\1\1\1\0\1\1\1\0\4\1\1\0"+
    "\3\1\1\0\7\1\3\0\3\1\5\0\5\1\26\0\44\1\u0e81\0"+
    "\2\1\1\1\31\0\11\1\6\4\1\0\5\1\2\0\3\1\2\1"+
    "\4\0\126\1\2\0\2\4\2\0\3\1\1\0\132\1\1\1\4\1"+
    "\5\0\50\1\4\0\136\1\21\0\30\1\70\0\20\1\u0200\0\u19b6\1"+
    "\112\0\u51a6\1\132\0\u048d\1\u0773\0\u2ba4\1\u215c\0\u012e\1\2\0\73\1"+
    "\225\0\7\1\14\0\5\1\5\0\1\1\1\4\12\1\1\0\15\1"+
    "\1\0\5\1\1\0\1\1\1\0\2\1\1\0\2\1\1\0\154\1"+
    "\41\0\u016b\1\22\0\100\1\2\0\66\1\50\0\14\1\1\1\3\0"+
    "\20\4\20\0\4\4\17\0\2\1\30\0\3\1\31\0\1\1\6\0"+
    "\5\1\1\0\207\1\2\0\1\4\4\0\1\1\13\0\12\4\7\0"+
    "\32\1\4\0\1\1\1\0\32\1\12\0\1\1\131\1\3\0\6\1"+
    "\2\0\6\1\2\0\6\1\2\0\3\1\3\0\2\1\3\0\2\1"+
    "\22\0\3\4\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\3\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\15\2\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\11\1\40\1\41\2\42\1\0\2\7"+
    "\2\10\1\43\1\2\1\44\7\2\1\45\1\2\1\46"+
    "\1\2\1\47\1\50\1\2\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\42\1\62\1\63"+
    "\1\64\1\2\1\65\1\2\1\66\1\67\1\70\1\2"+
    "\1\71\1\72\1\2\1\73\2\2\1\74\1\75\1\76"+
    "\1\0\1\77\1\100\2\2\1\0\1\2\1\101\1\102"+
    "\4\2\1\103";

  private static int [] zzUnpackAction() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\72\0\164\0\256\0\350\0\u0122\0\u015c\0\u0196"+
    "\0\164\0\u01d0\0\u020a\0\u0244\0\164\0\164\0\u027e\0\u02b8"+
    "\0\u02f2\0\u032c\0\u0366\0\u03a0\0\u03da\0\u0414\0\u044e\0\u0488"+
    "\0\u04c2\0\u04fc\0\u0536\0\164\0\164\0\164\0\164\0\u0570"+
    "\0\u05aa\0\u05e4\0\u061e\0\164\0\164\0\164\0\164\0\164"+
    "\0\164\0\164\0\164\0\u0658\0\u0692\0\164\0\164\0\164"+
    "\0\164\0\164\0\u06cc\0\u0706\0\u0740\0\164\0\u077a\0\u07b4"+
    "\0\164\0\164\0\u07ee\0\u0828\0\u0862\0\u089c\0\u08d6\0\u0910"+
    "\0\u094a\0\u0984\0\u09be\0\256\0\u09f8\0\256\0\u0a32\0\u0a6c"+
    "\0\u0aa6\0\u0ae0\0\164\0\164\0\164\0\164\0\164\0\u0b1a"+
    "\0\164\0\164\0\164\0\u0b54\0\256\0\256\0\256\0\u0b8e"+
    "\0\256\0\u0bc8\0\u0c02\0\256\0\256\0\u0c3c\0\256\0\256"+
    "\0\u0c76\0\256\0\u0cb0\0\u0cea\0\164\0\256\0\256\0\u0d24"+
    "\0\256\0\256\0\u0d5e\0\u0d98\0\u0dd2\0\u0e0c\0\256\0\164"+
    "\0\u0e46\0\u0e80\0\u0eba\0\u0ef4\0\256";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\3\1\7\2\4\1\10"+
    "\1\4\1\11\1\12\1\3\1\6\1\13\1\14\1\15"+
    "\1\16\1\17\1\4\1\20\1\4\1\21\1\22\1\23"+
    "\1\4\1\24\1\25\1\26\1\27\1\4\1\30\1\31"+
    "\1\6\1\32\1\4\1\33\1\4\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\3\1\4\1\5\1\6\1\3\1\7\2\4"+
    "\1\10\1\4\1\11\1\12\1\3\1\6\1\13\1\60"+
    "\1\15\1\61\1\17\1\4\1\20\1\4\1\21\1\22"+
    "\1\23\1\4\1\24\1\25\1\26\1\27\1\4\1\30"+
    "\1\31\1\6\1\32\1\4\1\33\1\4\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
    "\1\56\1\57\73\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\17\4\1\0\4\4\26\0\1\5\2\0\1\5"+
    "\1\62\1\0\1\63\1\64\11\0\1\62\11\0\1\64"+
    "\37\0\1\6\11\0\1\6\23\0\1\6\32\0\1\65"+
    "\2\0\1\65\1\62\1\0\1\63\1\64\11\0\1\62"+
    "\11\0\1\64\36\0\1\63\2\0\1\63\64\0\13\12"+
    "\1\66\1\67\1\0\54\12\14\13\1\70\1\0\1\71"+
    "\53\13\20\0\1\72\52\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\1\4\1\73\15\4\1\0\4\4\25\0"+
    "\2\4\1\0\4\4\1\0\1\4\10\0\15\4\1\74"+
    "\1\4\1\0\4\4\25\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\1\75\16\4\1\0\4\4\25\0\2\4"+
    "\1\0\4\4\1\0\1\4\10\0\6\4\1\76\10\4"+
    "\1\0\4\4\25\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\4\4\1\77\4\4\1\100\1\4\1\101\3\4"+
    "\1\0\4\4\25\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\5\4\1\102\3\4\1\103\5\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\3\4"+
    "\1\104\13\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\11\4\1\105\5\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\14\4"+
    "\1\106\2\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\3\4\1\107\13\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\15\4"+
    "\1\110\1\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\6\4\1\111\10\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\5\4"+
    "\1\112\11\4\1\0\4\4\77\0\1\113\71\0\1\114"+
    "\71\0\1\115\1\116\70\0\1\117\1\0\1\120\102\0"+
    "\1\121\72\0\1\122\4\0\1\63\2\0\1\63\1\0"+
    "\1\123\1\0\1\64\20\0\1\123\2\0\1\64\36\0"+
    "\1\124\2\0\1\124\1\0\1\123\2\0\1\124\17\0"+
    "\1\123\32\0\1\124\6\0\1\65\2\0\1\65\2\0"+
    "\1\63\1\64\23\0\1\64\34\0\15\12\1\0\54\12"+
    "\15\13\1\0\54\13\1\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\2\4\1\125\1\126\13\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\13\4"+
    "\1\127\3\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\1\4\1\130\15\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\7\4"+
    "\1\131\7\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\2\4\1\132\14\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\15\4"+
    "\1\133\1\4\1\0\4\4\25\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\14\4\1\134\2\4\1\0\1\4"+
    "\1\135\2\4\25\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\6\4\1\136\10\4\1\0\4\4\25\0\2\4"+
    "\1\0\4\4\1\0\1\4\10\0\3\4\1\137\13\4"+
    "\1\0\4\4\25\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\3\4\1\140\13\4\1\0\4\4\25\0\2\4"+
    "\1\0\4\4\1\0\1\4\10\0\4\4\1\141\12\4"+
    "\1\0\4\4\25\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\13\4\1\142\3\4\1\0\4\4\25\0\2\4"+
    "\1\0\4\4\1\0\1\4\10\0\1\143\16\4\1\0"+
    "\4\4\25\0\2\4\1\0\4\4\1\0\1\4\10\0"+
    "\2\4\1\144\14\4\1\0\4\4\101\0\1\145\16\0"+
    "\1\124\2\0\1\124\1\0\1\123\22\0\1\123\40\0"+
    "\2\4\1\0\4\4\1\0\1\4\10\0\3\4\1\146"+
    "\13\4\1\0\4\4\25\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\2\4\1\147\14\4\1\0\4\4\25\0"+
    "\2\4\1\0\4\4\1\0\1\4\10\0\17\4\1\150"+
    "\4\4\25\0\2\4\1\0\4\4\1\0\1\4\10\0"+
    "\7\4\1\151\7\4\1\0\4\4\25\0\2\4\1\0"+
    "\4\4\1\0\1\4\10\0\13\4\1\152\3\4\1\0"+
    "\4\4\25\0\2\4\1\0\4\4\1\0\1\4\10\0"+
    "\15\4\1\153\1\4\1\0\4\4\25\0\2\4\1\0"+
    "\4\4\1\0\1\4\10\0\1\154\16\4\1\0\4\4"+
    "\66\0\1\155\30\0\2\4\1\0\4\4\1\0\1\4"+
    "\10\0\5\4\1\156\11\4\1\0\4\4\25\0\2\4"+
    "\1\0\4\4\1\0\1\4\10\0\13\4\1\157\3\4"+
    "\1\0\4\4\54\0\1\160\42\0\2\4\1\0\4\4"+
    "\1\0\1\4\10\0\6\4\1\161\10\4\1\0\4\4"+
    "\25\0\2\4\1\0\4\4\1\0\1\4\10\0\17\4"+
    "\1\0\3\4\1\162\25\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\13\4\1\163\3\4\1\0\4\4\25\0"+
    "\2\4\1\0\4\4\1\0\1\4\10\0\11\4\1\164"+
    "\5\4\1\0\4\4\25\0\2\4\1\0\4\4\1\0"+
    "\1\4\10\0\17\4\1\0\2\4\1\165\1\4\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3886];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\5\1\1\11\3\1\2\11\15\1\4\11"+
    "\4\1\10\11\2\1\5\11\2\1\1\0\1\11\2\1"+
    "\2\11\20\1\5\11\1\1\3\11\21\1\1\11\2\1"+
    "\1\0\4\1\1\0\2\1\1\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _OgnlLexer(){
    this((java.io.Reader)null);
  }


  public _OgnlLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public _OgnlLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1786) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 65: 
          { return OgnlTokenTypes.FALSE_KEYWORD;
          }
        case 68: break;
        case 47: 
          { return OgnlTokenTypes.AND_AND;
          }
        case 69: break;
        case 37: 
          { return OgnlTokenTypes.OR_KEYWORD;
          }
        case 70: break;
        case 4: 
          { return OgnlTokenTypes.WHITE_SPACE;
          }
        case 71: break;
        case 7: 
          { return OgnlTokenTypes.CHARACTER_LITERAL;
          }
        case 72: break;
        case 1: 
          { return OgnlTokenTypes.BAD_CHARACTER;
          }
        case 73: break;
        case 36: 
          { return OgnlTokenTypes.LT_KEYWORD;
          }
        case 74: break;
        case 32: 
          { yybegin(YYINITIAL); return OgnlTokenTypes.RBRACE;
          }
        case 75: break;
        case 58: 
          { return OgnlTokenTypes.XOR_KEYWORD;
          }
        case 76: break;
        case 44: 
          { return OgnlTokenTypes.SHIFT_LEFT;
          }
        case 77: break;
        case 54: 
          { return OgnlTokenTypes.NOT_KEYWORD;
          }
        case 78: break;
        case 9: 
          { return OgnlTokenTypes.MODULO;
          }
        case 79: break;
        case 15: 
          { return OgnlTokenTypes.RBRACKET;
          }
        case 80: break;
        case 17: 
          { return OgnlTokenTypes.EQ;
          }
        case 81: break;
        case 11: 
          { return OgnlTokenTypes.EXPRESSION_END;
          }
        case 82: break;
        case 55: 
          { return OgnlTokenTypes.NEQ_KEYWORD;
          }
        case 83: break;
        case 30: 
          { return OgnlTokenTypes.XOR;
          }
        case 84: break;
        case 49: 
          { return OgnlTokenTypes.BIG_DECIMAL_LITERAL;
          }
        case 85: break;
        case 26: 
          { return OgnlTokenTypes.MULTIPLY;
          }
        case 86: break;
        case 12: 
          { return OgnlTokenTypes.LPARENTH;
          }
        case 87: break;
        case 57: 
          { return OgnlTokenTypes.BOR_KEYWORD;
          }
        case 88: break;
        case 52: 
          { return OgnlTokenTypes.LT_EQ_KEYWORD;
          }
        case 89: break;
        case 3: 
          { return OgnlTokenTypes.INTEGER_LITERAL;
          }
        case 90: break;
        case 6: 
          { return OgnlTokenTypes.PLUS;
          }
        case 91: break;
        case 16: 
          { return OgnlTokenTypes.NEGATE;
          }
        case 92: break;
        case 5: 
          { return OgnlTokenTypes.DOT;
          }
        case 93: break;
        case 48: 
          { return OgnlTokenTypes.OR_OR;
          }
        case 94: break;
        case 66: 
          { return OgnlTokenTypes.NOT_IN_KEYWORD;
          }
        case 95: break;
        case 20: 
          { return OgnlTokenTypes.COMMA;
          }
        case 96: break;
        case 56: 
          { return OgnlTokenTypes.NEW_KEYWORD;
          }
        case 97: break;
        case 53: 
          { return OgnlTokenTypes.AND_KEYWORD;
          }
        case 98: break;
        case 28: 
          { return OgnlTokenTypes.AND;
          }
        case 99: break;
        case 31: 
          { return OgnlTokenTypes.NOT;
          }
        case 100: break;
        case 38: 
          { return OgnlTokenTypes.EQ_KEYWORD;
          }
        case 101: break;
        case 35: 
          { return OgnlTokenTypes.EXPRESSION_START;
          }
        case 102: break;
        case 25: 
          { return OgnlTokenTypes.DIVISION;
          }
        case 103: break;
        case 22: 
          { return OgnlTokenTypes.COLON;
          }
        case 104: break;
        case 46: 
          { return OgnlTokenTypes.SHIFT_RIGHT;
          }
        case 105: break;
        case 19: 
          { return OgnlTokenTypes.GREATER;
          }
        case 106: break;
        case 67: 
          { return OgnlTokenTypes.INSTANCEOF_KEYWORD;
          }
        case 107: break;
        case 2: 
          { return OgnlTokenTypes.IDENTIFIER;
          }
        case 108: break;
        case 40: 
          { return OgnlTokenTypes.IN_KEYWORD;
          }
        case 109: break;
        case 8: 
          { return OgnlTokenTypes.STRING_LITERAL;
          }
        case 110: break;
        case 14: 
          { return OgnlTokenTypes.LBRACKET;
          }
        case 111: break;
        case 51: 
          { return OgnlTokenTypes.SHIFT_RIGHT_KEYWORD;
          }
        case 112: break;
        case 24: 
          { return OgnlTokenTypes.AT;
          }
        case 113: break;
        case 59: 
          { return OgnlTokenTypes.GT_EQ_KEYWORD;
          }
        case 114: break;
        case 50: 
          { return OgnlTokenTypes.SHIFT_LEFT_KEYWORD;
          }
        case 115: break;
        case 29: 
          { return OgnlTokenTypes.OR;
          }
        case 116: break;
        case 60: 
          { return OgnlTokenTypes.SHIFT_RIGHT_LOGICAL;
          }
        case 117: break;
        case 43: 
          { return OgnlTokenTypes.LESS_EQUAL;
          }
        case 118: break;
        case 62: 
          { return OgnlTokenTypes.NULL_KEYWORD;
          }
        case 119: break;
        case 27: 
          { return OgnlTokenTypes.MINUS;
          }
        case 120: break;
        case 18: 
          { return OgnlTokenTypes.LESS;
          }
        case 121: break;
        case 63: 
          { return OgnlTokenTypes.BAND_KEYWORD;
          }
        case 122: break;
        case 45: 
          { return OgnlTokenTypes.GREATER_EQUAL;
          }
        case 123: break;
        case 21: 
          { return OgnlTokenTypes.QUESTION;
          }
        case 124: break;
        case 34: 
          { return OgnlTokenTypes.DOUBLE_LITERAL;
          }
        case 125: break;
        case 64: 
          { return OgnlTokenTypes.TRUE_KEYWORD;
          }
        case 126: break;
        case 23: 
          { return OgnlTokenTypes.HASH;
          }
        case 127: break;
        case 13: 
          { return OgnlTokenTypes.RPARENTH;
          }
        case 128: break;
        case 61: 
          { return OgnlTokenTypes.SHIFT_RIGHT_LOGICAL_KEYWORD;
          }
        case 129: break;
        case 10: 
          { yybegin(SEQUENCE_EXPRESSION); return OgnlTokenTypes.LBRACE;
          }
        case 130: break;
        case 42: 
          { return OgnlTokenTypes.EQUAL;
          }
        case 131: break;
        case 39: 
          { return OgnlTokenTypes.GT_KEYWORD;
          }
        case 132: break;
        case 33: 
          { return OgnlTokenTypes.BIG_INTEGER_LITERAL;
          }
        case 133: break;
        case 41: 
          { return OgnlTokenTypes.NOT_EQUAL;
          }
        case 134: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
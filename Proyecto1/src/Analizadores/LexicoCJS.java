/* The following code was generated by JFlex 1.5.0-SNAPSHOT */

/*
* Area de imports
**/

package Analizadores;
import java_cup.sym;
import java_cup.runtime.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.5.0-SNAPSHOT
 * from the specification file <tt>src/Analizadores/lexico3.jflex</tt>
 */
public class LexicoCJS implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int CADENA = 2;
  public static final int COMENTARIO = 4;
  public static final int COMENTARIO_MULTI = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\64\1\62\1\65\1\63\1\61\22\0\1\64\1\30\1\60"+
    "\2\0\1\25\1\27\1\4\1\7\1\10\1\22\1\20\1\15\1\21"+
    "\1\2\1\23\12\1\1\16\1\17\1\32\1\6\1\31\2\0\1\37"+
    "\1\55\1\53\1\36\1\34\1\41\1\3\1\57\1\46\1\52\1\3"+
    "\1\42\1\47\1\51\1\40\1\56\1\3\1\35\1\44\1\50\1\54"+
    "\1\33\4\3\1\11\1\0\1\12\1\24\1\5\1\0\1\37\1\55"+
    "\1\53\1\36\1\34\1\41\1\3\1\57\1\46\1\52\1\3\1\42"+
    "\1\47\1\51\1\40\1\56\1\3\1\35\1\44\1\50\1\54\1\33"+
    "\4\3\1\13\1\26\1\14\7\0\1\65\113\0\1\3\37\0\1\3"+
    "\76\0\2\45\115\0\1\43\u1ea8\0\1\65\1\65\udfd6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\2\1\1\26"+
    "\1\27\1\30\5\4\1\1\1\4\1\1\5\4\1\31"+
    "\2\32\1\33\1\34\1\35\2\0\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\4\4"+
    "\1\0\4\4\1\0\1\50\1\4\1\50\1\0\2\4"+
    "\1\0\4\4\1\0\1\51\1\52\5\4\1\0\1\4"+
    "\1\0\4\4\3\0\3\4\1\0\2\4\1\0\1\4"+
    "\1\0\3\4\1\0\5\4\2\53\1\0\2\4\1\0"+
    "\2\4\2\0\1\54\2\4\1\54\1\0\1\4\1\0"+
    "\1\4\1\0\1\4\2\55\1\56\1\4\1\0\5\4"+
    "\1\0\2\4\2\57\1\0\1\4\2\0\2\4\1\0"+
    "\1\4\1\0\1\4\1\0\1\4\1\60\1\0\5\4"+
    "\1\0\2\4\1\0\1\4\2\0\2\4\1\0\1\4"+
    "\1\0\1\4\1\0\3\4\1\61\1\62\1\4\1\0"+
    "\1\4\1\63\2\64\2\0\2\4\1\0\1\4\2\65"+
    "\1\0\2\4\1\66\1\4\1\0\1\4\2\0\2\4"+
    "\2\67\2\70\1\71\1\72\1\0\1\4\2\0\2\4"+
    "\2\73\1\74\1\0\1\74\1\4\2\75";

  private static int [] zzUnpackAction() {
    int [] result = new int[236];
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
    "\0\0\0\66\0\154\0\242\0\330\0\u010e\0\330\0\u0144"+
    "\0\u017a\0\u01b0\0\330\0\330\0\330\0\330\0\330\0\330"+
    "\0\330\0\330\0\330\0\u01e6\0\u021c\0\330\0\330\0\330"+
    "\0\330\0\u0252\0\u0288\0\u02be\0\u02f4\0\u032a\0\u0360\0\u0396"+
    "\0\u03cc\0\u0402\0\u0438\0\u046e\0\u04a4\0\u04da\0\u0510\0\u0546"+
    "\0\u057c\0\u05b2\0\u05e8\0\330\0\u061e\0\330\0\330\0\330"+
    "\0\330\0\u0654\0\u068a\0\u068a\0\330\0\330\0\330\0\330"+
    "\0\330\0\330\0\330\0\330\0\330\0\u06c0\0\u06f6\0\u072c"+
    "\0\u0762\0\u0798\0\u07ce\0\u0804\0\u083a\0\u0870\0\u08a6\0\u08dc"+
    "\0\u0912\0\u0948\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u0a56\0\u0a8c"+
    "\0\u0ac2\0\u0af8\0\u0b2e\0\u0654\0\330\0\u0b64\0\u0b9a\0\u0bd0"+
    "\0\u0c06\0\u0c3c\0\u0c72\0\u0ca8\0\u0cde\0\u0d14\0\u0d4a\0\u0d80"+
    "\0\u0db6\0\u0dec\0\u0e22\0\u0e58\0\u0e8e\0\u0ec4\0\u0efa\0\u0f30"+
    "\0\u0f66\0\u0f9c\0\u0fd2\0\u1008\0\u103e\0\u1074\0\u10aa\0\u10e0"+
    "\0\u1116\0\u114c\0\u1182\0\u11b8\0\u11ee\0\u1224\0\330\0\u0144"+
    "\0\u125a\0\u1290\0\u12c6\0\u12fc\0\u1332\0\u1368\0\u139e\0\u13d4"+
    "\0\330\0\u140a\0\u1440\0\u0144\0\u1476\0\u14ac\0\u14e2\0\u1518"+
    "\0\u154e\0\u1584\0\330\0\u0144\0\u0144\0\u15ba\0\u15f0\0\u1626"+
    "\0\u165c\0\u1692\0\u16c8\0\u16fe\0\u1734\0\u176a\0\u17a0\0\330"+
    "\0\u0144\0\u17d6\0\u180c\0\u1842\0\u1878\0\u18ae\0\u18e4\0\u191a"+
    "\0\u1950\0\u1986\0\u19bc\0\u19f2\0\u1a28\0\u0144\0\u1a5e\0\u1a94"+
    "\0\u1aca\0\u1b00\0\u1b36\0\u1b6c\0\u1ba2\0\u1bd8\0\u1c0e\0\u1c44"+
    "\0\u1c7a\0\u1cb0\0\u1ce6\0\u1d1c\0\u1d52\0\u1d88\0\u1dbe\0\u1df4"+
    "\0\u1e2a\0\u1e60\0\u1e96\0\u1ecc\0\u1f02\0\u0144\0\u0144\0\u1f38"+
    "\0\u1f6e\0\u1fa4\0\u0144\0\330\0\u0144\0\u1fda\0\u2010\0\u2046"+
    "\0\u207c\0\u20b2\0\u20e8\0\330\0\u0144\0\u211e\0\u2154\0\u218a"+
    "\0\u0144\0\u21c0\0\u21f6\0\u222c\0\u2262\0\u2298\0\u22ce\0\u2304"+
    "\0\330\0\u0144\0\330\0\u0144\0\u0144\0\u0144\0\u233a\0\u2370"+
    "\0\u23a6\0\u23dc\0\u2412\0\u2448\0\330\0\u0144\0\330\0\u247e"+
    "\0\u0144\0\u24b4\0\330\0\u0144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[236];
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
    "\1\5\1\6\1\7\1\10\1\11\1\5\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\10\1\40\1\41\1\10"+
    "\1\42\1\43\1\10\1\44\1\45\1\46\1\47\1\50"+
    "\3\10\1\51\2\10\1\52\1\53\1\54\1\55\3\56"+
    "\1\0\60\57\1\60\5\57\62\56\1\61\7\56\1\61"+
    "\54\56\3\0\1\56\70\0\1\6\1\62\64\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\10\10\1\0\1\10"+
    "\1\0\12\10\6\0\4\63\1\0\16\63\1\64\42\63"+
    "\6\0\1\65\77\0\1\66\66\0\1\67\72\0\1\70"+
    "\65\0\1\71\1\72\44\0\1\73\65\0\1\74\65\0"+
    "\1\75\60\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\1\10\1\76\6\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\77"+
    "\6\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\1\10\1\100\3\10\1\101"+
    "\2\10\1\0\1\10\1\102\1\103\11\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\10\10\1\0\1\10"+
    "\1\0\7\10\1\104\2\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\4\10\1\105\3\10\1\0\1\10"+
    "\1\0\6\10\1\106\3\10\42\0\1\107\10\0\2\110"+
    "\20\0\1\10\1\0\1\10\1\0\1\10\25\0\1\10"+
    "\1\111\6\10\1\0\1\10\1\110\1\112\11\10\55\0"+
    "\1\113\17\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\10\10\1\0\1\10\1\0\1\10\1\114\10\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\115"+
    "\6\10\1\0\1\10\1\116\1\117\11\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\4\10\1\120\3\10"+
    "\1\0\1\10\1\0\12\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\4\10\1\121\3\10\1\0\1\10"+
    "\1\0\12\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\4\10\1\122\3\10\1\0\1\10\1\0\12\10"+
    "\34\0\1\123\40\0\1\124\70\0\1\125\62\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\2\10\1\126\5\10"+
    "\1\0\1\10\1\0\12\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\2\10"+
    "\1\127\7\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\6\10\1\130\1\10\1\0\1\10\1\0\2\10"+
    "\1\131\7\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\10\10\1\0\1\10\1\0\5\10\1\132\4\10"+
    "\55\0\1\133\17\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\10\10\1\0\1\10\1\0\1\10\1\134\10\10"+
    "\7\0\1\10\1\0\1\10\1\0\1\10\25\0\10\10"+
    "\1\135\1\136\1\0\2\10\1\137\7\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\7\10\1\140\1\0"+
    "\1\10\1\0\12\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\10\10\1\0\1\10\1\0\3\10\1\141"+
    "\6\10\50\0\1\142\5\0\1\143\66\0\1\144\15\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\7\10\1\145"+
    "\1\0\1\10\1\0\2\10\1\146\7\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\10\10\1\0\1\10"+
    "\1\0\3\10\1\147\6\10\64\0\1\150\10\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\10\10\1\0\1\10"+
    "\1\0\10\10\1\151\1\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\3\10"+
    "\1\152\6\10\42\0\1\153\32\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\1\10\1\154\6\10\1\0\1\10"+
    "\1\0\12\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\10\10\1\155\1\156\1\0\12\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\2\10\1\157\5\10"+
    "\1\0\1\10\1\0\12\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\5\10"+
    "\1\160\4\10\70\0\1\161\4\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\3\10\1\162\4\10\1\0\1\10"+
    "\1\0\12\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\5\10\1\163\2\10\1\0\1\10\1\0\12\10"+
    "\7\0\1\10\1\0\1\10\1\0\1\10\25\0\1\10"+
    "\1\164\6\10\1\0\1\10\1\0\12\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\1\10\1\165\6\10"+
    "\1\0\1\10\1\0\12\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\6\10"+
    "\1\166\3\10\41\0\1\167\33\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\1\170\7\10\1\0\1\10\1\0"+
    "\12\10\42\0\1\171\32\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\1\10\1\172\6\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\1\10\1\173\6\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\174"+
    "\1\175\1\0\12\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\10\10\1\0\1\10\1\0\5\10\1\176"+
    "\4\10\42\0\1\177\65\0\1\200\71\0\1\201\26\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\202"+
    "\6\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\1\10\1\203\6\10\1\0"+
    "\1\10\1\0\12\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\5\10\1\204\2\10\1\0\1\10\1\0"+
    "\12\10\43\0\1\205\31\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\2\10\1\206\5\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\10\10\1\207\1\210\1\0\12\10\57\0\1\211\15\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\3\10\1\212\6\10\46\0\1\213\26\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\214"+
    "\2\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\4\10\1\215\3\10\1\0"+
    "\1\10\1\0\12\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\1\10\1\216\6\10\1\0\1\10\1\0"+
    "\12\10\34\0\1\217\40\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\4\10\1\220\3\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\2\10\1\221\5\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\5\10\1\222\4\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\10\10\1\0\1\10\1\0"+
    "\3\10\1\223\6\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\10\10\1\0\1\10\1\0\1\10\1\224"+
    "\10\10\43\0\1\225\31\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\2\10\1\226\5\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\10\10\1\0\1\10\1\0\3\10\1\227\6\10\46\0"+
    "\1\230\26\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\5\10\1\231\2\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\232\1\233\11\10\61\0\1\234\54\0\1\235"+
    "\24\0\1\10\1\0\1\10\1\0\1\10\25\0\10\10"+
    "\1\0\1\10\1\0\5\10\1\236\4\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\7\10\1\237\1\0"+
    "\1\10\1\0\12\10\53\0\2\240\20\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\10\10\1\0\1\10\1\240"+
    "\1\241\11\10\45\0\1\242\27\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\4\10\1\243\3\10\1\0\1\10"+
    "\1\0\12\10\56\0\1\244\16\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\2\10"+
    "\1\245\7\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\2\10\1\246\5\10\1\0\1\10\1\0\12\10"+
    "\67\0\1\247\5\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\3\10\1\250\4\10\1\0\1\10\1\0\12\10"+
    "\7\0\1\10\1\0\1\10\1\0\1\10\25\0\10\10"+
    "\1\0\1\10\1\0\3\10\1\251\6\10\7\0\1\10"+
    "\1\0\1\10\1\0\1\10\25\0\10\10\1\0\1\10"+
    "\1\0\2\10\1\252\7\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\1\10\1\253\6\10\1\0\1\10"+
    "\1\0\12\10\7\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\1\10\1\254\6\10\1\0\1\10\1\0\12\10"+
    "\41\0\1\255\33\0\1\10\1\0\1\10\1\0\1\10"+
    "\25\0\1\256\7\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\257"+
    "\6\10\1\0\1\10\1\0\12\10\46\0\1\260\26\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\261"+
    "\2\10\1\0\1\10\1\0\12\10\61\0\1\262\46\0"+
    "\1\263\32\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\10\10\1\0\1\10\1\0\5\10\1\264\4\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\265"+
    "\6\10\1\0\1\10\1\0\12\10\55\0\1\266\17\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\1\10\1\267\10\10\60\0\1\270\14\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\4\10\1\271\5\10\43\0\1\272\31\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\2\10\1\273"+
    "\5\10\1\0\1\10\1\0\12\10\70\0\1\56\4\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\1\10\1\274"+
    "\6\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\4\10\1\275\3\10\1\0"+
    "\1\10\1\0\12\10\7\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\5\10\1\276\2\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\2\10\1\277\5\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\3\10\1\300\6\10\45\0\1\301\27\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\4\10\1\302"+
    "\3\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\2\10\1\303\5\10\1\0"+
    "\1\10\1\0\12\10\57\0\1\304\15\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\10\10\1\0\1\10\1\0"+
    "\3\10\1\305\6\10\53\0\2\306\66\0\1\307\17\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\306\1\310\11\10\7\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\0\1\10"+
    "\1\311\10\10\53\0\2\312\20\0\1\10\1\0\1\10"+
    "\1\0\1\10\25\0\10\10\1\0\1\10\1\312\1\313"+
    "\11\10\42\0\1\314\32\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\1\10\1\315\6\10\1\0\1\10\1\0"+
    "\12\10\45\0\1\316\27\0\1\10\1\0\1\10\1\0"+
    "\1\10\25\0\4\10\1\317\3\10\1\0\1\10\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\2\10\1\320\5\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\2\10\1\321"+
    "\5\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\10\10\1\0\1\10\1\0"+
    "\2\10\1\322\7\10\44\0\1\323\30\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\3\10\1\324\4\10\1\0"+
    "\1\10\1\0\12\10\46\0\1\325\61\0\1\326\32\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\327"+
    "\2\10\1\0\1\10\1\0\12\10\7\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\1\10\1\330\6\10\1\0"+
    "\1\10\1\0\12\10\43\0\1\331\31\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\2\10\1\332\5\10\1\0"+
    "\1\10\1\0\12\10\51\0\2\333\22\0\1\10\1\0"+
    "\1\10\1\0\1\10\25\0\10\10\1\333\1\334\1\0"+
    "\12\10\7\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\5\10\1\335\2\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\336"+
    "\2\10\1\0\1\10\1\0\12\10\46\0\1\337\26\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\340"+
    "\2\10\1\0\1\10\1\0\12\10\57\0\1\341\65\0"+
    "\1\342\15\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\10\10\1\0\1\10\1\0\3\10\1\343\6\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\3\10\1\344\6\10\43\0\1\345\31\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\2\10\1\346"+
    "\5\10\1\0\1\10\1\0\12\10\45\0\1\347\76\0"+
    "\1\350\16\0\1\10\1\0\1\10\1\0\1\10\25\0"+
    "\4\10\1\351\3\10\1\0\1\10\1\0\12\10\7\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\10\10\1\0"+
    "\1\10\1\0\2\10\1\352\7\10\46\0\1\353\26\0"+
    "\1\10\1\0\1\10\1\0\1\10\25\0\5\10\1\354"+
    "\2\10\1\0\1\10\1\0\12\10\6\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9450];
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
    "\4\0\1\11\1\1\1\11\3\1\11\11\2\1\4\11"+
    "\22\1\1\11\1\1\4\11\2\0\1\1\11\11\4\1"+
    "\1\0\4\1\1\0\3\1\1\0\2\1\1\0\4\1"+
    "\1\0\1\1\1\11\5\1\1\0\1\1\1\0\4\1"+
    "\3\0\3\1\1\0\2\1\1\0\1\1\1\0\3\1"+
    "\1\0\5\1\1\11\1\1\1\0\2\1\1\0\2\1"+
    "\2\0\1\11\3\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\11\3\1\1\0\5\1\1\0\2\1\1\11"+
    "\1\1\1\0\1\1\2\0\2\1\1\0\1\1\1\0"+
    "\1\1\1\0\2\1\1\0\5\1\1\0\2\1\1\0"+
    "\1\1\2\0\2\1\1\0\1\1\1\0\1\1\1\0"+
    "\6\1\1\0\2\1\1\11\1\1\2\0\2\1\1\0"+
    "\1\1\1\11\1\1\1\0\4\1\1\0\1\1\2\0"+
    "\2\1\1\11\1\1\1\11\3\1\1\0\1\1\2\0"+
    "\2\1\1\11\1\1\1\11\1\0\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[236];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	String cadena = "";


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicoCJS(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LexicoCJS(java.io.InputStream in) {
    this(new java.io.InputStreamReader
             (in, java.nio.charset.Charset.forName("UTF-8")));
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
    while (i < 196) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

    // numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
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
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
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
    return zzBuffer[zzStartRead+pos];
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
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
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
        case 1: 
          { javax.swing.JOptionPane.showMessageDialog(null, "Error Lexico: " + yytext());
          }
        case 62: break;
        case 2: 
          { return new Symbol(SimbolosCJS.valEntero, yycolumn, yyline, new String(yytext()));
          }
        case 63: break;
        case 3: 
          { return new Symbol(SimbolosCJS.punto, yycolumn, yyline, new String(yytext()));
          }
        case 64: break;
        case 4: 
          { return new Symbol(SimbolosCJS.identificador, yycolumn, yyline, new String(yytext()));
          }
        case 65: break;
        case 5: 
          { yybegin(COMENTARIO);
          }
        case 66: break;
        case 6: 
          { return new Symbol(SimbolosCJS.asignar, yycolumn, yyline, new String(yytext()));
          }
        case 67: break;
        case 7: 
          { return new Symbol(SimbolosCJS.parL, yycolumn, yyline, new String(yytext()));
          }
        case 68: break;
        case 8: 
          { return new Symbol(SimbolosCJS.parR, yycolumn, yyline, new String(yytext()));
          }
        case 69: break;
        case 9: 
          { return new Symbol(SimbolosCJS.corchL, yycolumn, yyline, new String(yytext()));
          }
        case 70: break;
        case 10: 
          { return new Symbol(SimbolosCJS.corchR, yycolumn, yyline, new String(yytext()));
          }
        case 71: break;
        case 11: 
          { return new Symbol(SimbolosCJS.llaveL, yycolumn, yyline, new String(yytext()));
          }
        case 72: break;
        case 12: 
          { return new Symbol(SimbolosCJS.llaveR, yycolumn, yyline, new String(yytext()));
          }
        case 73: break;
        case 13: 
          { return new Symbol(SimbolosCJS.coma, yycolumn, yyline, new String(yytext()));
          }
        case 74: break;
        case 14: 
          { return new Symbol(SimbolosCJS.dosPuntos, yycolumn, yyline, new String(yytext()));
          }
        case 75: break;
        case 15: 
          { return new Symbol(SimbolosCJS.puntoComa, yycolumn, yyline, new String(yytext()));
          }
        case 76: break;
        case 16: 
          { return new Symbol(SimbolosCJS.mas, yycolumn, yyline, new String(yytext()));
          }
        case 77: break;
        case 17: 
          { return new Symbol(SimbolosCJS.menos, yycolumn, yyline, new String(yytext()));
          }
        case 78: break;
        case 18: 
          { return new Symbol(SimbolosCJS.por, yycolumn, yyline, new String(yytext()));
          }
        case 79: break;
        case 19: 
          { return new Symbol(SimbolosCJS.div, yycolumn, yyline, new String(yytext()));
          }
        case 80: break;
        case 20: 
          { return new Symbol(SimbolosCJS.potencia, yycolumn, yyline, new String(yytext()));
          }
        case 81: break;
        case 21: 
          { return new Symbol(SimbolosCJS.mod, yycolumn, yyline, new String(yytext()));
          }
        case 82: break;
        case 22: 
          { return new Symbol(SimbolosCJS.not, yycolumn, yyline, new String(yytext()));
          }
        case 83: break;
        case 23: 
          { return new Symbol(SimbolosCJS.mayor, yycolumn, yyline, new String(yytext()));
          }
        case 84: break;
        case 24: 
          { return new Symbol(SimbolosCJS.menor, yycolumn, yyline, new String(yytext()));
          }
        case 85: break;
        case 25: 
          { yybegin(CADENA);
          }
        case 86: break;
        case 26: 
          { 
          }
        case 87: break;
        case 27: 
          { cadena+=yytext();
          }
        case 88: break;
        case 28: 
          { String temporal = cadena;
			cadena = "";
            yybegin(YYINITIAL);
            return new Symbol(SimbolosCJS.valCadena, yycolumn, yyline, temporal);
          }
        case 89: break;
        case 29: 
          { yybegin(YYINITIAL);
          }
        case 90: break;
        case 30: 
          { yybegin(COMENTARIO_MULTI);
          }
        case 91: break;
        case 31: 
          { return new Symbol(SimbolosCJS.igual, yycolumn, yyline, new String(yytext()));
          }
        case 92: break;
        case 32: 
          { return new Symbol(SimbolosCJS.aumento, yycolumn, yyline, new String(yytext()));
          }
        case 93: break;
        case 33: 
          { return new Symbol(SimbolosCJS.disminucion, yycolumn, yyline, new String(yytext()));
          }
        case 94: break;
        case 34: 
          { return new Symbol(SimbolosCJS.or, yycolumn, yyline, new String(yytext()));
          }
        case 95: break;
        case 35: 
          { return new Symbol(SimbolosCJS.xor, yycolumn, yyline, new String(yytext()));
          }
        case 96: break;
        case 36: 
          { return new Symbol(SimbolosCJS.and, yycolumn, yyline, new String(yytext()));
          }
        case 97: break;
        case 37: 
          { return new Symbol(SimbolosCJS.distinto, yycolumn, yyline, new String(yytext()));
          }
        case 98: break;
        case 38: 
          { return new Symbol(SimbolosCJS.mayorIgual, yycolumn, yyline, new String(yytext()));
          }
        case 99: break;
        case 39: 
          { return new Symbol(SimbolosCJS.menorIgual, yycolumn, yyline, new String(yytext()));
          }
        case 100: break;
        case 40: 
          { return new Symbol(SimbolosCJS.si, yycolumn, yyline, new String(yytext()));
          }
        case 101: break;
        case 41: 
          { return new Symbol(SimbolosCJS.valDecimal, yycolumn, yyline, new String(yytext()));
          }
        case 102: break;
        case 42: 
          { return new Symbol(SimbolosCJS.valCaracter, yycolumn, yyline, new String(yytext()));
          }
        case 103: break;
        case 43: 
          { return new Symbol(SimbolosCJS.var, yycolumn, yyline, new String(yytext()));
          }
        case 104: break;
        case 44: 
          { return new Symbol(SimbolosCJS.sino, yycolumn, yyline, new String(yytext()));
          }
        case 105: break;
        case 45: 
          { return new Symbol(SimbolosCJS.caso, yycolumn, yyline, new String(yytext()));
          }
        case 106: break;
        case 46: 
          { return new Symbol(SimbolosCJS.para, yycolumn, yyline, new String(yytext()));
          }
        case 107: break;
        case 47: 
          { return new Symbol(SimbolosCJS.falso, yycolumn, yyline, new String(yytext()));
          }
        case 108: break;
        case 48: 
          { return new Symbol(SimbolosCJS.hacer, yycolumn, yyline, new String(yytext()));
          }
        case 109: break;
        case 49: 
          { return new Symbol(SimbolosCJS.defecto, yycolumn, yyline, new String(yytext()));
          }
        case 110: break;
        case 50: 
          { return new Symbol(SimbolosCJS.terminar, yycolumn, yyline, new String(yytext()));
          }
        case 111: break;
        case 51: 
          { return new Symbol(SimbolosCJS.obtener, yycolumn, yyline, new String(yytext()));
          }
        case 112: break;
        case 52: 
          { return new Symbol(SimbolosCJS.funcion, yycolumn, yyline, new String(yytext()));
          }
        case 113: break;
        case 53: 
          { return new Symbol(SimbolosCJS.mensaje, yycolumn, yyline, new String(yytext()));
          }
        case 114: break;
        case 54: 
          { return new Symbol(SimbolosCJS.retornar, yycolumn, yyline, new String(yytext()));
          }
        case 115: break;
        case 55: 
          { return new Symbol(SimbolosCJS.imprimir, yycolumn, yyline, new String(yytext()));
          }
        case 116: break;
        case 56: 
          { return new Symbol(SimbolosCJS.mientras, yycolumn, yyline, new String(yytext()));
          }
        case 117: break;
        case 57: 
          { return new Symbol(SimbolosCJS.verdadero, yycolumn, yyline, new String(yytext()));
          }
        case 118: break;
        case 58: 
          { return new Symbol(SimbolosCJS.documento, yycolumn, yyline, new String(yytext()));
          }
        case 119: break;
        case 59: 
          { return new Symbol(SimbolosCJS.observador, yycolumn, yyline, new String(yytext()));
          }
        case 120: break;
        case 60: 
          { return new Symbol(SimbolosCJS.seleccion, yycolumn, yyline, new String(yytext()));
          }
        case 121: break;
        case 61: 
          { return new Symbol(SimbolosCJS.setelemento, yycolumn, yyline, new String(yytext()));
          }
        case 122: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

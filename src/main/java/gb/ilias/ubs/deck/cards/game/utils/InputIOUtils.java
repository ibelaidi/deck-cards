/**
 *
 */
package gb.ilias.ubs.deck.cards.game.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;

/**
 * Utility class to read for standard input.
 *
 * @author ilias
 * @since Oct 14, 2016
 */
public class InputIOUtils {

	private static Matcher				integerMatcher;										// Used
	private static Matcher				floatMatcher;

	/**
	 * The value returned by the peek() method when the input is at end-of-file.
	 * (The value of this constant is (char)0xFFFF.)
	 */
	public final static char			EOF						= (char) 0xFFFF;

	/**
	 * The value returned by the peek() method when the input is at end-of-line.
	 * The value of this constant is the character '\n'.
	 */
	public final static char			EOLN					= '\n';						// The
	// value
	private static String				inputFileName;
	private final static BufferedReader	standardInput			= new BufferedReader(new InputStreamReader(
			System.in));			// wraps
	private final static PrintWriter	standardOutput			= new PrintWriter(System.out);	// wraps
	private static BufferedReader		in						= standardInput;				// Stream
	private static PrintWriter			out						= standardOutput;				// Stream
	private static boolean				readingStandardInput	= true;
	private static boolean				writingStandardOutput	= true;
	private static String				buffer					= null;
	private static int					pos						= 0;
	private static int					inputErrorCount;

	/**
	 * Skips whitespace characters and then reads a value of type boolean from
	 * input, discarding the rest of
	 */
	public static boolean getlineBoolean() {
		final boolean x = getBoolean();
		emptyBuffer();
		return x;
	}

	/**
	 * Skips whitespace characters and then reads a value of type boolean from
	 * input. Any additional characters on
	 * the current line of input are retained, and will be read by the next
	 */
	public static boolean getBoolean() {
		boolean ans = false;
		while (true) {
			final String s = getWord();
			if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("t") || s.equalsIgnoreCase("yes")
					|| s.equalsIgnoreCase("y") || s.equals("1")) {
				ans = true;
				break;
			} else if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("f") || s.equalsIgnoreCase("no")
					|| s.equalsIgnoreCase("n") || s.equals("0")) {
				ans = false;
				break;
			} else {
				errorMessage("Illegal boolean input value.",
						"one of:  true, false, t, f, yes, no, y, n, 0, or 1");
			}
		}
		inputErrorCount = 0;
		return ans;
	}

	/**
	 * Skips whitespace characters and then reads one "word" from input. Any
	 * additional characters on
	 * the current line of input are retained, and will be read by the next
	 */
	public static String getWord() {
		skipWhitespace();
		final StringBuffer str = new StringBuffer(50);
		char ch = lookChar();
		while (ch == EOF || !Character.isWhitespace(ch)) {
			str.append(readChar());
			ch = lookChar();
		}
		return str.toString();
	}

	/**
	 * Skips whitespace characters and then reads a value of type char from
	 * input, discarding the rest of
	 * the current line of input (including the next end-of-line character, if
	 */
	public static char getlineChar() {
		final char x = getChar();
		emptyBuffer();
		return x;
	}

	/**
	 * Skips whitespace characters and then reads a single non-whitespace
	 * character from input. Any additional characters on
	 * the current line of input are retained, and will be read by the next
	 */
	public static char getChar() {
		skipWhitespace();
		return readChar();
	}

	/**
	 * Skips over any whitespace characters, including for end-of-lines. After
	 * this method is called,
	 * the next input character is either an end-of-file or a non-whitespace
	 * character.
	 */
	private static void skipWhitespace() {
		char ch = lookChar();
		while (ch != EOF && Character.isWhitespace(ch)) {
			readChar();
			if (ch == '\n' && readingStandardInput && writingStandardOutput) {
				out.print("? ");
				out.flush();
			}
			ch = lookChar();
		}
	}

	private static char lookChar() {
		if (buffer == null || pos > buffer.length()) {
			fillBuffer();
		}
		if (buffer == null) {
			return EOF;
		} else if (pos == buffer.length()) {
			return '\n';
		} else {
			return buffer.charAt(pos);
		}
	}

	private static char readChar() {
		// input
		final char ch = lookChar();
		if (buffer == null) {
			if (readingStandardInput) {
				throw new IllegalArgumentException("Attempt to read past end-of-file in standard input???");
			} else {
				throw new IllegalArgumentException("Attempt to read past end-of-file in file \""
						+ inputFileName + "\".");
			}
		}
		pos++;
		return ch;
	}

	private static void fillBuffer() {
		// return,
		try {
			buffer = in.readLine();
		} catch (final Exception e) {
			if (readingStandardInput) {
				throw new IllegalArgumentException("Error while reading standard input???");
			} else if (inputFileName != null) {
				throw new IllegalArgumentException("Error while attempting to read from file \""
						+ inputFileName + "\".");
			} else {
				throw new IllegalArgumentException("Errow while attempting to read form an input stream.");
			}
		}
		pos = 0;
		floatMatcher = null;
		integerMatcher = null;
	}

	private static void emptyBuffer() {
		// of input
		buffer = null;
	}

	private static void errorMessage(String message, String expecting) {
		if (readingStandardInput && writingStandardOutput) {
			out.println();
			out.print("  *** Error in input: " + message + "\n");
			out.print("  *** Expecting: " + expecting + "\n");
			out.print("  *** Discarding Input: ");
			if (lookChar() == '\n') {
				out.print("(end-of-line)\n\n");
			} else {
				while (lookChar() != '\n') {
					out.print(readChar());
				}
				out.print("\n\n");
			}
			out.print("Please re-enter: ");
			out.flush();
			readChar(); // discard the end-of-line character
			inputErrorCount++;
			if (inputErrorCount >= 10) {
				throw new IllegalArgumentException(
						"Too many input consecutive input errors on standard input.");
			}
		} else if (inputFileName != null) {
			throw new IllegalArgumentException("Error while reading from file \"" + inputFileName + "\":\n"
					+ message + "\nExpecting " + expecting);
		} else {
			throw new IllegalArgumentException("Error while reading from inptu stream:\n" + message
					+ "\nExpecting " + expecting);
		}
	}
}

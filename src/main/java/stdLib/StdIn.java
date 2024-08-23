package stdLib; /*************************************************************************
 *  Compilation:  javac StdIn.java
 *  Execution:    java StdIn
 *
 *  Reads in data of various types from standard input.
 *
 *************************************************************************/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 *  <i>Standard input</i>. This class provides methods for reading strings
 *  and numbers from standard input.
 *  <p>
 *  The Locale used is: language = English, country = US. This is consistent
 *  with the formatting conventions with Java floating-point literals,
 *  command-line arguments (via <tt>Double.parseDouble()</tt>)
 *  and standard output (via <tt>System.out.print()</tt>). It ensures that
 *  standard input works with the input files used in the textbook.
 *  <p>
 *  For additional documentation, see <a href="http://introcs.cs.princeton.edu/15inout">Section 1.5</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 */
public final class StdIn {

    // assume Unicode UTF-8 encoding
    private static String charsetName = "UTF-8";

    // assume language = English, country = US for consistency with System.out.
    private static Locale usLocale = new Locale("en", "US");

    // the scanner object
    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in), charsetName);

    // static initializer
    static { scanner.useLocale(usLocale); }

    // singleton pattern - can't instantiate
    private StdIn() { }


    /**
     * Is there only whitespace left on standard input?
     */
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    /**
     * Return next string from standard input
     */
    public static String readString() {
        return scanner.next();
    }

    /**
     * Return next int from standard input
     */
    public static int readInt() {
        return scanner.nextInt();
    }

    /**
     * Return next double from standard input
     */
    public static double readDouble() {
        return scanner.nextDouble();
    }

    /**
     * Return next float from standard input
     */
    public static float readFloat() {
        return scanner.nextFloat();
    }

    /**
     * Return next short from standard input
     */
    public static short readShort() {
        return scanner.nextShort();
    }

    /**
     * Return next long from standard input
     */
    public static long readLong() {
        return scanner.nextLong();
    }

    /**
     * Return next byte from standard input
     */
    public static byte readByte() {
        return scanner.nextByte();
    }

    /**
     * Return next boolean from standard input, allowing "true" or "1" for true,
     * and "false" or "0" for false
     */
    public static boolean readBoolean() {
        String s = readString();
        if (s.equalsIgnoreCase("true"))  return true;
        if (s.equalsIgnoreCase("false")) return false;
        if (s.equals("1"))               return true;
        if (s.equals("0"))               return false;
        throw new java.util.InputMismatchException();
    }

    /**
     * Does standard input have a next line?
     */
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Return rest of line from standard input
     */
    public static String readLine() {
        return scanner.nextLine();
    }

    /**
     * Return next char from standard input
     */
    public static char readChar() {
        String s = scanner.findWithinHorizon("(?s).", 1);
        return s.charAt(0);
    }

    /**
     * Return rest of input from standard input
     */
    public static String readAll() {
        return System.console().readLine();
    }

   /**
     * Read rest of input as array of strings
     */
    public static String[] readStrings() {
        return Objects.requireNonNull(readAll()).trim().split("\\s+");
    }


    public static String[] readFile(String relativePath)  {
        try {
            return  Files.readAllLines(Paths.get(relativePath)).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Unit test
     */
    public static void main(String[] args) {

        System.out.println("Type a string: ");
        String s = StdIn.readString();
        System.out.println("Your string was: " + s);
        System.out.println();

        System.out.println("Type an int: ");
        int a = StdIn.readInt();
        System.out.println("Your int was: " + a);
        System.out.println();

        System.out.println("Type a boolean: ");
        boolean b = StdIn.readBoolean();
        System.out.println("Your boolean was: " + b);
        System.out.println();

        System.out.println("Type a double: ");
        double c = StdIn.readDouble();
        System.out.println("Your double was: " + c);
        System.out.println();

    }

}

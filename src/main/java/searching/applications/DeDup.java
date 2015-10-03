package searching.applications;

import searching.SET;
import stdLib.StdIn;
import stdLib.StdOut;

/*************************************************************************
 *  Compilation:  javac searching.applications.DeDup.java
 *  Execution:    java searching.applications.DeDup < input.txt
 *  Dependencies: SET StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/35applications/tinyTale.txt
 *
 *  Read in a list of words from standard input and print out
 *  each word, removing any duplicates.
 *
 *  % more tinyTale.txt 
 *  it was the best of times it was the worst of times 
 *  it was the age of wisdom it was the age of foolishness 
 *  it was the epoch of belief it was the epoch of incredulity 
 *  it was the season of light it was the season of darkness 
 *  it was the spring of hope it was the winter of despair
 *
 *  % java searching.applications.DeDup < tinyTale.txt
 *  it
 *  was
 *  the
 *  best
 *  of
 *  times
 *  worst
 *  age
 *  wisdom
 *  ...
 *  winter
 *  despair
 *
 *************************************************************************/

public class DeDup {  
    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        // read in strings and add to set
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
    }
}
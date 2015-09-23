package searching.applications; /*************************************************************************
 *  Compilation:  javac searching.applications.FileIndex.java
 *  Execution:    java searching.applications.FileIndex file1.txt file2.txt file3.txt ...
 *  Dependencies: ST.java SET.java In.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/ex1.txt
 *                http://algs4.cs.princeton.edu/ex2.txt
 *                http://algs4.cs.princeton.edu/ex3.txt
 *                http://algs4.cs.princeton.edu/ex4.txt
 *
 *  % java searching.applications.FileIndex ex*.txt
 *  age
 *   ex3.txt
 *   ex4.txt 
 * best
 *   ex1.txt 
 * was
 *   ex1.txt
 *   ex2.txt
 *   ex3.txt
 *   ex4.txt 
 *
 *  % java searching.applications.FileIndex *.txt
 *
 *  % java searching.applications.FileIndex *.java
 *
 *************************************************************************/

import searching.SET;
import searching.ST;
import stdLib.In;
import stdLib.StdIn;
import stdLib.StdOut;

import java.io.File;

public class FileIndex { 

    public static void main(String[] args) {

        // key = word, value = set of files containing that word
        ST<String, SET<File>> st = new ST<String, SET<File>>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new SET<File>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }


        // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                SET<File> set = st.get(query);
                for (File file : set) {
                    StdOut.println("  " + file.getName());
                }
            }
        }

    }

}

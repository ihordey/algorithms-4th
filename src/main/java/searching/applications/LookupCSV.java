package searching.applications;

import searching.ST;
import stdLib.In;
import stdLib.StdIn;
import stdLib.StdOut;

/*************************************************************************
 *  Compilation:  javac searching.applications.LookupCSV.java
 *  Execution:    java searching.applications.LookupCSV file.csv keyField valField
 *  Dependencies: ST.java In.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/35applications/DJIA.csv
 *                http://algs4.cs.princeton.edu/35applications/UPC.csv
 *                http://algs4.cs.princeton.edu/35applications/amino.csv
 *                http://algs4.cs.princeton.edu/35applications/elements.csv
 *                http://algs4.cs.princeton.edu/35applications/ip.csv
 *                http://algs4.cs.princeton.edu/35applications/morse.csv
 *  
 *  Reads in a set of key-value pairs from a two-column CSV file
 *  specified on the command line; then, reads in keys from standard
 *  input and prints out corresponding values.
 * 
 *  % java searching.applications.LookupCSV amino.csv 0 3     % java searching.applications.LookupCSV ip.csv 0 1
 *  TTA                                www.google.com 
 *  Leucine                            216.239.41.99 
 *  ABC                               
 *  Not found                          % java searching.applications.LookupCSV ip.csv 1 0
 *  TCT                                216.239.41.99 
 *  Serine                             www.google.com 
 *                                 
 *  % java searching.applications.LookupCSV amino.csv 3 0     % java searching.applications.LookupCSV DJIA.csv 0 1
 *  Glycine                            29-Oct-29 
 *  GGG                                252.38 
 *                                     20-Oct-87 
 *                                     1738.74
 *
 *
 *************************************************************************/

public class LookupCSV {
    public static void main(String[] args) {
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        // symbol table
        ST<String, String> st = new ST<String, String>();

        // read in the data from csv file
        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (st.contains(s)) StdOut.println(st.get(s));
            else                StdOut.println("Not found");
        }
    }
}

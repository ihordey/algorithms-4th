package fundamentals.dataAbstraction;

import stdLib.In;
import stdLib.StdIn;
import stdLib.StdOut;

/*************************************************************************
 *  Compilation:  javac fundamentals.dataAbstraction.Whitelist.java
 *  Execution:    java fundamentals.dataAbstraction.Whitelist whitelist.txt < data.txt
 *  Dependencies: StaticSetOfInts.java In.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/11model/tinyW.txt
 *                http://algs4.cs.princeton.edu/11model/tinyT.txt
 *                http://algs4.cs.princeton.edu/11model/largeW.txt
 *                http://algs4.cs.princeton.edu/11model/largeT.txt
 *
 *  fundamentals.dataAbstraction.Whitelist filter.
 *
 *
 *  % java fundamentals.dataAbstraction.Whitelist tinyW.txt < tinyT.txt
 *  50
 *  99
 *  13
 *
 *  % java fundamentals.dataAbstraction.Whitelist largeW.txt < largeT.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *
 *************************************************************************/

public class Whitelist {
    public static void main(String[] args) {
        int[] w = In.readInts(args[0]);
        StaticSETofInts set = new StaticSETofInts(w);

        // Read key, print if not in whitelist.
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}

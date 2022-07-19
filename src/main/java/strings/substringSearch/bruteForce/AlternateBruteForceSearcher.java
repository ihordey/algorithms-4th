package strings.substringSearch.bruteForce;

public class AlternateBruteForceSearcher {

    public int search(String pat, String txt) {
        int i, N = txt.length();
        int j, M = pat.length();

        for (j = 0, i = 0; i < N && j < M; i++) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }

        if (j == M) return i -j;
        return -1;
    }
}

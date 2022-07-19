package strings.substringSearch.bruteForce;

public class BruteForceSearcher {
    public int search(String pat, String txt) {
        final int M = pat.length();
        final int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if(txt.charAt(i+j) != pat.charAt(j)) {
                    break;
                }
            }
            if(j == M){
                return i;
            }
        }
        return -1;
    }
}

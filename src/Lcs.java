import java.util.List;

public class Lcs {

    public static class LCSResult {
        public int length;
        public List<String> subsequences;

        public LCSResult(int length, List<String> subsequences) {
            this.length = length;
            this.subsequences = subsequences;
        }
    }

    public void longestCommonSubsequence(String S1, String S2) {
        int m = S1.length(), n = S2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = S1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = S2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        return dp[m][n];
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                lcs.insert(0, S1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("Length of LCS is: " + dp[m][n]);
        System.out.println("Longest Common Subsequence: " + lcs);

    }

    public static void main(String[] args) {
        Lcs lcs = new Lcs();
        String S1 = "ACCGGTCGAGATGCAG";
        String S2 = "GTCGTTCGGAATGCAT";
        lcs.longestCommonSubsequence(S1,S2);
//        String S3 = "ABCD";
//        String S4 = "ABCD";
//        lcs.longestCommonSubsequence(S3,S4);
    }
}

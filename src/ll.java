import java.util.ArrayList;
import java.util.List;

public class ll {
    public static class LCSResult {
        public int length;
        public List<String> subsequences;

        public LCSResult(int length, List<String> subsequences) {
            this.length = length;
            this.subsequences = subsequences;
        }
    }

    public LCSResult longestCommonSubsequences(String S1, String S2) {
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
//        for (int i = 1; i <=m; i++) {
//            System.out.println();
//            for (int j = 1; j <n ; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//        }
        int length = dp[m][n];
        List<String> subsequences = new ArrayList<>();
        generateLCS(dp, S1, S2, m, n, "", subsequences);
        return new LCSResult(length, subsequences);
    }

    private void generateLCS(int[][] dp, String S1, String S2, int i, int j, String currentLCS, List<String> subsequences) {
        if (i == 0 || j == 0) {
            subsequences.add(currentLCS);
            return;
        }

        if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            generateLCS(dp, S1, S2, i - 1, j - 1, S1.charAt(i - 1) + currentLCS, subsequences);
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                generateLCS(dp, S1, S2, i - 1, j, currentLCS, subsequences);
            }

            if (dp[i][j - 1] >= dp[i - 1][j]) {
                generateLCS(dp, S1, S2, i, j - 1, currentLCS, subsequences);
            }
        }
    }

    public static void main(String[] args) {
        ll lcs = new ll();
        String S1 = "ACCGGTCGAGATGCAG";
        String S2 = "GTCGTTCGGAATGCAT";
        String S3 = "BDCABAABC";
        String S4 = "ABCBDABBC";
        LCSResult result = lcs.longestCommonSubsequences(S1, S2);
        System.out.println("Length of LCS is: " + result.length);
        System.out.println("Longest Common Subsequences:");
        for (String subsequence : result.subsequences) {
            System.out.println(subsequence);
        }
    }
}






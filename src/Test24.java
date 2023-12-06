import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Test24 {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        // StringTest ex = new StringTest();
        // ex.change(ex.str, ex.ch);
        // System.out.println(ex.str);// good
        // System.out.println(ex.ch);// best
        int[] array = { 3, 7, 9, 4, 4 };
        Test24 test = new Test24();
        int ans = test.stoneGameII(array);
        System.out.println(ans);
    }
}
/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1225.java
 * @Description TODO
 * @createTime 2023年12月25日 12:45:00
 */
public class Test1225 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 初始化
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 状态转移方程
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            // 从上往下
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
//        优化为一维数组
        int [] dp1 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
        }
//        Arrays.fill(dp1,1);
        for (int i = 1; i < m; i++) {
            // 从上往下
            for (int j = 1; j < n; j++) {
                dp1[j] = dp1[j] + dp1[j - 1];
            }
        }
        return dp1[n - 1];
    }

}

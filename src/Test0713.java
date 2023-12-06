/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0713.java
 * @Description TODO
 * @createTime 2023年07月13日 16:05:00
 */
public class Test0713 {
    public int minFallingPathSum(int[][] matrix) {
//    dp[row][col] = dp[row -1][col]    0 < col < n
//                 = dp[row -1][col -1]   0 < col
//                 = dp[row -1][col +1] col + 1 < n
        int n = matrix.length;
        var f = new int[n];
//        int []f = new int[n];
        System.arraycopy(matrix[0], 0, f, 0, n);
        for (int i = 1; i < n; i++) {
            int pre = f[0];
//            var g = f.clone();
            for (int j = 0; j < n; j++) {
                int tmp = pre;
                pre = f[j];
                if(j > 0){
                    tmp = Math.min(tmp,pre);
                }
                if(j < n-1){
                    tmp = Math.min(tmp,f[j+1]);
                }
                f[j]  = tmp + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, f[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Test0713 test0713 = new Test0713();
        int [][]matrix = {{-19,57},{-40,-5}};
        System.out.println(test0713.minFallingPathSum(matrix));
}
    }


/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0810.java
 * @Description TODO
 * @createTime 2023年08月10日 15:39:00
 */
public class Test0810 {
        public int minFallingPathSum(int[][] grid) {
//        下降路径最小和
//        状态转移方程 f[i][j] = grid[0][j]       i = 0
//                              first_min_sum + grid[i][j]  j != first_min_index
//                              second_min_sum + grid[i][j]  j = first_min_index
        int first_min_sum = 0, second_min_sum = 0;
        int first_min_sum_index = -1;
        int n = grid.length;
        int [][] f = new int[n][n];
        for (int[] ints : grid) {
//            记录当前行的最小和次小值及最小下标
            int cur_first_min_sum = Integer.MAX_VALUE, cur_second_min_sum = Integer.MAX_VALUE;
            int cur_first_min_sum_index = -1;
            for (int j = 0; j < n; j++) {
                int cur_sum = (j != first_min_sum_index ? first_min_sum : second_min_sum) + ints[j];
                if (cur_sum < cur_first_min_sum) {
                    cur_second_min_sum = cur_first_min_sum;
                    cur_first_min_sum = cur_sum;
                    cur_first_min_sum_index = j;
                } else if (cur_sum < cur_second_min_sum) {
                    cur_second_min_sum = cur_sum;
                }
            }
            first_min_sum = cur_first_min_sum;
            second_min_sum = cur_second_min_sum;
            first_min_sum_index = cur_first_min_sum_index;
        }
        return first_min_sum;
    }


    public static void main(String[] args) {
        Test0810 test0810 = new Test0810();
        int [][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(test0810.minFallingPathSum(grid));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1205.java
 * @Description TODO
 * @createTime 2023年12月05日 16:26:00
 */
public class Test1205 {
    public long minimumFuelCost(int[][] roads, int seats) {
            int n = roads.length + 1;

            List<Integer>[] g = new ArrayList[n];

            Arrays.setAll(g, e -> new ArrayList<>());

            for (int[] e : roads) {

                int x = e[0], y = e[1];

                g[x].add(y); // 记录每个点的邻居

                g[y].add(x);

            }

            dfs(0, -1, g, seats);

            return ans;

        }

        private long ans;



        private int dfs(int x, int fa, List<Integer>[] g, int seats) {

            int size = 1;

            for (int y : g[x]) {

                if (y != fa) { // 递归子节点，不能递归父节点

                    size += dfs(y, x, g, seats); // 统计子树大小
                }
            }
            if (x > 0) { // x 不是根节点

//                ans += (size - 1) / seats + 1; // ceil(size/seats)
                ans += Math.ceil(1.0*size/seats);
            }
            return size;
        }

    public static void main(String[] args) {
        Test1205 test1205 = new Test1205();
        int [][]roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        int seats = 2;
        System.out.println(test1205.minimumFuelCost(roads,seats));
    }
    }

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0728.java
 * @Description TODO
 * @createTime 2023年07月28日 22:29:00
 */
public class Test0728 {
        public int minimumTime(int n, int[][] relations, int[] time) {
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, k -> new ArrayList<>());
//            邻接表 g 存储有向无环图，同时使用一个数组 indeg 存储每个节点的入度；
            int[] indeg = new int[n];
            for (int[] e : relations) {
                int a = e[0] - 1, b = e[1] - 1;
                g[a].add(b);
                ++indeg[b];
            }
//            队列 q 存储所有入度为 0 的节点
            Deque<Integer> q = new ArrayDeque<>();
            int[] f = new int[n];
//            数组 f 存储每个节点的最早完成时间，初始时 f[i]=0；
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                int v = indeg[i], t = time[i];
                if (v == 0) {
                    q.offer(i);
                    f[i] = t;
                    ans = Math.max(ans, t);
                }
            }
            while (!q.isEmpty()) {
                int i = q.pollFirst();
                for (int j : g[i]) {
                    f[j] = Math.max(f[j], f[i] + time[j]);
                    ans = Math.max(ans, f[j]);
                    if (--indeg[j] == 0) {
                        q.offer(j);
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        Test0728 test0728 = new Test0728();
        int n = 3;
        int [][] relations = {{1,3},{2,3}};
        int []time = {3,2,5};
        System.out.println(test0728.minimumTime(n,relations,time));
    }
    }



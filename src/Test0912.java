import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0912.java
 * @Description TODO
 * @createTime 2023年09月12日 19:30:00
 */
public class Test0912 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
//        构建拓扑排序， 邻接表
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        boolean[][] f = new boolean[numCourses][numCourses];
        int[] indgree = new int[numCourses];
        for (int[] p : prerequisites) {
            g[p[0]].add(p[1]);
            ++indgree[p[1]];
        }
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            for (int next : g[cur]
            ) {
                f[cur][next] = true;

                for (int i = 0; i < numCourses; i++) {
                    f[i][next] |= f[i][cur];
                }
                if (--indgree[next] == 0) {
                    deque.offer(next);
                }
            }

        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(f[query[0]][query[1]]);
        }
        return res;
    }
}


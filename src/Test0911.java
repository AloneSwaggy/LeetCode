import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0911.java
 * @Description TODO
 * @createTime 2023年09月11日 19:17:00
 */
public class Test0911 {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b)->a[1]-b[1]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
            int sum = 0;
            for (int[] c : courses) {
                int d = c[0], e = c[1];
                sum += d;
                q.add(d);
                if (sum > e) sum -= q.poll();
            }
            return q.size();
        }

    public static void main(String[] args) {
        Test0911 test0911 = new Test0911();
        int[][] courses = {{4,6},{5,5}, {2,6}};
        System.out.println(test0911.scheduleCourse(courses));
    }

}

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0707.java
 * @Description TODO
 * @createTime 2023年07月07日 17:57:00
 */
public class Test0707 {
    public int findCrossingTime(int n, int k, int[][] time) {
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] + a[2] - b[0] - b[2];
            }
        }); // 稳定排序

//       1. 把完成时间不超过 cur 的 workL 弹出，放入 waitL 中；
//       2. 把完成时间不超过 cur 的 workR 弹出，放入 waitR 中；
//       3. 如果 waitR 不为空，出堆，过桥，更新 cur 为过完桥的时间，然后把这个工人放入 workL 中（记录完成时间）；
//       4. 否则如果 waitL 不为空，出堆，过桥，更新 cur 为过完桥的时间，然后把这个工人放入 workR 中（记录完成时间），同时把 n 减一；
//       5. 否则说明 cur 过小，找个最小的放箱/搬箱完成时间来更新 cur。
//
        var workL = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        var workR = new PriorityQueue<int[]>(workL.comparator());
        var waitL = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        var waitR = new PriorityQueue<int[]>(waitL.comparator());
//        循环结束后，不断弹出 workR，过桥，最后一个工人过完桥的时间即为答案。
//        代码实现时，可以先把 time从小到大稳定排序，这样下标越大的工人效率越低，只看下标就能比较工人的效率。
        // 队列存储下标和时间

        //        初始状态，所有工人位于waitL队列中
        for (int i = k - 1; i >= 0; i--) {
            waitL.add(new int[]{i, 0});
        }
        int curTime = 0;
        while (n > 0) {
            // 左边完成放箱
            while (!workL.isEmpty() && workL.peek()[1] <= curTime) {
                waitL.add(workL.poll());
            }
            // 右边完成搬箱
            while (!workR.isEmpty() && workR.peek()[1] <= curTime) {
                waitR.add(workR.poll());
            }
            // 右边过桥，注意加到 waitR 中的都是 <= cur 的（下同）
            if (!waitR.isEmpty()) {
                var p = waitR.poll();
                curTime += time[p[0]][2];
                p[1] = curTime + time[p[0]][3];            // 放箱
                workL.add(p);
            } else if (!waitL.isEmpty()) {                  // 左边过桥
                var p = waitL.poll();
                curTime += time[p[0]][0];
                p[1] = curTime + time[p[0]][1];                  // 搬箱
                workR.add(p);
                n--;
            }
            // cur 过小，找个最小的放箱/搬箱完成时间来更新 cur
            else if (workL.isEmpty()) curTime = workR.peek()[1]; // cur 过小，找个最小的放箱/搬箱完成时间来更新 cur
            else if (workR.isEmpty()) curTime = workL.peek()[1];
            else curTime = Math.min(workL.peek()[1], workR.peek()[1]);
        }
        while (!workR.isEmpty()) { // 右边完成搬箱
            var p = workR.poll();
            curTime = Math.max(p[1], curTime) + time[p[0]][2]; // 如果没有排队，直接过桥；否则由于无论谁先过桥，最终完成时间都一样，所以也可以直接计算
        }
        return curTime;        // 最后一个过桥的时间
    }

    public static void main(String[] args) {
        Test0707 test0707 = new Test0707();
        int n = 3, k = 2;
        int[][] time = {{1, 9, 1, 8}, {10, 10, 10, 10}};
        System.out.println(test0707.findCrossingTime(n, k, time));
    }

}


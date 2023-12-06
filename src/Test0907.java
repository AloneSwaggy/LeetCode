/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0907.java
 * @Description TODO
 * @createTime 2023年09月07日 18:59:00
 */
public class Test0907 {
    public long repairCars(int[] ranks, int cars) {
//        t = r * car * car
        int maxR = 0;
        int left = 0;
        for (int r : ranks) {
            maxR = Math.max(maxR, r);
        }
        int right = maxR * cars * cars;
        while (left < right) {
            int mid = (right + left) >> 1;
            int sum = 0;
            for (int r : ranks
            ) {
                sum += Math.sqrt(mid / r);
            }
            if (sum >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

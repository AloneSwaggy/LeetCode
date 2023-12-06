import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1008.java
 * @Description TODO
 * @createTime 2023年10月08日 16:21:00
 */
public class Test1008 {
    int maxTimestamp;

    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public void StockPrice() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<Integer, Integer>();

        pqMax = new PriorityQueue<>((a, b) -> b[0] - a[0]); //降序
        pqMin = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); //升序 小根堆
    }

        public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        timePriceMap.put(timestamp, price);
        pqMax.offer(new int[]{price, timestamp});
        pqMin.offer(new int[]{price, timestamp});
    }

        public int current () {
            return timePriceMap.get(maxTimestamp);
        }

        public int maximum () {
            while (true) {
                int[] priceTime = pqMax.peek();
                assert priceTime != null;
                int price = priceTime[0], timestamp = priceTime[1];
                if (timePriceMap.get(timestamp) == price) {
                    return price;
                }
                pqMax.poll();
            }
        }

        public int minimum () {
            while (true) {
                int[] priceTime = pqMin.peek();
                assert priceTime != null;
                int price = priceTime[0], timestamp = priceTime[1];
                if (timePriceMap.get(timestamp) == price) {
                    return price;
                }
                pqMin.poll();
            }
        }
    }
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
//class point {
//    public double x, y;
//
//    public point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//}

//class PointPair {
//    public point p1, p2;
//    public double distance;
//
//    public PointPair(point p1, point p2, double distance) {
//        this.p1 = p1;
//        this.p2 = p2;
//        this.distance = distance;
//    }
//}

//public class Test0510 {
//    private static final double INF = Double.POSITIVE_INFINITY;
//
//
//    public class ClosestPair {
//
//        private static final double INF = Double.POSITIVE_INFINITY;
//
//        // 计算两个点之间的距离
//        private static double dist(point p1, point p2) {
//            double dx = p1.x - p2.x;
//            double dy = p1.y - p2.y;
//            return Math.sqrt(dx * dx + dy * dy);
//        }
//
//        // 暴力方法求最近点对
//        private static PointPair bruteForce(point[] points, int start, int end) {
//            double minDist = INF;
//            point p1 = null, p2 = null;
//            for (int i = start; i < end; i++) {
//                for (int j = i + 1; j < end; j++) {
//                    double dist = dist(points[i], points[j]);
//                    if (dist < minDist) {
//                        minDist = dist;
//                        p1 = points[i];
//                        p2 = points[j];
//                    }
//                }
//            }
//            return (p1 == null || p2 == null) ? null : new PointPair(p1, p2, minDist);
//        }
//
//        // 求跨越分界线的最近点对
//        private static PointPair stripClosest(point[] strip, int size, double d) {
//            double minDist = d;
//            point p1 = null, p2 = null;
//            Arrays.sort(strip, 0, size, Comparator.comparingDouble(p -> p.y));
//
//            for (int i = 0; i < size; i++) {
//                for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < minDist; j++) {
//                    double dist = dist(strip[i], strip[j]);
//                    if (dist < minDist) {
//                        minDist = dist;
//                        p1 = strip[i];
//                        p2 = strip[j];
//                    }
//                }
//            }
//            return (p1 == null || p2 == null) ? null : new PointPair(p1, p2, minDist);
//        }
//
//        private static PointPair closestUtil(point[] points, int start, int end) {
//            if (end - start <= 3) {
//                return bruteForce(points, start, end);
//            }
//
//            int mid = (start + end) / 2;
//            point midPoint = points[mid];
//
//            PointPair leftClosest = closestUtil(points, start, mid);
//            PointPair rightClosest = closestUtil(points, mid, end);
//            PointPair closestPair;
//            if (leftClosest == null) {
//                closestPair = rightClosest;
//            } else if (rightClosest == null) {
//                closestPair = leftClosest;
//            } else {
//                closestPair = (leftClosest.distance < rightClosest.distance) ? leftClosest : rightClosest;
//            }
//            point[] strip = new point[end - start];
//            int j = 0;
//            for (int i = start; i < end; i++) {
//                if (Math.abs(points[i].x - midPoint.x) < closestPair.distance) {
//                    strip[j++] = points[i];
//                }
//            }
//            PointPair stripClosest = stripClosest(strip, j, closestPair.distance);
//            if (stripClosest == null) {
//                return closestPair;
//            }
//            return (closestPair.distance < stripClosest.distance) ? closestPair : stripClosest;
//        }
//
//        // 求最近点对
//        public static PointPair closest(point[] points) {
//            Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
//            return closestUtil(points, 0, points.length);
//        }
//
//        public static void main(String[] args) {
//            int n = 500; // 生成500个点
//            int a, b;
//            point[] points = new point[n];
//            Random rand = new Random();
//            for (int i = 0; i < n; i++) {
//                points[i] = new point(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
//            }
//
//            PointPair closestPair = closest(points);
//            PointPair closestPairBf = bruteForce(points, 0, 500);
//
//            System.out.printf("closestPair:\n", closestPair.p1, closestPair.p2);
//            System.out.printf("closestDis: \n", closestPair.distance);
//
//
//        }
//    }
//}
//

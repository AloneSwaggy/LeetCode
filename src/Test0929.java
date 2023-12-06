/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0929.java
 * @Description TODO
 * @createTime 2023年09月29日 16:08:00
 */
public class Test0929 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int m = flowerbed.length;
            for(int i = 0; i < m && n != 0; i++){
                if ((i == 0 || flowerbed[i - 1] != 1) && flowerbed[i] != 1 && (i == m - 1 || flowerbed[i + 1] != 1)) {
                    n--;
                }
                i++;
            }
            return n == 0;
        }

    public static void main(String[] args) {
        Test0929 test0929 = new Test0929();
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;
        System.out.println(test0929.canPlaceFlowers(flowerbed, n));
        }
    }

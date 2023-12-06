/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0726.java
 * @Description TODO
 * @createTime 2023年07月26日 15:45:00
 */
public class Test0726 {
    public int trap(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if(min > height[left]){
                    sum += min - height[left];
                }
                left++;
            }
            else {
                max_right = Math.max(max_right,height[right + 1]);
                int min = max_right;
                if(min > height[right]){
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Test0726 test0726 = new Test0726();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1,};
        System.out.println(test0726.trap(height));
    }
}

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0708.java
 * @Description TODO
 * @createTime 2023年07月08日 14:10:00
 */
public class Test0708 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length -1;
        while (numbers[left] + numbers [right] != target){
            if(numbers[left] + numbers [right] < target){
                ++left;
            }
            else --right;
        }
        return new int[]{left+1,right+1};
    }

    public static void main(String[] args) {
        int []numbers = {2,7,9,11};
        int taget = 9;
        Test0708 test0708 =new Test0708();
        System.out.println(Arrays.toString(test0708.twoSum(numbers, taget)));
    }
}

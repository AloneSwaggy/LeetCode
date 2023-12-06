import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0709.java
 * @Description TODO
 * @createTime 2023年07月09日 19:54:00
 */
public class Test0709 {
    public List<List<Integer>> threeSum(int[] nums) {
//       排序＋双指针
//        1.nums.length < 3 或者 排序后 nums[i] > 0 返回空集合
//        2.对于给定的i 使用双指针遍历i 后面的左右两端 直至 left >= right
//        3.避免重复：nums[i]= nums[i-1] 跳过 同理nums[left]和nums[right]
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i>0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
//                    while (i < nums.length -3 && nums[i] == nums [i +1]) ++i;
                    while (left < right && nums[left + 1] == nums[left]) ++left;
                    while (left < right && nums[right - 1] == nums[right]) --right;
                    ++left;
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Test0709 test0709 = new Test0709();
        int[] nums = {0, 0, 0};
        System.out.println(test0709.threeSum(nums));
    }
}

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0710.java
 * @Description TODO
 * @createTime 2023年07月10日 13:38:00
 */
public class Test0710 {
    public int threeSumClosest(int[] nums, int target) {
//     1. 排序
//     2. 对于每个给定的i 使用双指针遍历 记录比较和与目标值的差值
//
        Arrays.sort(nums);
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
                if (sum > target) {
                    --right;
                } else {
                    ++left;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test0710 test0710 = new Test0710();
        int []nums = {-1,2,1,4};
        int target = 1;
        System.out.println(test0710.threeSumClosest(nums,target));
    }
}

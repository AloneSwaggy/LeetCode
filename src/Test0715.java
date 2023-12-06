import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0715.java
 * @Description TODO
 * @createTime 2023年07月15日 13:01:00
 */
public class Test0715 {
    //    四数之和
//    排序 ＋ 双指针 在三数之和基础上加一层循环， 注意去除重复解
//     1 1 2 3 4 5 6   13
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {   //        特殊情况直接返回空集
            return ans;
        }
        Arrays.sort(nums);  //        排序
        if ((long)nums[0] + nums[1] + nums[2] + nums[3] > target)  //最小值大于目标值 返回空集
            return ans;
        for (int i = 0; i < n - 3; i++) { //一层循环
            if (i > 0 && nums[i] == nums[i - 1])  //跳过重复
                continue;
            if ((long)nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)// 当前循环最大值小于目标值跳过
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) // 跳过重复
                    continue;
                if ((long)nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target)
                    continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) ++left;
                        while (left < right && nums[right - 1] == nums[right]) --right;
                        ++left;
                        --right;
                    } else if (sum < target)
                        ++left;
                    else --right;
                }
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        Test0715 test0715 = new Test0715();
        int target = -1000000000;
        int []nums = {0,0,0,-1000000000,-1000000000,-1000000000,-1000000000};
        System.out.println(test0715.fourSum(nums,target));
}
    }

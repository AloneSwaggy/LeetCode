import java.util.HashMap;
import java.util.Map;

public class Test0316 {

    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        counts.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIndex) {
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0);
                int prev1 = counts.getOrDefault(sum - 1, 0);
                ans += prev0 + prev1;
            }
        }
        return ans;
    }

    public int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;

    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = { 3, 2, 1, 4, 5 };// 3,2,1,5,4
        Test0316 test = new Test0316();
        int ans = test.countSubarrays(nums, k);
        System.out.println(ans);
    }

}

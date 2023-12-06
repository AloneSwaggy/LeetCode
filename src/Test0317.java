import java.util.Arrays;

public class Test0317 {
    // 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
    // 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度
    // 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] += f[i - 1] + nums[i];
        }
        for (int i = 0; i < m; i++) {
            queries[i] = binarySearch(f, queries[i]);
        }
        return queries;
    }

    int binarySearch(int[] f, int target) {
        int low = 0, high = f.length - 1; // 左闭右闭
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        Test0317 test = new Test0317();
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };
        int[] ans = test.answerQueries(nums, queries);
        for (int i : ans) {
            System.out.println(i);
        }

    }
}

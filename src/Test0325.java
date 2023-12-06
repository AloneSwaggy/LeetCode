public class Test0325 {
    // 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是非递减的。[1,2,4,3,5,6]
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j] >= arr[j - 1]) {
            --j;
        }
        if (i >= j)
            return 0;
        int ans = Math.min(j, n - 1 - i);
        for (int l = 0, r = j; l <= i; ++l) {
            while (r < n && arr[l] > arr[r]) {
                ++r;
            }
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }
}

public class Test0326 {
    // 判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同[4,2,4]
    public boolean findSubarrays(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                if (nums[i] + nums[i + 1] == nums[j] + nums[j + 1])
                    return true;
        return false;
    }

}

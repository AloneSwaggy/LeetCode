public class Test0326 {
    // �ж��Ƿ���� ���� ����Ϊ 2 �������������ǵ� �� ��ȡ�ע�⣬��������������ʼλ�õ��±���� ����ͬ[4,2,4]
    public boolean findSubarrays(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                if (nums[i] + nums[i + 1] == nums[j] + nums[j + 1])
                    return true;
        return false;
    }

}

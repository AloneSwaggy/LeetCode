import java.util.Arrays;

public class Test0317 {
    // ����һ������Ϊ n ���������� nums ����һ������Ϊ m ���������� queries ��
    // ����һ������Ϊ m ������ answer ������ answer[i] �� nums �� Ԫ��֮��С�ڵ��� queries[i] �� ������ �� ��� ����
    // ������ ����һ������ɾ��ĳЩԪ�أ�Ҳ���Բ�ɾ���������ı�ʣ��Ԫ��˳��õ���һ�����顣

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
        int low = 0, high = f.length - 1; // ����ұ�
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

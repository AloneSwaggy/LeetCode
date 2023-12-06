import java.util.Arrays;

public class Test0320 {
    char s[];
    int memo[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];// ���仯
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 ��ʾû�м����
        return n - f(0, 0, true, false);
    }

    int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0; // isNum Ϊ true ��ʾ�õ���һ���Ϸ�����
        if (!isLimit && isNum && memo[i][mask] != -1)
            return memo[i][mask]; // ��ֹ�ظ�����
        int res = 0;
        if (!isNum) // ����������ǰ��λ
            res = f(i + 1, mask, false, false);
        int up = isLimit ? s[i] - '0' : 9; // ���ǰ��������ֶ��� n ��һ������ô��һλ���������� s[i]������ͳ��� n ����
        for (int d = isNum ? 0 : 1; d <= up; ++d) // ö��Ҫ��������� d
            if ((mask >> d & 1) == 0) // d ���� mask ��
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        if (!isLimit && isNum)
            memo[i][mask] = res;
        return res;
    }

    public static void main(String[] args) {
        Test0320 test = new Test0320();
        int num = 1230;
        int ans = test.numDupDigitsAtMostN(num);
        System.out.println(ans);
    }

}

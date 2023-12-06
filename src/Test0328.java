public class Test0328 {

    public String shortestCommonSupersequence(String str1, String str2) {
        // f[i+1][j+1] ��ʾ s ��ǰ i ����ĸ�� t ��ǰ j ����ĸ����̹��������еĳ���
        // f[i+1][j+1]={f[i][j]+1 s[i]=t[j]
        // f[i+1][j+1]= min(f[i][j+1],f[i+1][j])+1 s[i] != t[j] ״̬ת�Ʒ���
        char[] s = str1.toCharArray(), t = str2.toCharArray();
        int n = s.length, m = t.length;
        int[][] f = new int[n + 1][m + 1];
        for (int j = 1; j < m; ++j)
            f[0][j] = j;
        for (int i = 1; i < n; ++i)
            f[i][0] = i;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (s[i] == t[j]) // ��̹���������һ������ s[i]
                    f[i + 1][j + 1] = f[i][j] + 1;
                else // ȡ���̵���ɴ�
                    f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + 1;

        int na = f[n][m];
        var ans = new char[na];
        for (int i = n - 1, j = m - 1, k = na - 1;;) {
            if (i < 0) { // s �ǿմ���ʣ��� t ������̹���������
                System.arraycopy(t, 0, ans, 0, j + 1);
                break; // �൱�ڵݹ�߽�
            }
            if (j < 0) { // t �ǿմ���ʣ��� s ������̹���������
                System.arraycopy(s, 0, ans, 0, i + 1);
                break; // �൱�ڵݹ�߽�
            }
            if (s[i] == t[j]) { // ����������һ������ s[i]
                ans[k--] = s[i--]; // ������ ans
                --j; // �൱�ڼ����ݹ� makeAns(i - 1, j - 1)
            } else if (f[i + 1][j + 1] == f[i][j + 1] + 1)
                ans[k--] += s[i--]; // �൱�ڼ����ݹ� makeAns(i - 1, j)
            else
                ans[k--] += t[j--]; // �൱�ڼ����ݹ� makeAns(i, j - 1)
        }
        return new String(ans);
    }
}

import java.util.Arrays;

public class Test0322 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        var ids = new Integer[n];
        for (int i = 0; i < n; ++i)
            ids[i] = i;
        Arrays.sort(ids, (i, j) -> scores[i] != scores[j] ? scores[i] - scores[j] : ages[i] - ages[j]);
        // �������������� f[i]=max(f[j])+scores[i]
        // ���� j<i �� ages[j]��ages[i]��
        // ��ʼ f[i]=0��Ϊ max(f[i])��
        var f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (ages[ids[i]] >= ages[ids[j]])
                    f[i] = Math.max(f[i], f[j]);
            f[i] += scores[ids[i]];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        Test0322 test = new Test0322();
        int[] scores = { 3, 4, 5, 6 }; // 3, 4, 5, 6 3 5 4 6
        int[] ages = { 1, 3, 2, 3 }; // 1, 3 , 2, 3 1 2 3 3
        int ans = test.bestTeamScore(scores, ages);
        System.out.println(ans);
    }
}

public class Test0315 {
    // Ã¶¾Ù ×î´óÍøÂçÖÈ
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] g = new int[n][n];
        int[] cnt = new int[n];
        for (var r : roads) {
            int a = r[0], b = r[1];
            g[a][b] = 1;
            g[b][a] = 1;
            ++cnt[a];
            ++cnt[b];
        }
        int ans = 0;
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test0315 test = new Test0315();
        int n = 4;
        int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        int ans = test.maximalNetworkRank(n, roads);
        System.out.println(ans);
    }

}

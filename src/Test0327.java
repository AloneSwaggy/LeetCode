public class Test0327 {
    // 求出字符串 ss 与字符串 tt 的连续子串中只差一个字符的子串数目 枚举
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                for (int k = 0; i + k < n && j + k < m; k++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff > 1) {
                        break;
                    }
                    if (diff == 1) {
                        ans++;
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test0327 test = new Test0327();
        String s = "ab";
        String t = "bb";
        int ans = test.countSubstrings(s, t);
        System.out.println(ans);
    }
}
// ab bb
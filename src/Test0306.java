public class Test0306 {
    public int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }

    public static void main(String[] args) {
        Test0306 tiny = new Test0306();
        String s = "aababbab";
        int ans = tiny.minimumDeletions(s);
        System.out.print(ans);

    }
}

class TR {
    public int minimumDeletions(String s) {
        int n = s.length();
        int ans = 0;
        int cntb = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                cntb++;// ans����
            } else {
                ans = Math.min(ans + 1, cntb);
            }
        }
        return ans;

    }
}
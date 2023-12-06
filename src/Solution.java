import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月16日 16:18:00
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "RLRRLLRLRL";
        int res = solution.balancedStringSplit(s);
        int ans = 4;
        if (ans == res) {
            System.out.println("answer is right");
        } else {
            System.out.println(
                    "answer is wrong,answer is " + ans + ",result is " + res);
        }
    }
}

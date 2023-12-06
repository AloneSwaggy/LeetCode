/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0717.java
 * @Description TODO
 * @createTime 2023年07月17日 14:30:00
 */
public class Test0717 {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            ans.append(carry % 10);
            carry /= 10;
        }
        return ans.reverse().toString();
    }
}

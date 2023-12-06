import java.util.ArrayDeque;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0807.java
 * @Description TODO
 * @createTime 2023年08月07日 16:31:00
 */
public class Test0807 {
    public String finalString(String s) {
        var q = new ArrayDeque<Character>();
        var tail = true;
        for (var c : s.toCharArray()) {
            if (c == 'i') tail = !tail;
            else if (tail) q.addLast(c);
            else q.addFirst(c);
        }
        var ans = new StringBuilder();
        for (var c : q) ans.append(c);
        if (!tail) ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Test0807 test0807 = new Test0807();
        String s = "string";
        System.out.println(test0807.finalString(s));
    }
}

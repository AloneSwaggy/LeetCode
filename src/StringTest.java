/**
 * @author admin
 * @version 1.0.0
 * @ClassName StringTest.java
 * @Description TODO
 * @createTime 2023年12月05日 17:14:00
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";            // 常量池
        String s2 = new String("abc");     // 堆内存中
        System.out.println(s1==s2);        // false两个对象的地址值不一样。
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.hashCode() == s2.hashCode());
        String s3="a"+"b"+"c";
        String s4="abc";
        System.out.println(s2==s3);
        System.out.println(s2.equals(s3));
    }
}

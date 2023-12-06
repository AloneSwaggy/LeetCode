import java.math.BigInteger;
import java.util.Scanner;

class Outer1 {
    private int a;

    public static void main(String args[]) {
        String s1 = "Ram";
        String s2 = "Ram";
        String s3 = new String("Ram");
        String s4 = new String("Ram");
        String s5 = "Shyam";

        System.out.println(" Comparing strings with equals:");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s5));

        System.out.println(" Comparing strings with ==:");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        System.out.println(" Comparing strings with compareto:");
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s5));

    }
}

// public class pp {
// public class ChangeOrNotTest {
// public static void changeOrNot(int i, double x[]) {
// i = -1;
// x[0] = -2;
// double y[] = x;
// y[1] = -3;
// double z[] = { -4, -8, -12 };
// x = z;
// }

// public static void main(String args[]) {
// String text = new String("java");
// text.replace('j', 'l');
// System.out.println(text);
// System.out.println(text.replace('j', 'l'));
// }
// }

// public static void main(String[] args) {
// // int k = 1;
// // double A[] = { 1.0, 2.0, 3.0 };
// // Scanner input = new Scanner(System.in);
// // int num = input.nextInt();
// // BigInteger bi = new BigInteger(num + "");
// // changeOrNot(k, A);
// // System.out.println("k = " + k);
// // System.out.println("A[0] = " + A[0]);
// // System.out.println("A[1] = " + A[1]);
// // System.out.println("A[2] = " + A[2]);
// // input.close();
// Scanner sc = new Scanner(System.in);
// String temp = sc.nextLine();
// // 大小写转换前的形式
// System.out.println(temp);
// StringBuffer sb = new StringBuffer();
// for (int i = 0; i < temp.length(); i++) {
// char c = temp.charAt(i);
// if (c >= 'A' && c <= 'Z') {
// c += 32;
// } else {
// c -= 32;
// }
// sb.append(c);
// }
// // 大小写转换后的形式
// // System.out.println(sb);
// }

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0819.java
 * @Description TODO
 * @createTime 2023年08月19日 16:49:00
 */
public class Test0819 {
        public int sum(int num1, int num2) {
            while (num2 != 0) {
                int carry = (num1 & num2) << 1;
                num1 ^= num2;
                num2 = carry;
            }
            return num1;
        }

    public static void main(String[] args) {
        Test0819 test0819 = new Test0819();
        System.out.println(test0819.sum(2,3));
    }
    }


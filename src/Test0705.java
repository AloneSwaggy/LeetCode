/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0705.java
 * @Description TODO
 * @createTime 2023年07月05日 15:14:00
 */
public class Test0705 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes){
            return  k;
        }
        if(k<= numOnes + numZeros){
            return numOnes;
        }
        if(k <= numOnes + numZeros + numNegOnes){
            return numOnes - (k - numOnes - numZeros);
        }
        return 0;
    }

    public static void main(String[] args) {
        Test0705 test0705 = new Test0705();
        int numOnes = 3;
        int numZeros = 1;
        int numNegOnes = 2;
        int k = 5;
        int ans = test0705.kItemsWithMaximumSum(numOnes,numZeros,numNegOnes,k);
        System.out.println(ans);
    }
}

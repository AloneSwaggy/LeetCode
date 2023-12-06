import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test0706.java
 * @Description TODO
 * @createTime 2023年07月06日 14:30:00
 */

//给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。
//
//    比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。
//    它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
//    请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。
//    你可以按 任意 顺序返回这些整数。
public class Test0706 {
    public List<Long> maximumEvenSplit(long finalSum) {
//        1. 判断奇偶，奇数则返回空数组
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return list;
        }
//        2.最多的偶数数目 贪心算法，从小的偶数开始加 2 4 ...如果没有排完则将余数与最后一项合并
        for (long i = 2; i <= finalSum; i += 2) {
            list.add(i);
            finalSum -= i;
        }
        if (finalSum != 0) {
            list.add(list.remove(list.size() - 1) + finalSum);
        }
        return list;
    }

    public static void main(String[] args) {
        Test0706 test0706 = new Test0706();
        int finalSum = 28;
        System.out.println(test0706.maximumEvenSplit(finalSum));
    }
}

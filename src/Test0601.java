import java.util.Arrays;

public class Test0601 {
    //给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
    //商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。

    //返回礼盒的 最大 甜蜜度。
    //输入：price = [13,5,1,8,21,2], k = 3
    //输出：8
    //解释：选出价格分别为 [13,5,21] 的三类糖果。
    //礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
    //可以证明能够取得的最大甜蜜度就是 8 。
    public int maximumTastiness(int[] price, int k){
        Arrays.sort(price);
        int left = 0;
        int right = price[price.length-1] - price[0];// []  左闭右闭 区间
        while (left <= right){
            int middle = left +  (right - left) / 2 ;
            if (check(price,middle)>= k){// 判断满足条件的个数
                left = middle + 1;
            }
            else  right = middle -1;
        }
        return right;
    }
    int check (int []price,int middle){
        int cnt = 1;
        int pre = price[0];
        for(int p : price){
            if(p >= pre + middle){
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int []price ={13,5,1,8,21,2};
        int k = 3;
        Test0601 test0601 = new Test0601();
        int ans = test0601.maximumTastiness(price,k);
        System.out.println(ans);
    }
}

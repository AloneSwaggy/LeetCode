import java.util.ArrayList;
import java.util.List;

public class Test0321 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }
    // 在进入 dfs(cur,n)之前 [0,cur?1] 位置的状态是确定的，而 [cur,n?1] 内位置的状态是不确定的，
    // dfs(cur,n) 需要确定 curcur 位置的状态，然后求解子问题 dfs(cur+1,n)

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            for (int i = 0; i < t.size(); i++) {
                System.out.println(t.get(i));
            }
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    // public List<List<Integer>> subsets(int[] nums) {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> initSub = new ArrayList<>();
    // res.add(initSub); // res = [[]]添加空集
    // for (int i = 0; i < nums.length; i++) {
    // int num = nums[i];
    // int time = res.size();//子集数量
    // for (int j = 0; j < time; j++) {
    // List<Integer> list = res.get(j);//每遇到一个新元素，在原来每个子集加上这个元素
    // List<Integer> sub = new ArrayList<>(list);//list 获取每个子集，sub添加新元素
    // sub.add(num);
    // res.add(sub);
    // }
    // }
    // return res;
    // }

    public static void main(String[] args) {
        Test0321 test = new Test0321();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = test.subsets(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}

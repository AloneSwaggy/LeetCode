import java.util.ArrayList;
import java.util.List;

public class Test0321 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }
    // �ڽ��� dfs(cur,n)֮ǰ [0,cur?1] λ�õ�״̬��ȷ���ģ��� [cur,n?1] ��λ�õ�״̬�ǲ�ȷ���ģ�
    // dfs(cur,n) ��Ҫȷ�� curcur λ�õ�״̬��Ȼ����������� dfs(cur+1,n)

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
    // res.add(initSub); // res = [[]]��ӿռ�
    // for (int i = 0; i < nums.length; i++) {
    // int num = nums[i];
    // int time = res.size();//�Ӽ�����
    // for (int j = 0; j < time; j++) {
    // List<Integer> list = res.get(j);//ÿ����һ����Ԫ�أ���ԭ��ÿ���Ӽ��������Ԫ��
    // List<Integer> sub = new ArrayList<>(list);//list ��ȡÿ���Ӽ���sub�����Ԫ��
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

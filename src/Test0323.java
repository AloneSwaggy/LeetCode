import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0323 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] cur = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(cur);
            int d = cur[1] - cur[0];
            Boolean check = true;
            for (int j = 2; j < cur.length; j++) {
                if ((cur[j] - cur[j - 1]) != d) {
                    check = false;
                    break;
                }
            }
            ans.add(check);
        }
        return ans;

    }
}

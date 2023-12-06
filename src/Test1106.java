/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1106.java
 * @Description TODO
 * @createTime 2023年11月06日 15:20:00
 */
public class Test1106 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int []masks = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length() ; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n ; j++) {
                if((masks[i] & masks[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
       }
        return  ans;
    }
}

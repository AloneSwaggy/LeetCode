class Test26 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length, res = 0;
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;// ͳ��������ĸ��Ŀ
        } // ���ڵ��ʼ�����ÿһ���ʣ�������ѡ����/���� 1/0

        for (int s = 1; s < (1 << n); s++) { // s<16 0001 0010 0011 0100 0101 0110
            int[] wordCount = new int[26]; // ͳ���Ӽ� s ���е��ʵ���ĸ��Ŀ
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) { // words[k] �����Ӽ� s �� k: 0001 0010 0100 1000
                    continue;
                }
                for (int i = 0; i < words[k].length(); i++) {
                    char c = words[k].charAt(i);
                    wordCount[c - 'a']++;
                }
            }
            boolean ok = true; // �ж��Ӽ� s �Ƿ�Ϸ�
            int sum = 0; // �����Ӽ� s �ĵ÷�
            for (int i = 0; i < 26; i++) {
                sum += score[i] * wordCount[i];
                ok = ok && (wordCount[i] <= count[i]);
            }
            if (ok) {
                res = Math.max(res, sum);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Test26 test = new Test26();
        int ans = test.maxScoreWords(words, letters, score);
        System.out.println(ans);
    }
}

class Test261 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }
}

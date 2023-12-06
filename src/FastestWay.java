public class FastestWay {
    static int last_f = 0;
    static int last_l = 0;

    public void fastestWay(int[][] a, int[][] t, int[][] l, int[] e, int[] x, int[][] f, int n) {
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];
        l[0][0] = 1;
        l[1][0] = 2;
        for (int i = 1; i < n; i++) {
            if (f[0][i - 1] + a[0][i] < f[1][i - 1] + t[1][i - 1] + a[0][i]) {
                f[0][i] = f[0][i - 1] + a[0][i];
                l[0][i] = 1;
            } else {
                f[0][i] = f[1][i - 1] + t[1][i - 1] + a[0][i];
                l[0][i] = 2;
            }
            if (f[1][i - 1] + a[1][i] < f[0][i - 1] + t[0][i - 1] + a[1][i]) {
                f[1][i] = f[1][i - 1] + a[1][i];
                l[1][i] = 2;
            } else {
                f[1][i] = f[0][i - 1] + t[0][i - 1] + a[1][i];
                l[1][i] = 1;
            }
        }
        if (f[0][n - 1] + x[0] < f[1][n - 1] + x[1]) {
            last_f = f[0][n - 1] + x[0];
            last_l = 1;
        } else {
            last_f = f[1][n - 1] + x[1];
            last_l = 2;
        }
    }

    public static void print_station_recursive(int[][] l, int last_l, int n) {

        if (n == 1)
            System.out.println("production line:" + last_l + " station :" + n);
        else {
            print_station_recursive(l, l[last_l - 1][n - 1], n - 1);
            System.out.println("production line:" + last_l + " station :" + n);
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[][]{{7, 9, 3, 4, 80}, {8, 5, 6, 4, 5}};
        int[][] t = new int[][]{{2, 3, 1, 3}, {2, 1, 2, 2}};
        int[][] l = new int[2][5];
        int[] e = new int[]{2, 4};
        int[] x = new int[]{3, 6};
        int[][] f = new int[2][5];
        FastestWay fast = new FastestWay();
        fast.fastestWay(a, t, l, e, x, f, n);
        System.out.println("The shortest time it takes is:" + last_f);
        print_station_recursive(l, last_l, 5);
    }
}

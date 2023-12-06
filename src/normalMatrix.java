public class normalMatrix {

    public static void main(String[] args) {

        // 生成两个16x16的随机矩阵
        int n = 400;
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = (int) (Math.random() * 10);
                matrix2[i][j] = (int) (Math.random() * 10);
            }
        }

        // 输出原始矩阵
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        // 计算矩阵乘积
        long startTime = System.currentTimeMillis();
        System.out.println("startTime " + startTime);
        int[][] product = multiply(matrix1, matrix2);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime " + endTime);
        // 输出结果矩阵
        System.out.println("Product:");
        printMatrix(product);
        long runTime = endTime - startTime;
        System.out.println("runtime: " + runTime);
    }

    public static int[][] multiply(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                C[i][j] = 0;
//            }
//        }
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Divide A and B into four submatrices
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    A11[i][j] = A[i][j];
                    A12[i][j] = A[i][j + n / 2];
                    A21[i][j] = A[i + n / 2][j];
                    A22[i][j] = A[i + n / 2][j + n / 2];
                    B11[i][j] = B[i][j];
                    B12[i][j] = B[i][j + n / 2];
                    B21[i][j] = B[i + n / 2][j];
                    B22[i][j] = B[i + n / 2][j + n / 2];
                }
            }

            // Compute products of submatrices
            int[][] C11 = add(multiply(A11, B11), multiply(A12, B21));
            int[][] C12 = add(multiply(A11, B12), multiply(A12, B22));
            int[][] C21 = add(multiply(A21, B11), multiply(A22, B21));
            int[][] C22 = add(multiply(A21, B12), multiply(A22, B22));

            // Combine submatrices to form C
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    C[i][j] = C11[i][j];
                    C[i][j + n / 2] = C12[i][j];
                    C[i + n / 2][j] = C21[i][j];
                    C[i + n / 2][j + n / 2] = C22[i][j];
                }
            }
        }
        return C;
    }


    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }


    public static void printMatrix(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

}

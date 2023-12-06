public class Strassen {

    public static void main(String[] args) {

        // 生成两个16x16的随机矩阵
        int n = 16;
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = 1;
                matrix2[i][j] = 1;
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
        long starTime = System.currentTimeMillis();
        int[][] product = strassen(matrix1, matrix2);
        long endtTime = System.currentTimeMillis();
        // 输出结果矩阵
        System.out.println("Product:");
        printMatrix(product);
        long runTime = endtTime - starTime;
        System.out.println("runtime:" + runTime);
    }

    public static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
            int[][] C11 = new int[n / 2][n / 2];
            int[][] C12 = new int[n / 2][n / 2];
            int[][] C21 = new int[n / 2][n / 2];
            int[][] C22 = new int[n / 2][n / 2];
            int[][] P1;
            int[][] P2;
            int[][] P3;
            int[][] P4;
            int[][] P5;
            int[][] P6;
            int[][] P7;

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

            // Compute P1, P2, ..., P7
            P1 = strassen(A11, subtract(B12, B22));
            P2 = strassen(add(A11, A12), B22);
            P3 = strassen(add(A21, A22), B11);
            P4 = strassen(A22, subtract(B21, B11));
            P5 = strassen(add(A11, A22), add(B11, B22));
            P6 = strassen(subtract(A12, A22), add(B21, B22));
            P7 = strassen(subtract(A11, A22), add(B11, B12));

            if (n == 16) {
                System.out.println("p1: ");
                printMatrix(P1);
                System.out.println("P2: ");
                printMatrix(P2);
                System.out.println("P3: ");
                printMatrix(P3);
                System.out.println("P4: ");
                printMatrix(P4);
                System.out.println("P5: ");
                printMatrix(P5);
                System.out.println("P6: ");
                printMatrix(P6);
                System.out.println("P7: ");
                printMatrix(P7);
            }
            // Compute C11, C12, C21, C22
            C11 = subtract(add(add(P5, P6), P4), P2);
            C12 = add(P1, P2);
            C21 = add(P3, P4);
            C22 = add(subtract(subtract(P1, P7), P3), P5);

            // Combine C11, C12, C21, C22 into C
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

    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
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

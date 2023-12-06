import java.time.LocalDateTime;
import java.util.Arrays;

public class matrix {
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
        int[][] product = matrixMultiplication(matrix1, matrix2);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime " + endTime);
        // 输出结果矩阵
        System.out.println("Product:");
        printMatrix(product);
        long runTime = endTime - startTime;
        System.out.println("runtime: " + runTime);
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
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

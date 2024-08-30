public class p1 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};

        int[][] result = strassenMultiply(matrix1, matrix2);

        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] strassenMultiply(int[][] matrix1, int[][] matrix2) {
        // Check if the matrices are compatible for multiplication
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrices are not compatible for multiplication");
        }

        int n = matrix1.length;
        int[][] result = new int[n][n];

        // Base case: If the matrices are 1x1, perform simple multiplication
        if (n == 1) {
            result[0][0] = matrix1[0][0] * matrix2[0][0];
        } else {
            // Divide the matrices into four submatrices
            int[][] a11 = new int[n / 2][n / 2];
            int[][] a12 = new int[n / 2][n / 2];
            int[][] a21 = new int[n / 2][n / 2];
            int[][] a22 = new int[n / 2][n / 2];

            int[][] b11 = new int[n / 2][n / 2];
            int[][] b12 = new int[n / 2][n / 2];
            int[][] b21 = new int[n / 2][n / 2];
            int[][] b22 = new int[n / 2][n / 2];

            // Populate the submatrices
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    a11[i][j] = matrix1[i][j];
                    a12[i][j] = matrix1[i][j + n / 2];
                    a21[i][j] = matrix1[i + n / 2][j];
                    a22[i][j] = matrix1[i + n / 2][j + n / 2];

                    b11[i][j] = matrix2[i][j];
                    b12[i][j] = matrix2[i][j + n / 2];
                    b21[i][j] = matrix2[i + n / 2][j];
                    b22[i][j] = matrix2[i + n / 2][j + n / 2];
                }
            }

            // Calculate the seven products required for Strassen's algorithm
            int[][] p1 = strassenMultiply(addMatrices(a11, a22), addMatrices(b11, b22));
            int[][] p2 = strassenMultiply(addMatrices(a21, a22), b11);
            int[][] p3 = strassenMultiply(a11, subtractMatrices(b12, b22));
            int[][] p4 = strassenMultiply(a22, subtractMatrices(b21, b11));
            int[][] p5 = strassenMultiply(addMatrices(a11, a12), b22);
            int[][] p6 = strassenMultiply(subtractMatrices(a21, a11), addMatrices(b11, b12));
            int[][] p7 = strassenMultiply(subtractMatrices(a12, a22), addMatrices(b21, b22));

            // Calculate the four quadrants of the result matrix
            int[][] c11 = addMatrices(subtractMatrices(addMatrices(p1, p4), p5), p7);
            int[][] c12 = addMatrices(p3, p5);
            int[][] c21 = addMatrices(p2, p4);
            int[][] c22 = addMatrices(subtractMatrices(addMatrices(p1, p3), p2), p6);

            // Combine the four quadrants to form the result matrix
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    result[i][j] = c11[i][j];
                    result[i][j + n / 2] = c12[i][j];
                    result[i + n / 2][j] = c21[i][j];
                    result[i + n / 2][j + n / 2] = c22[i][j];
                }
            }
        }

        return result;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }
}
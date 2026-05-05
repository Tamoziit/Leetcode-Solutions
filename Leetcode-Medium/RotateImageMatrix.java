/**
 * Time: O(n^2)
 * Space: O(1)
 * Algo: 90 Deg Rotation --> Transpose + Row Reversal
 */
public class RotateImageMatrix {
    public void rotate90deg(int[][] matrix) {
        int n = matrix.length;
        int i, j, k;

        // in-situ transpose
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                k = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = k;
            }
        }

        // in-situ row-reverse
        for (i = 0; i < n; i++) {
            for (j = 0; j < n / 2; j++) {
                k = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = k;
            }
        }
    }

    public void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImageMatrix ob = new RotateImageMatrix();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("Before rotation:");
        ob.display(matrix);

        System.out.println("After rotation:");
        ob.rotate90deg(matrix);
        ob.display(matrix);
    }
}

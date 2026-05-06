public class RotatingGravityBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        int i, j;

        // transpose of box
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // reversing rows to complete 90° rotation of box
        for (i = 0; i < n; i++) {
            for (j = 0; j < m / 2; j++) {
                char temp = result[i][j];
                result[i][j] = result[i][m - 1 - j];
                result[i][m - 1 - j] = temp;
            }
        }

        // Applying gravity effect over each column, to let stones fall to the lowest
        // possible empty cell in each column
        for (j = 0; j < m; j++) {
            int lastEmptyCellRow = n - 1;

            // Processing each cell in column `j` from bottom to top
            for (i = n - 1; i >= 0; i--) {
                // Found a stone - letting it fall to the lowest empty cell
                if (result[i][j] == '#') {
                    result[i][j] = '.'; // curr idx = empty
                    result[lastEmptyCellRow][j] = '#'; // stone falls to the last empty cell in the coulmn
                    lastEmptyCellRow--; // new empty cell is just above where the stone fell
                }

                // Found an obstacle - resetting `lastEmptyCellRow` to the row directly above it
                if (result[i][j] == '*') {
                    lastEmptyCellRow = i - 1;
                }
            }
        }

        return result;
    }

    private void display(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        int i, j;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(box[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotatingGravityBox ob = new RotatingGravityBox();

        System.out.println("TEST CASE 1\n---------------");
        char[][] box1 = { { '#', '.', '#' } };
        System.out.println("Before rotation:");
        ob.display(box1);
        System.out.println("After rotation:");
        box1 = ob.rotateTheBox(box1);
        ob.display(box1);

        System.out.println("TEST CASE 2\n---------------");
        char[][] box2 = { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } };
        System.out.println("Before rotation:");
        ob.display(box2);
        System.out.println("After rotation:");
        box2 = ob.rotateTheBox(box2);
        ob.display(box2);

        System.out.println("TEST CASE 3\n---------------");
        char[][] box3 = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' } };
        System.out.println("Before rotation:");
        ob.display(box3);
        System.out.println("After rotation:");
        box3 = ob.rotateTheBox(box3);
        ob.display(box3);
    }
}

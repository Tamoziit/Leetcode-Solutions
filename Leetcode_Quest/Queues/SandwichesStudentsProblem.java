/**
 * Algo: Counting Approach
 * Time: O(n + m) --> n = no. of students, m = no. of sandwiches
 * Space: O(1)
 */
class SandwichesStudentsProblem {

    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        // Count the number of students who want each type of sandwich
        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        // Serve sandwiches to students
        for (int sandwich : sandwiches) {
            // No student wants the circle sandwich on top of the stack
            if (sandwich == 0 && circleStudentCount == 0) {
                return squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if (sandwich == 1 && squareStudentCount == 0) {
                return circleStudentCount;
            }
            // Decrement the count of the served sandwich type
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        // Every student received a sandwich
        return 0;
    }

    public static void main(String[] args) {
        SandwichesStudentsProblem ob = new SandwichesStudentsProblem();
        int[] students1 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches1 = {1, 0, 0, 0, 1, 1};

        int case1 = ob.countStudents(students1, sandwiches1);
        System.out.println("Case 1 = " + case1);

        int[] students2 = {1, 1, 0, 0};
        int[] sandwiches2 = {0, 1, 0, 1};

        int case2 = ob.countStudents(students2, sandwiches2);
        System.out.println("Case 2 = " + case2);
    }
}

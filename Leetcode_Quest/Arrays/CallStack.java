/**
 * Time: O(logs)
 * Mem: O(n)
 */
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class CallStack {

    public int[] exclusiveTime(int n, List<String> logs) {
        // separate time to several intervals, add interval to their function
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int pre = 0; // pre means the start of the interval

        for (String log : logs) {
            String[] arr = log.split(":");
            if (arr[1].equals("start")) {
                if (!st.isEmpty()) {
                    result[st.peek()] += Integer.parseInt(arr[2]) - pre;
                }
                // arr[2] is the start of next interval, doesn't belong to current interval.
                st.push(Integer.valueOf(arr[0]));
                pre = Integer.parseInt(arr[2]);
            } else {
                result[st.pop()] += Integer.parseInt(arr[2]) - pre + 1;
                // arr[2] is end of current interval, belong to current interval. That's why we have +1 here
                pre = Integer.parseInt(arr[2]) + 1;
                // pre means the start of next interval, so we need to +1
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CallStack ob = new CallStack();
        List<String> logs = Arrays.asList(
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"
        );
        int n = 2;

        int[] res = ob.exclusiveTime(n, logs);
        for (int i = 0; i < n; i++) {
            System.err.print(res[i] + " ");
        }
        System.err.println();
    }
}

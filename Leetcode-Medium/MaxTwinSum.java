
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MaxTwinSum {

    /**
     * Simulation & 2-half Approach
     * Time: O(N)
     * Space: O(N)
     */
    public int pairSum_1(ListNode head) {
        ListNode headPtr = head;
        int n = 0, x = 0;

        while (headPtr != null) {
            n++;
            headPtr = headPtr.next;
        }

        int[] twinSum = new int[n / 2];
        int max = Integer.MIN_VALUE;

        while (head != null) {
            if (x < n / 2) {
                twinSum[x] += head.val;
            } else {
                twinSum[n - 1 - x] += head.val;
            }

            x++;
            head = head.next;
        }

        for (int sum : twinSum) {
            System.out.print(sum + " ");
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * Two Pointer with Reversal
     * Time: O(N)
     * Space: O(1)
     */
    public int pairSum_2(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        int max = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // fast pointer

            // Reversing 1st half of slow pointer
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (slow != null && prev != null) {
            max = Math.max(max, prev.val + slow.val);
            prev = prev.next; // traversing 1st reversed half towards left
            slow = slow.next; // traversing 2nd non-reversed half towards right
        }

        return max;
    }

    public static void main(String[] args) {
        MaxTwinSum ob = new MaxTwinSum();

        System.out.println("TEST CASE 1:");
        ListNode head_1 = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        System.out.println("\nM1: Max Twin Sum = " + ob.pairSum_1(head_1));
        System.out.println("M2: Max Twin Sum = " + ob.pairSum_2(head_1));

        System.out.println("TEST CASE 2:");
        ListNode head_2 = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println("\nM1: Max Twin Sum = " + ob.pairSum_1(head_2));
        System.out.println("M2: Max Twin Sum = " + ob.pairSum_2(head_2));

        System.out.println("TEST CASE 3:");
        ListNode head_3 = new ListNode(1, new ListNode(1000));
        System.out.println("\nM1: Max Twin Sum = " + ob.pairSum_1(head_3));
        System.out.println("M2: Max Twin Sum = " + ob.pairSum_2(head_3));
    }
}

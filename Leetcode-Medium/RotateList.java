public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // determinig tail & length
        int n = 1; // taking head into account
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // determining true rotations
        k = k % n;
        if (k == 0)
            return head;

        // Circular LL
        tail.next = head;

        // finding new tail after (n - k - 1) steps at (n - k)th node
        int steps = n - k - 1;
        ListNode newTail = head;

        for (int i = 1; i <= steps; i++) { // steps counted as 1..2..3... not from 0 as idx
            newTail = newTail.next;
        }

        // breaking circle at (n - k)
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    private static void printList(String label, ListNode head) {
        StringBuilder sb = new StringBuilder(label + ": [");
        ListNode curr = head;

        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        RotateList ob = new RotateList();

        // Test case 1: [1,2,3,4,5], k = 2 → expected: [4,5,1,2,3]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        printList("Test 1 bfr rotation", head1);
        ListNode result1 = ob.rotateRight(head1, 2);
        printList("Test 1 aftr rotation", result1);

        // Test case 2: [0,1,2], k = 4 → expected: [2,0,1]
        ListNode head2 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2)));

        printList("Test 2 bfr rotation", head2);
        ListNode result2 = ob.rotateRight(head2, 4);
        printList("Test 2 aftr rotation", result2);
    }
}

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
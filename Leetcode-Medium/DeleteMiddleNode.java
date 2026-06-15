
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

public class DeleteMiddleNode {

    public ListNode deleteMiddle_1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode headPtr = head;
        int n = 0, x = 0;

        while (headPtr != null) {
            n++;
            headPtr = headPtr.next;
        }

        headPtr = head;
        while (headPtr != null) {
            if (x == ((n / 2) - 1)) {
                headPtr.next = headPtr.next.next;
                break;
            }

            x++;
            headPtr = headPtr.next;
        }

        return head;
    }

    public ListNode deleteMiddle_2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head.next.next; // fast is 2-steps ahead of slow

        // traversing fastPtr to the end of the node -> so that slow is in [middle - 1]th pos.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // breaking middle link
        slow.next = slow.next.next;
        return head;
    }

    private void display(ListNode head) {
        if (head == null) {
            System.out.println("Empty list -> null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        ListNode curr = head;

        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }

            curr = curr.next;
        }
        sb.append(" -> null");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        DeleteMiddleNode ob = new DeleteMiddleNode();

        System.out.println("TEST CASE 1:");
        ListNode head_1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        System.out.println("Input:");
        ob.display(head_1);
        head_1 = ob.deleteMiddle_1(head_1);
        System.out.println("Output M1:");
        ob.display(head_1);
        head_1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        head_1 = ob.deleteMiddle_2(head_1);
        System.out.println("Output M2:");
        ob.display(head_1);

        System.out.println("\nTEST CASE 2:");
        ListNode head_2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Input:");
        ob.display(head_2);
        head_2 = ob.deleteMiddle_1(head_2);
        System.out.println("Output M1:");
        ob.display(head_2);
        head_2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head_2 = ob.deleteMiddle_2(head_2);
        System.out.println("Output M2:");
        ob.display(head_2);

        System.out.println("\nTEST CASE 3:");
        ListNode head_3 = new ListNode(2, new ListNode(1));
        System.out.println("Input:");
        ob.display(head_3);
        head_3 = ob.deleteMiddle_1(head_3);
        System.out.println("Output M1:");
        ob.display(head_3);
        head_3 = new ListNode(2, new ListNode(1));
        head_3 = ob.deleteMiddle_2(head_3);
        System.out.println("Output M2:");
        ob.display(head_3);

        System.out.println("\nTEST CASE 4:");
        ListNode head_4 = new ListNode(1);
        System.out.println("Input:");
        ob.display(head_4);
        head_4 = ob.deleteMiddle_1(head_4);
        System.out.println("Output M1:");
        ob.display(head_4);
        head_4 = new ListNode(1);
        head_4 = ob.deleteMiddle_2(head_4);
        System.out.println("Output M2:");
        ob.display(head_4);
    }
}

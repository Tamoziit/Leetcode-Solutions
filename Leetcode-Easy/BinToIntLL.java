/*
 * LC - 1290
 * Time - O(N) [N = no. of nodes]
 * Space - O(1)
 */
// Definition for singly-linked list.
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

public class BinToIntLL {
    public int getDecimalValue(ListNode head) {
        int decimal = 0;
        ListNode curr = head;
        while (curr != null) { // O(N)
            decimal = decimal * 2 + curr.val; // left shift (<<)
            curr = curr.next;
        }
        return decimal;
    }

    public static void main(String[] args) {
        // Building the linked list
        int[] binaryArray = { 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 };
        ListNode head = buildLinkedList(binaryArray);

        BinToIntLL ob = new BinToIntLL();
        ob.displayList(head);
        int result = ob.getDecimalValue(head);

        System.out.println("Output: " + result);
    }

    // Helper method to build a linked list from an array
    public static ListNode buildLinkedList(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public void displayList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.print("null\n");
    }
}

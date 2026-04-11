class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Insert copied nodes after each original node
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next; // restore original list
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}

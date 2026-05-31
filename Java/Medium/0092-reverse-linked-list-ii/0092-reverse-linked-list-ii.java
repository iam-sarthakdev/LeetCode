class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode beforeLeft = dummy;

        for(int i = 1; i < left; i++){
            beforeLeft = beforeLeft.next;
        }

        // now left is at left - 1
        ListNode prev = null;
        ListNode curr = beforeLeft.next;
        for(int i = 0; i < right - left + 1; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // relinking the linkedlist

        beforeLeft.next.next = curr;
        beforeLeft.next = prev;
        return dummy.next;
    }
}
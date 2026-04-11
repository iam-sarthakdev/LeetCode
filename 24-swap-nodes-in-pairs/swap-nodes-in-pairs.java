class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null){
            ListNode next = curr.next;
            if(next == null) return dummy.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
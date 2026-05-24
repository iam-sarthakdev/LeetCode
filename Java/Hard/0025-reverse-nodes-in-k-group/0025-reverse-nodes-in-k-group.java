class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        // check if k nodes exists
        while(true){
            ListNode kth = groupPrev;
            // move k steps forward
            for(int i = 0; i < k; i++){
                kth = kth.next;
                if(kth == null) return dummy.next;
            }
            // k nodes exists forward, now start reversal 
            ListNode curr = groupPrev.next;
            ListNode prev = kth.next;
            for(int i = 0; i < k; i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode newGroupHead = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = newGroupHead;
        }
    }
}
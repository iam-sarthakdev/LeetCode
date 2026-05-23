class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for(int i = 0; i < n; i++){
            first = first.next;
        }

        if(first == null) return head.next;

        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }
}
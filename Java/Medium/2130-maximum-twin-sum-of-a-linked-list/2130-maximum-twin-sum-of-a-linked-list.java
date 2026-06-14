class Solution {
 public ListNode reverse(ListNode head){

    ListNode curr = head;
    ListNode prev = null;

    while(curr != null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
 }
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverse(slow.next);
        slow.next = temp;

        ListNode p1 = head;
        ListNode p2 = slow.next;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        while(p2 != null){
            sum = p1.val + p2.val;
            max = Math.max(sum, max);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
        
    }
}
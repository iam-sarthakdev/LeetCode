public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;

        while(b != a){
            a = (a == null)? headB : a.next;
            b = (b == null)? headA : b.next;
        }
        return a;
    }
}
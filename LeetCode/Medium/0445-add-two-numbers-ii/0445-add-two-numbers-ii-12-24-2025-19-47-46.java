class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode dummy = new ListNode(-1);

        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0){
           int sum = carry;
            if(!st1.isEmpty()){
                sum+= st1.pop();
            }
            if(!st2.isEmpty()){
                sum+= st2.pop();
            }
           int digit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(digit);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
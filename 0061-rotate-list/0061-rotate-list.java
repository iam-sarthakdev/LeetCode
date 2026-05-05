class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode temp = head;
        int len = 0;
        while(temp!=null)
        {
           len++;
           temp= temp.next;
        }
        k = k%len;
        if(k==0) return head;
        int pos = len-k-1;
        temp = head;
        for(int i=1;i<=pos;i++)
        {
             temp = temp.next;
        }
        ListNode res = temp.next;
        temp.next = null;
        temp = res;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = head;
        return res;
    }
}
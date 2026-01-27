class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
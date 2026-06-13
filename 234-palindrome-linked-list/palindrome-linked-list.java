/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
            public boolean isPalindrome(ListNode head){

                if(head == null || head.next == null) return true;

            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
                ListNode temp = reverse(slow.next);
                slow.next = temp;

                ListNode ptr1 = head;
                ListNode ptr2 = slow.next;

                while(ptr2 != null){
                    if(ptr1.val != ptr2.val) return false;
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return true;
            }
        }
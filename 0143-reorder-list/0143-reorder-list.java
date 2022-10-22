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
    public void reorderList(ListNode head) {
        if(head.next==null || head.next.next==null)
            return;
        ListNode slow = head, fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev;
        if(fast==null){
            rev = reverse(slow.next);
            slow.next = null;
        }
        else{
            rev = reverse(slow.next.next);
            slow.next.next = null;
        }
        join(head,rev);
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null, current = node, next = node;
        while(current!=null){
            next = next.next;
            current.next=prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private void join(ListNode node1, ListNode node2){
        ListNode temp = node1;
        while(temp!=null && node2!=null){
            ListNode next = temp.next;
            temp.next = node2;
            node2 = node2.next;
            temp.next.next=next;
            temp = next;
        }
    }
}
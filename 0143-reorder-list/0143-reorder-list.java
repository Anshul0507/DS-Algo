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
        // list size is even, slow will be on the left middle node
        // eg = List = 1,2,3,4
        // first half = 1,2; second half = 3,4
        if(fast==null){
            rev = reverse(slow.next);
            slow.next = null;
        }
        //list size is odd, so need to reverse the second half of list such that length of second half = length of first half -1
        // eg = List = 1,2,3,4,5
        // first half should be 1,2,3 -> second half = 4,5
        else{
            rev = reverse(slow.next.next);
            slow.next.next = null;
        }
        join(head,rev);
    }
    
    // function to reverse the list
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
    
    // join node 1, node 2 such that node 1 length >= node 2 length
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
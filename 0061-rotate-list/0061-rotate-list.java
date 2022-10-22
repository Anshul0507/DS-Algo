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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null)
            return head;
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        if(k%n==0)
            return head;
        k = n - k%n;
        temp = head;
        for(int i=1;i<k;i++)
            temp = temp.next;
        ListNode temp2 = temp.next, temp3 = temp.next;
        temp.next = null;
        while(temp3.next!=null)
            temp3 = temp3.next;
        temp3.next = head;
        return temp2;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode temp = head;
        int visMark = 1000000;
        while(temp!=null){
            if(temp.val == visMark)
                return true;
            temp.val=visMark;
            temp = temp.next;
        }
        return false;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp1 = node, temp2 = node.next, tempPrev=node;
        while(temp2!=null){
            temp1.val = temp2.val;
            tempPrev=temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        tempPrev.next=null;
    }
}
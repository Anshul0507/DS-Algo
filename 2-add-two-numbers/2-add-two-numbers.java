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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(), temp = res;
        int curr = 0, carry = 0;
        while(l1!=null || l2!=null || carry >0){
            temp.next = new ListNode();
            temp = temp.next;
            if(l1!=null){
                curr+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                curr+=l2.val;
                l2=l2.next;
            }
            temp.val = (curr + carry)%10;
            carry = (curr+carry)/10;
            curr = 0;
        }
        return res.next;
    }
}
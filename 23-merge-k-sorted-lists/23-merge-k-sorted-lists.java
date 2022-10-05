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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        List<Integer> l = new ArrayList<>();
        for(ListNode node : lists){
            ListNode temp = node;
            while(temp!=null){
                l.add(temp.val);
                temp = temp.next;
            }
        }
        if(l.size()==0)
            return null;
        Collections.sort(l);
        ListNode res = new ListNode(0), temp = res;
        for(int i: l){
            ListNode temp1 = new ListNode(i);
            temp.next=temp1;
            temp = temp.next;
        }
        return res.next;
    }
}
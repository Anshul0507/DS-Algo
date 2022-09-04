/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> dq = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            TreeNode curr = new TreeNode(nums[i]);
            while(!dq.isEmpty() && dq.peek().val<nums[i])
                curr.left = dq.pop();
            if(!dq.isEmpty())
                dq.peek().right=curr;
            dq.push(curr);
        }
        return dq.removeLast();
    }
}
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int maxi = 1;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int minIdx = q.peek().getValue();
            for(int i=0;i<size;i++){
                TreeNode curr = q.peek().getKey();
                int idx = q.poll().getValue();
                maxi = Math.max(maxi,idx-minIdx+1);
                if(curr.left!=null)
                    q.add(new Pair(curr.left,2*idx));
                if(curr.right!=null)
                    q.add(new Pair(curr.right,2*idx+1));
            }
        }
        return maxi;
    }
}
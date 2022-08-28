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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(reverse)
                    currList.add(0,node.val);
                else
                    currList.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            res.add(currList);
            reverse = !reverse;
        }
        return res;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode temp = new TreeNode(p.val);
            p=q;
            q=temp;
        }
        return lowestCommonAncestorHelper(root,p,q);
    }
    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val>=p.val && root.val<=q.val)
            return root;
        if(root.val>q.val)
            return lowestCommonAncestorHelper(root.left,p,q);
        return lowestCommonAncestorHelper(root.right,p,q);
    }
}
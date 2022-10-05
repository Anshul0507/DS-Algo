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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        makeTree(root,val,depth);
        return root;
    }
    
    private void makeTree(TreeNode root, int val, int depth){
        if(root==null)
            return;
        if(depth==2){
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode leftNew = new TreeNode(val);
            TreeNode rightNew = new TreeNode(val);
            leftNew.left = left;
            rightNew.right = right;
            root.left = leftNew;
            root.right = rightNew;
            return;
        }
        makeTree(root.left,val,depth-1);
        makeTree(root.right,val,depth-1);
    }
}
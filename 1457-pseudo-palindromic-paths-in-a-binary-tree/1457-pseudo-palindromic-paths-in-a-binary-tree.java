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
    int count =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        HashSet<Integer> pathSet = new HashSet<>();
        checkPalindrome(root,pathSet);
        return count;
    }
    
    private void checkPalindrome(TreeNode node, HashSet<Integer> pathSet){
        if(pathSet.contains(node.val))
            pathSet.remove(node.val);
        else
            pathSet.add(node.val);
        if(node.left==null && node.right==null){
            if(pathSet.size()<=1)
                count++;
        }
        if(node.left!=null)
            checkPalindrome(node.left,pathSet);
        if(node.right!=null)
            checkPalindrome(node.right,pathSet);
        if(pathSet.contains(node.val))
            pathSet.remove(node.val);
        else
            pathSet.add(node.val);
    }
}
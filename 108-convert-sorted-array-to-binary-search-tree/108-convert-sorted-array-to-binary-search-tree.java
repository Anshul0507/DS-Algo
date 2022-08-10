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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(0,nums.length-1,nums);
    }
    
    private TreeNode makeBST(int l, int r, int[] nums){
        if(l>r)
            return null;
        if(l==r)
            return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(l,mid-1,nums);
        root.right = makeBST(mid+1,r,nums);
        return root;
    }
}
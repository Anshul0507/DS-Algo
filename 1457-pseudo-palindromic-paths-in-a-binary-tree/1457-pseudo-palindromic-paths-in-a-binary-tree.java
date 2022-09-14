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
        int[] arr = new int[10];
        checkPalindrome(root,arr);
        return count;
    }
    
    private boolean isPalindrome(int[] arr){
        int countOdd =0;
        for(int n : arr){
            if(n%2==1)
                countOdd++;
            if(countOdd>1)
                return false;
        }
        return true;
    }
    
    private void checkPalindrome(TreeNode node, int[] arr){
        arr[node.val]++;
        if(node.left==null && node.right==null){
            if(isPalindrome(arr))
                count++;
        }
        if(node.left!=null)
            checkPalindrome(node.left,arr);
        if(node.right!=null)
            checkPalindrome(node.right,arr);
        arr[node.val]--;
    }
}
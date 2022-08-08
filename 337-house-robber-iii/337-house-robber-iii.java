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
    Map<TreeNode,Integer> maxWithNodeMap = new HashMap<>();
    Map<TreeNode,Integer> maxWithoutNodeMap = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(robTree(root,true),robTree(root,false));
    }
    
    public int robTree(TreeNode root, boolean withNode){
        if(root==null)
            return 0;
        if(withNode){
            if(maxWithNodeMap.containsKey(root))
                return maxWithNodeMap.get(root);
            maxWithNodeMap.put(root,(root.val + robTree(root.left,false) + robTree(root.right,false)));
                return maxWithNodeMap.get(root);
        }
        if(maxWithoutNodeMap.containsKey(root))
            return maxWithoutNodeMap.get(root);
        maxWithoutNodeMap.put(root,(Math.max(robTree(root.left,true),robTree(root.left,false)) + Math.max(robTree(root.right,true),robTree(root.right,false))));
        return maxWithoutNodeMap.get(root);
    }
}
// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/

// time: O(n)

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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }
        
        TreeNode left = searchBST(root.left, val);
        if(left != null) {
            return left;
        }
        
        TreeNode right = searchBST(root.right, val);
        if(right != null) {
            return right;
        }
        
        return null;
    }
}

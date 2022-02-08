// https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/


// O(n)

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
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftD = 0;
        int rightD = 0;
        if(root.left != null) {
            leftD = maxDepth(root.left);
        }
        if(root.right != null) {
            rightD = maxDepth(root.right);
        }
        if(leftD > rightD) {
            return leftD + 1;
        } else {
            return rightD + 1;
        }
    }
}

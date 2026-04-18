/*
Problem: https://leetcode.com/problems/invert-binary-tree/
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
    }
}

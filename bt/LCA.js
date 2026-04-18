/*
Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root; 
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
}

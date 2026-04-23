/*
Problem: https://leetcode.com/problems/delete-node-in-a-bst/submissions/1986131736/
*/
class Solution {
    public TreeNode findSuc(TreeNode root) {
        TreeNode curr = root.right;
        while(curr != null && curr.left != null) curr = curr.left;
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            if(left == null) return right;
            if(right == null) return left;

            TreeNode succ = findSuc(root);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        
        return root;
    }
}

/*
Problem: https://leetcode.com/problems/validate-binary-search-tree/
*/
public class Result {
    int min;
    int max;
    boolean isBST;
    Result(int min, int max, boolean isBST) {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class Solution {
    public Result check(TreeNode root) {
        if (root.left == null && root.right == null) return new Result(root.val, root.val, true);

        int min = root.val;
        int max = root.val;
        Result left;
        Result right;
        boolean isBST = true;

        if (root.left != null) {
            left = check(root.left);
            isBST = isBST && root.left.val < root.val && left.max < root.val && left.isBST;
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (root.right != null) {
            right = check(root.right);
            isBST = isBST && root.right.val > root.val && right.min > root.val && right.isBST;
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        return new Result(min, max, isBST);
    }

    public boolean isValidBST(TreeNode root) {
        return check(root).isBST;
    }
}

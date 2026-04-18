/*
Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int count = 0;
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                count++;
                if (count == k) break;
                curr = curr.right;
            }
        }
        return curr.val;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        return count(root, root.val);
    }

    public int count(TreeNode root, int max) {

        if (root == null) {
            return 0;
        }

        int good = 0;

        if (root.val >= max) {
            good = 1;
        }

        max = Math.max(max, root.val);

        return good
             + count(root.left, max)
             + count(root.right, max);
    }
}
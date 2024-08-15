package week20;

public class 이진_탐색_트리_BST_합의_범위_57 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        if (low <= root.val && root.val <= high) {
            result = root.val;
        }
        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);
        return result;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

package week19;

import java.util.*;

public class 정렬된_배열의_이진_탐색_트리_변환_55 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, lo, mid - 1);
        node.right = construct(nums, mid + 1, hi);
        return node;
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

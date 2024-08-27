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
  private int maxLength = 0;

  public int longestZigZag(TreeNode root) {
      dfs(root, -1, -1);
      return maxLength;
  }

  private int[] dfs(TreeNode node, int leftLength, int rightLength) {
      if (node == null) {
          return new int[]{-1, -1};
      }

      maxLength = Math.max(maxLength, Math.max(leftLength, rightLength) + 1);

      int[] left = dfs(node.left, rightLength + 1, -1);
      int[] right = dfs(node.right, -1, leftLength + 1);

      return new int[]{left[1] + 1, right[0] + 1};
  }
}


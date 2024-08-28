class Solution {
  public int pathSum(TreeNode root, int targetSum) {
      if (root == null) return 0;
      Map<Long, Integer> prefixSum = new HashMap<>();
      prefixSum.put(0L, 1);
      return dfs(root, 0, targetSum, prefixSum);
  }

  private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSum) {
      if (node == null) return 0;

      currentSum += node.val;
      int count = prefixSum.getOrDefault(currentSum - targetSum, 0);

      prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

      count += dfs(node.left, currentSum, targetSum, prefixSum);
      count += dfs(node.right, currentSum, targetSum, prefixSum);

      prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);

      return count;
  }
}

class TreeNode {
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


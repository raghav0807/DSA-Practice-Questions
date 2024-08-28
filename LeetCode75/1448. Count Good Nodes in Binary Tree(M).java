class Solution {
  public int goodNodes(TreeNode root) {
      return dfs(root, root.val);
  }
  
  private int dfs(TreeNode node, int maxVal) {
      if (node == null) {
          return 0;
      }
      
      int goodNodeCount = 0;
      if (node.val >= maxVal) {
          goodNodeCount = 1;
          maxVal = node.val;
      }
      
      goodNodeCount += dfs(node.left, maxVal);
      goodNodeCount += dfs(node.right, maxVal);
      
      return goodNodeCount;
  }
}



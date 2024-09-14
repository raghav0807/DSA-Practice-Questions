import java.util.HashMap;
import java.util.Map;

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

class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inorderIndexMap.get(rootVal);
        
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd);
        
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1);
        
        return root;
    }
}

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // First element of preorder is the root
        int rootValue = preorder[0];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = 0;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Create left and right arrays
        int[] leftPreorder = new int[rootIndex];
        int[] leftInorder = new int[rootIndex];

        int[] rightPreorder = new int[preorder.length - rootIndex - 1];
        int[] rightInorder = new int[inorder.length - rootIndex - 1];

        // Left inorder
        for (int i = 0; i < rootIndex; i++) {
            leftInorder[i] = inorder[i];
        }

        // Right inorder
        for (int i = rootIndex + 1; i < inorder.length; i++) {
            rightInorder[i - rootIndex - 1] = inorder[i];
        }

        // Left preorder
        for (int i = 1; i <= rootIndex; i++) {
            leftPreorder[i - 1] = preorder[i];
        }

        // Right preorder
        for (int i = rootIndex + 1; i < preorder.length; i++) {
            rightPreorder[i - rootIndex - 1] = preorder[i];
        }

       
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
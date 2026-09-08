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
     Map<Integer, Integer> map = new HashMap<>();
     public TreeNode buildTree(int[] inorder, int[] postorder) {
          for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(
            inorder,
            postorder,
            0,
            inorder.length - 1,
            0,
            postorder.length - 1
        );
     }
    public TreeNode helper( int[] inorder,
            int[] postorder,
            int instart,
            int inend,
            int poststart,
            int postend) {

        if(instart > inend || poststart > postend) return null;

        int nodeValue = postorder[postend];

        TreeNode node = new TreeNode(nodeValue);

        int index = map.get(nodeValue);
        int leftsize = index - instart;
        node.left = helper(inorder,postorder,instart,index -1,poststart,poststart + leftsize -1);
        node.right = helper(inorder,postorder,index + 1,inend,poststart + leftsize,postend-1);
        
        return node;
        
    }
}
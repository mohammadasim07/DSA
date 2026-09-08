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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder.length == 0 || postorder.length == 0) return null;

        int nodeValue = postorder[postorder.length - 1];

        TreeNode node = new TreeNode(nodeValue);

        int index = 0;
        while(inorder[index] != postorder[postorder.length - 1]){
            index++;
        }

        int[] inleft = new int[index];
        int[] inright = new int[inorder.length - index - 1];
        int[] poleft = new int[index];
        int[] poright = new int[postorder.length - index - 1];

        for(int i = 0;i<index;i++){
            inleft[i] = inorder[i];
        }
        for(int i = index + 1;i<inorder.length;i++){
            inright[i-index-1] = inorder[i];
        }
         for(int i = 0;i<index;i++){
            poleft[i] = postorder[i];
        }
         for(int i = index;i<postorder.length - 1;i++){
            poright[i-index] = postorder[i];
        }

        node.left = buildTree(inleft,poleft);
        node.right = buildTree(inright,poright);
        
        return node;
        
    }
}
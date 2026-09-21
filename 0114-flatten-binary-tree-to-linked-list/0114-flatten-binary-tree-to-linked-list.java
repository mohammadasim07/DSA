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
    public void flatten(TreeNode root) {

            TreeNode temp = root;

        while(temp != null){

            if(temp.left == null){
                temp = temp.right;
                continue;
            }

            TreeNode rightNode = temp.right;

            temp.right = temp.left;
            temp.left = null;

            TreeNode tempright = temp.right;
            while(tempright.right != null){
                tempright = tempright.right;
            }
            
            tempright.right = rightNode;
           
            temp = root.right;
        }

    }
}
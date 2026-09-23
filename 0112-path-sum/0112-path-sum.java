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

    boolean track = false;
    int data ;
    public void find(TreeNode root, int targetSum){
        if(root == null){
          
           
            return;
        } 
        data+=root.val;
        if(root.left == null && root.right == null && targetSum == data ){
                track = true;
        }
        find(root.left,targetSum);
        find(root.right,targetSum);
            data -= root.val;

       
             

        return;

       
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
            find(root,targetSum);
            return track;
    }
}
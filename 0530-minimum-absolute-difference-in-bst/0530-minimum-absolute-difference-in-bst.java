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
    int pre = -1;
    int data = Integer.MAX_VALUE;
    public void check(TreeNode root){
        if(root == null) return;

        check(root.left);
        if(pre != -1){
            data = Math.min(data, Math.abs(root.val - pre));
        }

         pre = root.val;
        check(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        check(root);
        return data;
    }
}
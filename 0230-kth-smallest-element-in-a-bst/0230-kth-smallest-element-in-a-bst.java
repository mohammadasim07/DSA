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

    int p = 0;
    int l = 0;

    public void pre(TreeNode root , int k){
        if(root == null) return;


        pre(root.left, k );

        if(root != null) l--;

        if(l == 0){
             p = root.val;
        }
        System.out.println(root.val + " " + k);

        pre(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        l = k;
        pre(root,k);
        return p;
      
    }
}
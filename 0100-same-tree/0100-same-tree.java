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
        boolean ans = true;

    public void find(TreeNode p, TreeNode q){
        if(p == null || q == null){
            if(p == null && q != null) ans = false;
            if(p != null && q == null) ans = false;
            return;
        } 
            

        if(p.val != q.val) ans = false;

        find(p.left,q.left);
        find(p.right, q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        find(p,q);
        return ans;

    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
         if (root == null) return null;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (root.val < min) {
            return lca(root.right, p, q);
        }

        if (root.val > max) {
            return lca(root.left, p, q);
        }

        return root;



    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        return lca(root,p,q);
    }
}
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

    public void pre(TreeNode root, int k) {
        if (root == null)
            return;

        pre(root.left, k);

        l++;
        if (l == k) {
            p = root.val;
        }
        
        pre(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {

        pre(root, k);
        return p;

    }
}
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
    
   



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return find(root, p, q);
    
        
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null ;

        if(root == p || root == q){
           return root;
        }
      TreeNode leftNode = find(root.left, p, q);
      TreeNode rightNode = find(root.right, p, q);
      
      if(leftNode != null && rightNode != null){
        return root;
      }
    if(leftNode != null) {
            return leftNode;
        }

        return rightNode;
    }



}
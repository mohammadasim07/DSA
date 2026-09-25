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
        List<List<Integer>> result = new ArrayList<>();

    public void iter(TreeNode root){
        int hight = hightTree(root);

        for(int level = 1 ;level <= hight;level++){
            List<Integer> arr = new ArrayList<>();
            if(level%2 == 0){
                levelOrder(root, level, arr);
            }else{
            levelOrder1(root, level, arr);

            }
            result.add(arr);
        }
    }

    public void levelOrder(TreeNode root, int level, List<Integer> ans){
            if(root == null) return;

            if(level == 1){
                ans.add(root.val);
                return;
            }
            
            levelOrder(root.right , level - 1 , ans);
            levelOrder(root.left , level - 1 , ans);

    } 
    public void levelOrder1(TreeNode root, int level, List<Integer> ans){
            if(root == null) return;

            if(level == 1){
                ans.add(root.val);
                return;
            }
            
            levelOrder1(root.left , level - 1 , ans);
            levelOrder1(root.right , level - 1 , ans);

    } 


    public int hightTree(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(hightTree(root.left),hightTree(root.right));
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        iter(root);
        return result;
    }
}
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
    public int max;
    public int min;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            return true;
        }
        
        boolean lok = isValidBST(root.left);
        int lmax = max;
        int lmin = min;

        boolean rok = isValidBST(root.right);
        int rmax = max;
        int rmin = min;

        max = Math.max(Math.max(lmax, rmax), root.val);
        min = Math.min(Math.min(rmin,lmin), root.val);

        return root.val < rmin && root.val > lmax && lok && rok;
    }
}

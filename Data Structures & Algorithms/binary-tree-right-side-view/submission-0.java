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
    public static int MAXN = 101;

	public static TreeNode[] queue = new TreeNode[MAXN];

	public static int l, r;

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        l = r = 0;
        queue[r++] = root;
        List<Integer> res = new ArrayList<>();
        while(l < r){
            int size = r - l;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue[l++];
                if(cur.left != null){
                    queue[r++] = cur.left;
                }
                if(cur.right != null){
                    queue[r++] = cur.right;
                }

                if(i == size - 1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

}

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
    public Map<Integer, Integer> inorder_map = new HashMap<>();
    public int n;
    public int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = inorder.length;

        for(int i = 0; i < n; i++){
            inorder_map.put(inorder[i], i);
        }

        pre = preorder;
        
        return build(0, n - 1, 0, n - 1);
    }

    public TreeNode build(int ps, int pe, int is, int ie){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int index_inorder_root = inorder_map.get(root.val);

        int left_size = index_inorder_root - is;
        int right_size = ie - index_inorder_root;

        root.left = build(ps + 1, ps + left_size, is, index_inorder_root - 1);
        root.right = build(ps + left_size + 1, pe, index_inorder_root + 1, ie);
        return root;
    }
}

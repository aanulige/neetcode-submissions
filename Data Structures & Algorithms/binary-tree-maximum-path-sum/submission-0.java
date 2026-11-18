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
    private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode node){
		maxGain(node);
		return maxSum;
	}

	private int maxGain(TreeNode node){
		if(node == null) return 0;

		int left = Math.max(maxGain(node.left),0);

		int right = Math.max(maxGain(node.right), 0);

		int cur = left+ right + node.val;

		maxSum = Math.max(maxSum, cur);

		return node.val + Math.max(left, right);
	}
}

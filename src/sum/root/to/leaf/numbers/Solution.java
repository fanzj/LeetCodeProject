package sum.root.to.leaf.numbers;

public class Solution {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			sum = root.val;
			// System.out.println("sum = " + sum);
		} else if (root.left == null) {
			root.right.val = root.val * 10 + root.right.val;
			sum += sumNumbers(root.right);
		} else if (root.right == null) {
			root.left.val = root.val * 10 + root.left.val;
			sum += sumNumbers(root.left);
		} else {
			root.left.val = root.val * 10 + root.left.val;
			sum += sumNumbers(root.left);
			root.right.val = root.val * 10 + root.right.val;
			sum += sumNumbers(root.right);
		}
		return sum;
	}

	public int sumNumbers2(TreeNode root) {
		int sum = 0;
		if(root==null)
			return sum;
		return preorderSumNumbers(root, sum);
	}

	public int preorderSumNumbers(TreeNode root, int sum) {
		if (root == null)
			return 0;
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null)
			return sum;
		return preorderSumNumbers(root.left, root.val) + preorderSumNumbers(root.right, root.val);
	}

	public TreeNode insert(int x, TreeNode t) {
		if (t == null)
			t = new TreeNode(x);
		else if (x <= t.val) {
			t.left = insert(x, t.left);
		} else {
			t.right = insert(x, t.right);
		}
		return t;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int[] A = {5,3,8,1,4,7,9};
		// int[] A = {2,1,3};
		int[] A = { 3, 2 };
		// int[] A = {};
		TreeNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.sumNumbers(node));
	}
}

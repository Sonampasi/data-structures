/* Time complexity : O(n)
 * Space complexity : O(n)
 */
public class BinaryTreeLCA {

	TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		// Base case
		if (root == null)
			return null;

		if (root == n1 || root == n2)
			return root;

		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCA(root.left, n1, n2);
		TreeNode right_lca = findLCA(root.right, n1, n2);
		//if one node in left subtree and other one in right subtree
		if (left_lca != null && right_lca != null)
			return root;
		//if both nodes are either in left subtree or right subtree
		return (left_lca != null) ? left_lca : right_lca;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		BinaryTreeLCA lca = new BinaryTreeLCA();
		System.out.println(lca.findLCA(root, root.right, root.right.right).val);
	}

}

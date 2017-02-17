//Definition for a binary tree node.
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}
public class InvertBinaryTree {
	TreeNode temp = null;
	public TreeNode invertTree(TreeNode root) {
		if(root == null){
			return root;
		}else{
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			root.left = invertTree(root.left);
			root.right = invertTree(root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		InvertBinaryTree obj = new InvertBinaryTree();
		obj.invertTree(root);
		BinaryTreeTraversal print = new BinaryTreeTraversal(root);
		print.inorder();
	}
}

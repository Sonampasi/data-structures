
public class BinaryTreeTraversalUsingRecursion {

	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val + " ");
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		BinaryTreeTraversalUsingRecursion obj1 = new BinaryTreeTraversalUsingRecursion();
		obj1.preorder(root);
		System.out.println();
		BinaryTreeTraversalUsingRecursion obj2 = new BinaryTreeTraversalUsingRecursion();
		obj2.inorder(root);
		System.out.println();
		BinaryTreeTraversalUsingRecursion obj3 = new BinaryTreeTraversalUsingRecursion();
		obj3.postorder(root);
	}

}

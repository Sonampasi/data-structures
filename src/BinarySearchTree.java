class BinarySearchTreeNode {
	int data;
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;

	public BinarySearchTreeNode(int data) {
		this.data = data;
	}
}

public class BinarySearchTree {

	BinarySearchTreeNode root;
	BinarySearchTreeNode parent = null;
	
	public BinarySearchTree(BinarySearchTreeNode root) {
		this.root = root;
	}

	// find a node
	public BinarySearchTreeNode find(int data) {
		if (root == null) {
			System.out.println("Node does not exist!! ");
		}
		while (root != null) {
			if (data == root.data) {
				return root;
			} else if (data < root.data) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}

	// insert new node 
	public BinarySearchTreeNode insert(BinarySearchTreeNode root, int data) {
		if (root == null) {
			root = new BinarySearchTreeNode(data);
			return root;
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else if (data > root.data) {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	// remove a node
	public BinarySearchTreeNode remove(BinarySearchTreeNode root, int data) {
		if (root == null) {
			return root;
		} else if (data < root.data) {
			root.left = remove(root.left, data);
		} else if (data > root.data) {
			root.right = remove(root.right, data);
		} else {
			// when no child is null
			if (root.left != null && root.right != null) {
				// store current root node
				parent = root;
				// replace current root node with its left node
				root = remove(root.left, root.data);
				// replace right node with its parent's right node
				root.right = parent.right;
			} else {
				// when one or more children are null
				if (root.left == null && root.right == null) {
					root = null;
				} else if (root.right == null) {
					root = root.left;
				} else {
					root = root.right;
				}
			}
		}
		return root;
	}

	// print binary search tree
	public void inorderTraversal(BinarySearchTreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {

		BinarySearchTreeNode root = new BinarySearchTreeNode(6);

		BinarySearchTree obj = new BinarySearchTree(root);
		obj.insert(root, 4);
		obj.insert(root, 8);
		obj.insert(root, 2);
		obj.insert(root, 5);
		obj.insert(root, 7);
		obj.insert(root, 1);
		obj.insert(root, 3);

		System.out.println(obj.find(3).data);

		obj.inorderTraversal(root);
		System.out.println();
		obj.remove(root, 3);
		obj.inorderTraversal(root);
		System.out.println();
		obj.remove(root, 4);
		obj.inorderTraversal(root);
		System.out.println();
		obj.remove(root, 5);
		obj.inorderTraversal(root);

	}

}

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreeTraversal {
	TreeNode root;

	// initializing root and temporary preorderStack
	public BinaryTreeTraversal(TreeNode root) {
		this.root = root;
	}

	public void preorder() {
		Stack<TreeNode> preorderStack = new Stack();
		while (true) {
			while (root != null) {
				// print current node
				System.out.print(root.val + " ");
				preorderStack.push(root);
				// if left subtree exist, add to stack
				root = root.left;
			}
			if (preorderStack.isEmpty()) {
				break;
			}
			root = preorderStack.pop();
			// go to right subtree
			root = root.right;
		}

	}

	public void inorder() {
		Stack<TreeNode> inorderStack = new Stack();
		while (true) {
			while (root != null) {
				inorderStack.push(root);
				// if left subtree exist, add to stack
				root = root.left;
			}
			if (inorderStack.isEmpty()) {
				break;
			}
			root = inorderStack.pop();
			// print current node
			System.out.print(root.val + " ");
			// go to right subtree
			root = root.right;
		}
	}

	public void postorder() {
		Stack<TreeNode> postorderStack = new Stack();
		//insert root into the stack
		postorderStack.push(root);
		//keep track of previously visited node
		TreeNode previousNode = null;
		TreeNode currentNode = null;
		//loop till stack is not empty
		while (!postorderStack.isEmpty()) {
			//store top value in current node
			currentNode = postorderStack.peek();
			//if no node is visited yet or for next level visit
			if (previousNode == null || currentNode == previousNode.left || currentNode == previousNode.right ) {
				//if left child is not null 
				if (currentNode.left != null) {
					//push left child of current node into the stack
					postorderStack.push(currentNode.left);
				} 
				//if left child is null and right child is not
				else if (currentNode.right != null){
					//push right child of current node into the stack
					postorderStack.push(currentNode.right);
				}
			}
			//if current node's left child is already visited 
			else if (currentNode.left == previousNode) {
				//push right child into the stack
				postorderStack.push(currentNode.right);
			} else {
				//if current node has no child print node value
				System.out.print(currentNode.val + " ");
				//pop current node
				postorderStack.pop();
			}
			previousNode = currentNode;
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

		// BinaryTreeTraversal obj1 = new BinaryTreeTraversal(root);
		// obj1.preorder();
		// System.out.println();
		// BinaryTreeTraversal obj2 = new BinaryTreeTraversal(root);
		// obj2.inorder();
		// System.out.println();
		BinaryTreeTraversal obj3 = new BinaryTreeTraversal(root);
		obj3.postorder();
	}

}

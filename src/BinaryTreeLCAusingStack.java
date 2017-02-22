/* Time complexity : O(n)
 * Space complexity : O(h) 
 * h is height of the tree
 */
import java.util.Stack;

public class BinaryTreeLCAusingStack {

	Stack<TreeNode> s1 = new Stack();
	Stack<TreeNode> s2 = new Stack();
	Stack<TreeNode> postorderStack;

	//traverse the path upto the desired node
	public Stack<TreeNode> postorder(TreeNode root, TreeNode n) {
		postorderStack = new Stack();
		// insert root into the stack
		postorderStack.push(root);
		// keep track of previously visited node
		TreeNode previousNode = null;
		TreeNode currentNode = null;
		// loop till stack is not empty
		while (!postorderStack.isEmpty()) {
			// store top value in current node
			currentNode = postorderStack.peek();
			
			if (currentNode == n) {
				break;
			}
			
			// if no node is visited yet or for next level visit
			if (previousNode == null || currentNode == previousNode.left || currentNode == previousNode.right) {
				// if left child is not null
				if (currentNode.left != null) {
					// push left child of current node into the stack
					postorderStack.push(currentNode.left);
				}
				// if left child is null and right child is not
				else if (currentNode.right != null) {
					// push right child of current node into the stack
					postorderStack.push(currentNode.right);
				}
			}
			// if current node's left child is already visited
			else if (currentNode.left == previousNode && currentNode.right != null) {
				// push right child into the stack
				postorderStack.push(currentNode.right);
			} else {
				// pop current node
				postorderStack.pop();
			}
			previousNode = currentNode;
		}
		return postorderStack;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		s1 = postorder(root, p);
		s2 = postorder(root, q);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.peek() == s2.peek()) {
				return s1.peek();
			}
			if (s1.size() > s2.size()) {
				s1.pop();
			} else {
				s2.pop();
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(4);
		// root.right.left = new TreeNode(0);
		// root.right.right = new TreeNode(8);
		root.left.left.left = new TreeNode(8);
		// root.left.right.right = new TreeNode(4);
		//
		BinaryTreeLCAusingStack lca = new BinaryTreeLCAusingStack();
		System.out.println(lca.lowestCommonAncestor(root, root.right, root.left.right.left).val);

	}

}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree {
	
	public void DFS(Node root) {
		System.out.print(root.getData()+" ");
		// traverse children
	    int childCount = root.getChildren().size();
	    if (childCount == 0) {
	        // leaf node
	    } else {
	        for (int i = 0; i < childCount; i++) {
	            Node child = root.getChildren().get(i);
	            DFS(child);
	        }
	    }
	}
	public void BFS(Node root){
		Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            
            if (tempNode.getChildren() != null) {
            	for (int i = 0; i < tempNode.getChildren().size(); i++) {
                queue.add(tempNode.getChildren().get(i));
            	}
            }
        }
	 }
	
	public static void main(String[] args){
		Node root = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		
		root.addChild(node1);
		root.addChild(node2);
		root.addChild(node3);
		
	
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		node1.addChild(node4);
		node1.addChild(node5);
		
		Node node6 = new Node(7);
		node3.addChild(node6);
		
		Node node7 = new Node(8);
		node2.addChild(node7);
		
		Node node8 = new Node(9);
		Node node9 = new Node(10);
		node5.addChild(node8);
		node5.addChild(node9);
		
		Tree tree = new Tree();
		System.out.println("Depth-First-Search : ");
		tree.DFS(root);
		System.out.println("\n"+"Bredth-First-Search : ");
		tree.BFS(root);
		
	}

}

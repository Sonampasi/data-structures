import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree {
	
	Node root;
	ArrayList<Node> parentNodes = new ArrayList<Node>();
	
	public Tree(Node root){
		this.root = root;
	}
	
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
	public void createTree(Node root, Integer[] parent){
		
		//Node parentNode = new Node(root);
		parentNodes.add(root);
		for(int i=0;i<parent.length;i++){
		if(parent[i] == root.data){
			Node childNode = new Node(i);
			root.addChild(childNode);
		}
		}
		if (root.getChildren() != null) {
        	for (int i = 0; i < root.getChildren().size(); i++) {
			Node child = root.getChildren().get(i);
            createTree(child,parent);
        	}
		}
		
	}
	public void print(){
		for(int i=0; i<parentNodes.size();i++){
		  System.out.println(parentNodes.get(i).getData() +"->"+ parentNodes.get(i).getChildren());	
		}
	}
	
	public static void main(String[] args){
		Integer parent[]={1,5,5,2,2,-1,3};
		int rootData = Arrays.asList(parent).indexOf(-1);
		Node root = new Node(rootData);
		Tree tree = new Tree(root);
		tree.createTree(root,parent);
		tree.print();
		
		System.out.println("Depth-First-Search : ");
		tree.DFS(root);
		System.out.println("\n"+"Bredth-First-Search : ");
		tree.BFS(root);
		
		
//		
//		Node node1 = new Node(2);
//		Node node2 = new Node(3);
//		Node node3 = new Node(4);
//		
//		root.addChild(node1);
//		root.addChild(node2);
//		root.addChild(node3);
//		
//	
//		Node node4 = new Node(5);
//		Node node5 = new Node(6);
//		node1.addChild(node4);
//		node1.addChild(node5);
//		
//		Node node6 = new Node(7);
//		node3.addChild(node6);
//		
//		Node node7 = new Node(8);
//		node2.addChild(node7);
//		
//		Node node8 = new Node(9);
//		Node node9 = new Node(10);
//		node5.addChild(node8);
//		node5.addChild(node9);
//		
//		Tree tree = new Tree();
		
	}

}

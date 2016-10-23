import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		
		int n;
		Integer[] parent;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter total no. of nodes");
		n = in.nextInt();
		parent = new Integer[n];
		System.out.println("Enter parent array");
		for (int i = 0; i < n; i++) {
			parent[i] = in.nextInt();
		}
		
		int rootData = Arrays.asList(parent).indexOf(-1);
		Node root = new Node(rootData);
		Tree tree = new Tree(root);
		tree.createTree(root,parent);
		tree.print();
		
		System.out.println("Depth-First-Search : ");
		tree.DFS(root);
		System.out.println("\n"+"Bredth-First-Search : ");
		tree.BFS(root);
		
	}
}

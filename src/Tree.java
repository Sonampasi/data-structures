import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
	
	Node root;
	ArrayList<Node> parentNodes = new ArrayList<Node>();
	static ArrayList<Tree> treeNodes;
	
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
	public void createTree(Integer[] parent){				
		boolean visitedNodes[] = new boolean[parent.length];
		for(int vertex=0; vertex<treeNodes.size(); vertex++){
			Node treeNode = treeNodes.get(vertex).root;
			parentNodes.add(treeNode);
			for(int i=0; i<parent.length; i++){
				if(visitedNodes[i]){
					continue;
				}
				else if(parent[i] == treeNode.getData()){
					visitedNodes[i] = true;
					Node node = new Node(i);
					treeNode.addChild(node);
					Tree nextTreeNode = new Tree(node);
					treeNodes.add(nextTreeNode);
				}
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
		treeNodes = new ArrayList<Tree>();
		treeNodes.add(tree);
		tree.createTree(parent);
		tree.print();
		
		System.out.println("Depth-First-Search : ");
		tree.DFS(root);
		System.out.println("\n"+"Bredth-First-Search : ");
		tree.BFS(root);
		
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
	
	Node root;
	static ArrayList<Node> treeNodes;
	int height=0;
	static Integer[] dfsNodesHeight;
	static Integer[] bfsNodesHeight;
	
	public Tree(Node root){
		this.root = root;
	}
	
	public void DFS(Node root) {
		height++;
		System.out.print(root.getId()+" ");
		//store height of every node
		dfsNodesHeight[root.getId()]= height;
		// traverse children
	    int childCount = root.getChildren().size();
	    if (childCount == 0) {
	        // leaf node
	    } else {
	        for (int i = 0; i < childCount; i++) {
	        	//get height of parent node
	        	height = dfsNodesHeight[root.getId()];
	            Node child = root.getChildren().get(i);
	            DFS(child);
	        }
	    }
	}
	
	public void BFS(Node root){
		Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        height = 1;
        bfsNodesHeight[root.id] = height;
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.id + " ");
            
            if (tempNode.getChildren() != null) {
            	for (int i = 0; i < tempNode.getChildren().size(); i++) {
            		bfsNodesHeight[tempNode.getChildren().get(i).id] = bfsNodesHeight[tempNode.getId()]+1;
            		queue.add(tempNode.getChildren().get(i));
            	}
            }
        }
	 }
	
	public void createTree(Integer[] parent){	
		boolean visitedNodes[] = new boolean[parent.length];
		for(int vertex=0; vertex<treeNodes.size(); vertex++){
			Node treeNode = treeNodes.get(vertex);
			for(int i=0; i<parent.length; i++){
				if(visitedNodes[i]){
					continue;
				}
				if(parent[i] == treeNode.getId()){
					visitedNodes[i] = true;
					Node node = new Node(i);
					treeNode.addChild(node);					
					treeNodes.add(node);
				}
			}
		}
		
	}
	
	public void printTreeNodes(){
		int max=1;
		//print tree
		for(int i=0; i<treeNodes.size();i++){
		  System.out.println(treeNodes.get(i).getId() +"->"+ treeNodes.get(i).getChildren());	
		}
	}
	
	public void computeHeight(){		
		int max=1;
		//find max height of tree using dfs
		for (int i = 1; i < dfsNodesHeight.length; i++){
		     if (dfsNodesHeight[i] > max){
		      max = dfsNodesHeight[i];
		     }
		}
		System.out.println("\nThe maximum height of tree(dfs): " + max);
		//find max height of tree using bfs
		for (int i = 1; i < bfsNodesHeight.length; i++){
		     if (bfsNodesHeight[i] > max){
		      max = bfsNodesHeight[i];
		     }
		}
		System.out.println("The maximum height of tree(bfs): " + max);
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
		
		int rootId = Arrays.asList(parent).indexOf(-1);
		Node root = new Node(rootId);
		Tree tree = new Tree(root);
		treeNodes = new ArrayList<Node>();
		treeNodes.add(root);
		
		tree.createTree(parent);
		tree.printTreeNodes();
		
		dfsNodesHeight = new Integer[parent.length];
		System.out.println("Depth-First-Search : ");
		tree.DFS(root);
		
		bfsNodesHeight = new Integer[parent.length];
		System.out.println("\n"+"Bredth-First-Search : ");
		tree.BFS(root);
		
		tree.computeHeight();
		
		
	}
}

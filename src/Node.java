import java.util.ArrayList;


public class Node {
	
	int data;
	ArrayList<Node> children;
	private Node node;
	public boolean visited = false;
	
	public Node(int data){
		this.data = data;
		children = new ArrayList<Node>();
	}
	
	public int getData(){
		return data;
	}
	
	public ArrayList<Node> getChildren(){
		return children;
	}

	public void addChild(Node child){
		children.add(child);
	}
	
	@Override
    public String toString() {
        return "child = " + data ;
    }

}

import java.util.ArrayList;


public class Node {
	
	int id;
	ArrayList<Node> children;
	private Node node;
	
	public Node(int data){
		this.id = data;
		children = new ArrayList<Node>();
	}
	
	public int getId(){
		return id;
	}
	
	public ArrayList<Node> getChildren(){
		return children;
	}

	public void addChild(Node child){
		children.add(child);
	}
	
	@Override
    public String toString() {
        return "child = " + id ;
    }

}

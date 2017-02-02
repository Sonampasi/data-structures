import java.util.LinkedList;
import java.util.Queue;;

public class StackUsingQueue {
	
	Queue<Integer> queue;

    public StackUsingQueue() {
    	queue = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	 queue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop(){
    	int current = queue.peek();
    	Queue<Integer> tempQueue = new LinkedList<Integer>();
    	if(queue.isEmpty()){
    		return -1;
    	}
    	for(int i = 1; i < queue.size(); i++){	
    		tempQueue.add(current);
    		current = (int) ((LinkedList<Integer>) queue).get(i);
    	}
    	queue = tempQueue;
    	return current;
    }
    
    /** Get the top element. */
    public int top() {
    	if(!queue.isEmpty()){
    		int current = queue.peek();
    		for(int i = 0; i < queue.size(); i++){	
        		current = (int) ((LinkedList<Integer>) queue).get(i);
        	}
    		return current;
    	}else{
    		return -1;
    	}
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return(queue.size() == 0);
    }
    
    public static void main(String args[]) {
		StackUsingQueue obj = new StackUsingQueue();
		obj.push(23);
		//obj.push(6);
		System.out.println(obj.pop());
		int param_3 = obj.top();
		System.out.println(param_3);
		boolean param_4 = obj.empty();
		System.out.println(param_4);
    }
}

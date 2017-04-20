import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> heap;
	
	public Heap(){
		heap = new ArrayList<>();
	}
	
	//add new element in the heap
	public void insert(int item){	
		heap.add(item);
		shiftUp();
	}
	
	public int delete(){
		int size = heap.size();
		int removedItem = heap.get(0);
		int lastItem = heap.get(size-1);
		heap.set(0, lastItem);
		heap.remove(size-1);
		shiftDown();
		return removedItem;
	}
	
	//move up the element to maintain heap property
	public void shiftUp(){
		int i = heap.size()-1;
		int newItem = heap.get(i);
		while(i>=0){
			int p = (i-1)/2;
			int parent = heap.get(p);
			if (newItem > parent){
				//swap
				heap.set(i, parent);
				heap.set(p, newItem);
				i=p;
			}else{
				break;
			}
		}
	}
	
	public void shiftDown(){
		int p = 0;
		int l = 2*p+1;
		int r = 2*p+2;
		Integer left = heap.get(l);
		Integer right = heap.get(r);
		Integer parent = heap.get(p);
	
			while(left != null || right != null){
				if(l>heap.size() || r>heap.size()){
					break;
				}
				left = heap.get(l);
				right = heap.get(r);
				int max = Math.max(left, right);
				if(left == max && l<heap.size()){
					heap.set(p, left);
					heap.set(l, parent);
					p=l;
					
				}else if(right == max){
					heap.set(p, right);
					heap.set(r, parent);
					p=r;
					
				}else{
					break;
				}
				parent = heap.get(p);
				l = 2*p+1;
				r = 2*p+2;			
			}

		}
	
	public void find(int data){
		for(int i = 0; i<heap.size();i++){
			if(data == heap.get(i)){
				System.out.print("Found!!");
			}
		}
	}
	

	public void print(){
		for(int i = 0; i<heap.size();i++){
			System.out.print(heap.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		Heap obj = new Heap();
		obj.insert(23);
		obj.insert(20);
		obj.insert(5);
		obj.insert(17);
		obj.insert(30);
		obj.insert(10);
		obj.insert(35);
		obj.insert(40);
		obj.insert(39);
		obj.insert(60);
		obj.print();
		obj.delete();
		obj.print();
		obj.find(60);
		obj.find(20);
	}
}

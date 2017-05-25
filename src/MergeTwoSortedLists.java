
public class MergeTwoSortedLists {
	
	public void mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=null;
		while((l1!=null) || (l2!=null)){
		    if(l1 != null && l2 != null && l1.data<l2.data){
		    	head = l1;
		    	l1 = l1.next;
		    }else if(l2 != null){
		    	head = l2;
		    	l2 = l2.next;
		    }else{
		    	head = l1;
		    	l1 = l1.next;
		    }
		  
			System.out.print(head.data+" ");
			head = head.next;
	    }
	   }
	
	// print linked list
		public void print(ListNode head) {
			// initialize current node
			ListNode current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.print("\n");
		}
		
	public static void main(String[] args){
		LinkedList ls = new LinkedList();
		ListNode a1 = new ListNode(3);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(6);
		ListNode a4 = new ListNode(7);
		ListNode headB = ls.head;
		headB = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;


		ListNode b1 = new ListNode(0);
		ListNode b2 = new ListNode(2);
		ListNode b3 = new ListNode(5);
		ListNode headA = ls.head;
		headA = b1;
		b1.next = b2;
		b2.next = b3;
		MergeTwoSortedLists obj = new MergeTwoSortedLists();
		obj.mergeTwoLists(headA, headB);
	
		
	}
}

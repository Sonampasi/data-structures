
public class IntersectLinkedList {

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		ListNode listNodeA = headA;
		ListNode listNodeB = headB;
		ListNode intersectAt = null;
		ListNode tempB = null;
		while(listNodeA != null){
			while(listNodeB != null){
				if(listNodeA == listNodeB){
					return listNodeB;
				}
				listNodeB = listNodeB.next;
			}
			listNodeB = headB;
			listNodeA = listNodeA.next;
		}
		return intersectAt;
		
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
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(12);
		ListNode a3 = new ListNode(13);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode headA = ls.head;
		headA = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(2);
		ListNode headB = ls.head;
		headB = b1;
		b1.next = b2;
		b2.next = a3;		
		
		IntersectLinkedList obj = new IntersectLinkedList();
		ListNode intersectAt = obj.getIntersectionNode(headA,headB);
		obj.print(headA);
		obj.print(headB);
		if(intersectAt != null){
		System.out.print("\n"+intersectAt.data);
		}
		else{
			System.out.print("\nNo Intersection");
		}

	}

}

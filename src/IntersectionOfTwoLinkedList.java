public class IntersectionOfTwoLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pA = headA;
		ListNode pB = headB;
		if (pA == null || pB == null) {
			return null;
		}
		while (pA != null && pB != null && pA != pB) {
			pA = pA.next;
			pB = pB.next;
			if (pA == pB) {
				return pA;
			}
			if (pA == null) {
				pA = headB;
			}
			if (pB == null) {
				pB = headA;
			}
		}
		return headA;
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
		// TODO Auto-generated method stub
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

		IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();
		ListNode intersectAt = obj.getIntersectionNode(headA, headB);
		obj.print(headA);
		obj.print(headB);
		if (intersectAt != null) {
			System.out.print("\n" + intersectAt.data);
		} else {
			System.out.print("\nNo Intersection");
		}
	}

}

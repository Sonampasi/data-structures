public class ReverseLinkedList {

	// reversing linked list
	public void reverse(ListNode head) {
		ListNode temp = null, nextNode = null, current = head;
		while (current != null) {
			nextNode = current.next;
			current.next = temp;
			temp = current;
			current = nextNode;
		}
		// print reversed linked list
		current = temp;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.insertAtHead(2);
		ls.insertAtTail(5);
		ls.insertAtTail(12);
		ls.insertAtTail(21);
		ls.print();
		ReverseLinkedList rls = new ReverseLinkedList();
		rls.reverse(ls.head);
	}

}

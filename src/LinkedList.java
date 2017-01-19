class ListNode {
	public int data;// stores input value
	public ListNode next;// stores reference for next node

	// ListNode constructor
	public ListNode(int data) {
		this.data = data;
	}
}

public class LinkedList {

	ListNode head;

	// LinkedList constructor
	public LinkedList() {
		head = null;
	}

	// insert new node in linked list at beginning
	public void insertAtHead(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}

	// insert new node in linked list at specified position
	public void insertAtPositon(int data, int position)
			throws UnsupportedOperationException {
		int k = 1;
		ListNode current = head;
		ListNode temp = null;
		// create new node
		ListNode newNode = new ListNode(data);
		try {
			if (position == 1) {
				insertAtHead(data);
			} else {
				while (current != null && k < position) {
					k++;
					temp = current;
					current = current.next;
				}
				if (position < 1 || position != k) {
					throw new UnsupportedOperationException(
							"Invalid operation !!\n");
				}
				temp.next = newNode;
				newNode.next = current;
			}
		} catch (UnsupportedOperationException e) {
			System.out.print(e);
		}
	}

	// insert new node in linked list at last
	public void insertAtTail(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		ListNode previous = null;
		while (current != null) {
			previous = current;
			current = current.next;
		}
		previous.next = newNode;
	}

	// delete first node in linked list
	public void deleteAtHead() {
		try {
			ListNode temp = head;
			head = temp.next;
			System.out.println("\nDeleted first node ");
		} catch (Exception e) {
			System.out.print(e + ":Invalid operation !!\n");
		}
	}

	// delete last node in linked list
	public void deleteAtTail() {
		try {
			ListNode previous = head;
			ListNode tail = head.next;
			while (tail.next != null) {
				previous = previous.next;
				tail = tail.next;
			}
			previous.next = null;
			System.out.println("\nDeleted last node ");
		} catch (Exception e) {
			System.out.print(e + ":Invalid operation !!\n");
		}
	}

	// search for a node exist in linked list or not
	public boolean find(int data) {
		ListNode current = head;
		while (current != null) {
			if (current.data == data) {
				System.out.print("\nMatch Found for " + data);
				return true;
			}
			current = current.next;
		}
		System.out.print("\nNo Match Found for " + data);
		return false;
	}

	// print linked list
	public void print() {
		// initialize current node
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	public static void main(String args[]) {

		LinkedList list = new LinkedList();
		list.insertAtHead(12);
		list.insertAtHead(13);
		list.insertAtHead(14);
		list.insertAtHead(10);
		list.insertAtHead(11);
		list.print();
		list.insertAtPositon(18, 2);
		list.print();
		list.insertAtPositon(9, 11);// throws UnsupportedOperationException
		list.print();
		list.insertAtPositon(15, -1);// throws UnsupportedOperationException
		list.print();
		list.insertAtTail(21);
		list.print();
		list.find(13);
		list.deleteAtHead();
		list.print();
		list.deleteAtTail();
		list.print();
		list.deleteAtTail();
		list.print();
		list.find(13);
	}
}

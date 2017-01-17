class ListNode {
	public int data;// stores input value
	public ListNode next;// stores reference for next node

	// ListNode constructor
	public ListNode(int data) {
		this.data = data;
	}
}

public class LinkedList {
	// first node
	ListNode first;

	// LinkedList constructor
	public LinkedList() {
		first = null;
	}

	// insert new node in linked list at beginning
	public void add(int data) {
		// create new node
		ListNode head = new ListNode(data);
		head.next = first;
		first = head;
	}

	// insert new node in linked list at specified position
	public void addAtPositon(int data, int position) {
		int k = 1;
		ListNode head = first;
		ListNode temp = null;
		// create new node
		ListNode newNode = new ListNode(data);

		if (position == 1) {
			temp = first;
			first = newNode;
			newNode.next = temp;
		} else {
			while (head != null && k < position) {
				k++;
				temp = head;
				head = head.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
	}

	// insert new node in linked list at last
	public void addAtEnd(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		ListNode current = first;
		ListNode previous = null;
		while (current != null) {
			previous = current;
			current = current.next;
		}
		previous.next = newNode;
	}

	// delete first node in linked list
	public void deleteFirst() {
		ListNode temp = first;
		first = temp.next;
		System.out.println("\nDeleted first node ");
	}

	// delete last node in linked list
	public void deleteLast() {
		ListNode previous = first;
		ListNode tail = first.next;
		while (tail.next != null) {
			previous = previous.next;
			tail = tail.next;
		}
		previous.next = null;
		System.out.println("\nDeleted last node ");
	}

	// search for a node exist in linked list or not
	public boolean find(int data) {
		ListNode current = first;
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
		ListNode current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	public static void main(String args[]) {

		LinkedList list = new LinkedList();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(10);
		list.add(11);
		list.print();
		list.addAtPositon(18, 3);
		list.print();
		list.addAtPositon(9, 1);
		list.print();
		list.addAtPositon(15, 2);
		list.print();
		list.addAtEnd(21);
		list.print();
		list.find(13);
		list.deleteFirst();
		list.print();
		list.deleteLast();
		list.print();
		list.deleteLast();
		list.print();
		list.find(13);
	}
}

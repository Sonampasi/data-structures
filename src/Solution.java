public class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// using two pass
		ListNode first = head;
		// length of list
		int l = 0;
		while (first != null) {
			l++;
			first = first.next;
		}
		int i = l - n - 1;
		first = head;
		// if only one node exist in the list
		if (i < 0) {
			head = head.next;
		} else {
			while (i > 0) {
				i--;
				first = first.next;
			}
			first.next = first.next.next;
		}
		return head;
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
		ls.insertAtHead(3);
		ls.insertAtHead(2);
		ls.insertAtHead(1);
		ls.print();
		Solution s = new Solution();
		ListNode head = s.removeNthFromEnd(ls.head, 1);
		s.print(head);
	}

}

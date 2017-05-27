// singly-linked list
public class KLinkedList {
	ListNode head;

	public KLinkedList () {
		this.head = null;
	}

	public void insert (int val) {
		if (head == null) {
			head = new ListNode(val);
			return;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(val);
	}

	public void delete (int val) {
		if (!search(val)) {
			return;
		}
		if (head.data == val) {
			ListNode temp = head.next;
			head.next = head.next.next;
			head = temp;
			// is this right?
			return;
		}
		ListNode temp1 = head;
		ListNode prev = head;
		while (temp1.next != null) {
			prev = temp1;
			temp1 = temp1.next;
			if (temp1.data == val) {
				prev.next = temp1.next;
				return;
			}
		}
	}

	public boolean search (int val) {
		if (head.data == val) {
			return true;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.data == val) {
				return true;
			}
		}
		return false;
	}

	public String toString () {
		if (head == null) {
			return "list is empty";
		}
		String s = "List \n" + head.toString() + ", ";
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			s += temp.toString() + ", ";
		}
		return s;
	}

	public static void main (String[] args) {
		KLinkedList kl = new KLinkedList();
		kl.insert(3);
		kl.insert(4);
		kl.insert(1);
		kl.insert(2);
		kl.insert(1000000);
		System.out.println(kl.toString() + " " + kl.search(4));
		kl.delete(1);
		System.out.println(kl.toString() + " " + kl.search(1));
		kl.delete(3);
		System.out.println(kl.toString() + " " + kl.search(3));
		kl.delete(1000000);
		System.out.println(kl.toString() + " " + kl.search(1000000));
	}
}

class ListNode {
	int data;
	ListNode next;

	public ListNode (int data) {
		this.data = data;
		this.next = null;
	}

	public String toString () {
		return "val " + this.data;
	}
}
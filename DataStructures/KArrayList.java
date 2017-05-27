public class KArrayList {
	ListNode head;
	int maxSize;
	int currSize;

	public KArrayList () {
		head = null;
		maxSize = 1;
		currSize = 0;
	}

	public void insert (int v) {
		if (head == null) {
			head = new ListNode(v);
			currSize = 1;
			return;
		}
		if (currSize == maxSize) {
			maxSize *= 2;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(v);
		currSize++;
	}

	public boolean search (int v) {
		if (head.data == v) {
			return true;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.data == v) {
				return true;
			}
		}
		return false;
	}

	public void delete (int v) {
		if (!search(v)) {
			return;
		}
		currSize--;
		if (head.data == v) {
			ListNode temp = head.next;
			head.next = head.next.next;
			head = temp;
			return;
		}
		ListNode prev = head;
		ListNode temp1 = head;
		while (temp1.next != null) {
			prev = temp1;
			temp1 = temp1.next;
			if (temp1.data == v) {
				prev.next = temp1.next;
				return;
			}
		}
	}

	public void trimToSize () {
		maxSize = currSize;
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
		KArrayList kl = new KArrayList();
		kl.insert(3);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		kl.insert(4);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		kl.insert(1);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		kl.insert(2);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		kl.insert(1000000);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		System.out.println(kl.toString() + " " + kl.search(4));
		kl.delete(1);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		System.out.println(kl.toString() + " " + kl.search(1));
		kl.delete(3);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		System.out.println(kl.toString() + " " + kl.search(3));
		kl.delete(1000000);
		System.out.println("currSize: " + kl.currSize + " maxSize: " + kl.maxSize);
		System.out.println(kl.toString() + " " + kl.search(1000000));
	}
}

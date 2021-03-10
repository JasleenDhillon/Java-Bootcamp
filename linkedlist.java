package lecture8thapril;

public class linkedlist {

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;

		}
	}

	private Node head;
	private Node tail;
	private int size;

	public linkedlist() {

		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void AddFirst(int item) {
		Node temp = new Node(item, this.head);
		if (this.isEmpty()) {
			this.head = this.tail = temp;
		} else {
			this.head = temp;
		}
		this.size++;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public int getfirst() throws Exception {
		if (this.isEmpty()) {

			throw new Exception("list is empty");
		}
		return this.head.data;

	}

	public int getlast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("list is empty");
		}
		return this.tail.data;

	}

	public void addlast(int item) {
		Node temp = new Node(item, null);

		if (this.isEmpty()) {
			this.head = this.tail = temp;
		} else {
			this.tail.next = temp;
			this.tail = temp;
		}
		this.size++;
	}

	public int GetAt(int idx) throws Exception {
		Node node = this.getNodeAt(idx);
		return node.data;

	}

	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("list is empty");
		}
		if (idx < 0 || idx >= this.size()) {
			throw new Exception("index out of bound");
		}
		Node rv = this.head;
		int i = 0;
		while (i < idx) {
			rv = rv.next;
			i++;
		}
		return rv;

	}

	public void addAt(int item, int idx) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			this.AddFirst(item);
		}
		if (idx == this.size()) {
			this.addlast(item);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = nm1.next;
			Node node = new Node(item, np1);
			nm1.next = node;
			this.size++;
		}
	}

	public int removefirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("list is empty");
		}
		int rv = this.head.data;
		if (this.size() == 1) {
			this.head = this.tail = null;

		} else {
			this.head = this.head.next;
		}
		this.size--;
		return rv;

	}

	public int removelast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("list is empty");
		}
		int rv = this.tail.data;
		if (this.size() == 1) {
			this.head = this.tail = null;

		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			this.tail = sm2;
			this.tail.next = null;
		}
		this.size--;
		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("list is empty");
		}
		if (idx < 0 || idx >= this.size()) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			return this.removefirst();
		}
		if (idx == this.size() - 1) {
			return this.removelast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;
			nm1.next = np1;
			this.size--;
			return n.data;
		}
	}

	public void reverseDI() throws Exception {
		int left = 0;
		int right = this.size() - 1;
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		} else if (this.size() == 1) {
			return;

		}
		while (left < right) {
			Node n = getNodeAt(left);
			Node n1 = getNodeAt(right);

			int temp = n.data;
			n.data = n1.data;
			n1.data = temp;
			left++;
			right--;

		}

	}

	public void reversePI() throws Exception {
		Node prev = this.head;
		Node curr = null;
		Node temp = this.head.next;

		while (temp != null) {
			curr = temp;
			temp = curr.next;
			curr.next = prev;
			prev = curr;
		}
		Node swap = this.head;
		this.head = this.tail;
		this.tail = swap;

		this.tail.next = null;

	}

	public void reverseDIrec(int si, int ei) throws Exception {
		if (si > ei) {
			return;
		}

		reverseDIrec(si + 1, ei - 1);
		Node first = getNodeAt(si);
		Node last = getNodeAt(ei);

		int temp = first.data;
		first.data = last.data;
		last.data = temp;

	}

	public void DisplayReverse() {
		this.DisplayReverse(this.head);
		System.out.println("END");

	}

	private void DisplayReverse(Node node) {
		if (node == null) {
			return;
		}
		this.DisplayReverse(node.next);
		System.out.print(node.data + " =>");
	}

	public void reversePR() {
		this.reversePR(this.head, head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	private void reversePR(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		this.reversePR(prev.next, curr.next);

	}

	public void reverseDR_WORKING() {
		HeapMover left = new HeapMover();
		left.node = this.head;

		this.reverseDR_WORKING(left, this.head, 0);
	}

	private void reverseDR_WORKING(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		this.reverseDR_WORKING(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	private class HeapMover {
		Node node;
	}

	public void displayReverse() {
		this.displayReverse(this.head);
		System.out.println("END");
	}

	private void displayReverse(Node node) {
		if (node == null) {
			return;
		}
		this.displayReverse(node.next);
		System.out.print(node.data + " => ");
	}

	public void Kreverse(int k) throws Exception {
		linkedlist prev = new linkedlist();
		linkedlist curr = new linkedlist();
		if ((this.size()) % k != 0) {
			throw new Exception("not multiple of k");
		}
		while (!this.isEmpty()) {
			curr = new linkedlist();

			for (int i = 0; i < k; i++) {

				int val = this.removefirst();

				curr.AddFirst(val);

			}
			if (prev.head == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.tail.next = null;
				prev.size += curr.size;

			}

		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	public void IsPalindrome() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		System.out.println(this.palindrome(left, this.head, 0));

	}

	private boolean palindrome(HeapMover left, Node right, int floor) {
		if (right == null) {

			return true;
		}
		boolean ans = this.palindrome(left, right.next, floor + 1);
		if (ans) {
			if (floor >= this.size / 2) {
				if (left.node.data != right.data) {
					return false;
				} else {
					left.node = left.node.next;
					return true;
				}

			} else
				return ans;
		} else
			return ans;

	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;

		this.fold1(left, this.head, 0);
	}

	private void fold1(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		this.fold1(left, right.next, floor + 1);

		if (floor > this.size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;

			left.node = oln;
		}

		if (floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public int mid() {
		Node node = this.midnode();
		return node.data;

	}

	private Node midnode() {
		Node slow = this.head;
		Node fast = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;

	}

	public int kthfromLast(int k) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public linkedlist mergeSortedLists(linkedlist other) {
		linkedlist rv = new linkedlist();
		Node tnode = this.head;
		Node onode = other.head;
		while (tnode != null && onode != null) {
			if (tnode.data < onode.data) {
				rv.addlast(tnode.data);
				tnode = tnode.next;
			} else {
				rv.addlast(onode.data);
				onode = onode.next;
			}

		}
		while (tnode != null) {
			rv.addlast(tnode.data);
			tnode = tnode.next;

		}
		while (onode != null) {
			rv.addlast(onode.data);
			onode = onode.next;

		}
		return rv;

	}

	public linkedlist MergeSort() {
		if (this.size == 1) {
			linkedlist base = new linkedlist();
			base.addlast(this.head.data);
			return base;
		}

		Node midnode = this.midnode();
		Node midnodenext = midnode.next;

		linkedlist fhalf = new linkedlist();
		fhalf.head = this.head;
		fhalf.tail = midnode;
		fhalf.tail.next = null;
		fhalf.size = (this.size + 1) / 2;

		linkedlist shalf = new linkedlist();
		shalf.head = midnodenext;
		shalf.tail = this.tail;
		shalf.size = this.size / 2;
		
		fhalf = fhalf.MergeSort();
		shalf = shalf.MergeSort();

		linkedlist rv = fhalf.mergeSortedLists(shalf);
		midnode.next = midnodenext;

		return rv;
	}
}

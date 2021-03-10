package lecture24thApril;

import java.util.LinkedList;
import java.util.Scanner;

import lecture16thApril.GenericTree1;

// 29th april: did  add and remove function
public class BST {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BST(int[] SA) {
		this.root = this.construct(SA, 0, SA.length - 1);

	}

	private Node construct(int[] SA, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node rv = new Node(SA[mid], null, null);
		this.size++;
		rv.left = this.construct(SA, lo, mid - 1);
		rv.right = this.construct(SA, mid + 1, hi);

		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null && node.right != null) {
			System.out.println(node.left.data + " -> " + node.data + " <- " + node.right.data);
			display(node.left);
			display(node.right);
		} else if (node.left != null) {
			System.out.println(node.left.data + " -> " + node.data + " <- " + " END ");
			display(node.left);
		} else if (node.right != null) {
			System.out.println("END " + " -> " + node.data + " <- " + node.right.data);
			display(node.right);
		} else {
			System.out.println("END " + " -> " + node.data + " <- " + "END ");
		}

	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int rv = 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (node.left != null) {
			rv += this.size2(node.left);
		}
		if (node.right != null) {
			rv += this.size2(node.right);
		}
		rv = rv + 1;
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node.right != null) {
			return this.max(node.right);
		} else {

			return node.data;
		}
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		} else if (data > node.data) {
			return this.find(node.right, data);
		} else {
			return this.find(node.left, data);
		}

	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int rv = 0;
		int maxCht = -1;
		if (node == null) {
			return -1;
		}
		if (node.left != null) {

			int Cht = this.height(node.left);
			if (Cht > maxCht) {
				maxCht = Cht;
			}
		}

		if (node.right != null) {
			int Cht1 = this.height(node.right);
			if (Cht1 > maxCht) {
				maxCht = Cht1;
			}

		}
		rv = maxCht + 1;
		return rv;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		System.out.print(node.data + ", ");

		if (root == null) {
			return;
		}

		if (node.left != null) {
			this.preorder(node.left);
		}

		if (node.right != null) {
			this.preorder(node.right);
		}

	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");

	}

	private void postorder(Node node) {
		if (root == null) {
			return;
		}
		if (node.left != null) {
			this.postorder(node.left);
		}

		if (node.right != null) {
			this.postorder(node.right);
		}

		System.out.print(node.data + ", ");

	}

	public void inorder() {
		this.inorder(this.root);
		System.out.println("END");

	}

	private void inorder(Node node) {
		if (root == null) {
			return;
		}
		if (node.left != null) {
			this.inorder(node.left);
		}

		System.out.print(node.data + ", ");

		if (node.right != null) {
			this.inorder(node.right);
		}

	}

	public void preorderIterative() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);
		while (stack.size() != 0) {
			Node temp = stack.removeFirst();
			System.out.print(temp.data + " ,");

			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}

		}
		System.out.println("END");

	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ,");
			if (temp.left != null) {
				queue.addLast(temp.left);

			}
			if (temp.right != null) {
				queue.addLast(temp.right);

			}

		}
		System.out.println("END");
	}

	public void levelOrderline() {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();

		queue1.addLast(this.root);

		while (queue1.size() != 0 || queue2.size() != 0) {
			Node temp1 = queue1.removeFirst();
			System.out.println(temp1.data + " : ");
			if (temp1.left != null) {
				queue2.addLast(temp1.left);
			}
			if (temp1.right != null) {
				queue2.addLast(temp1.right);
			}
			Node temp2 = queue2.removeFirst();
			System.out.println(temp2.data + " : ");
		}

	}

	public void levelorederZigzag() {
		LinkedList<Node> currlevel = new LinkedList<>();
		LinkedList<Node> nextlevel = new LinkedList<>();

		currlevel.addLast(this.root);
		boolean ltor = true;

		while (!currlevel.isEmpty()) {
			Node temp = currlevel.removeFirst();
			System.out.print(temp.data + ", ");
			if (ltor == true) {
				if (temp.left != null) {
					nextlevel.addFirst(temp.left);
				}
				if (temp.right != null) {
					nextlevel.addFirst(temp.right);
				} else {
					if (temp.right != null) {
						nextlevel.addLast(temp.right);
					}
					if (temp.left != null) {
						nextlevel.addLast(temp.left);
					}

				}

				if (currlevel.isEmpty()) {
					System.out.println();
					currlevel = nextlevel;
					nextlevel = new LinkedList<>();
					ltor = !ltor;
				}

			}
		}

	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = this.height(node.left);
		int rh = this.height(node.right);
		int ld = this.diameter(node.left);
		int rd = this.diameter(node.right);

		int f1 = lh + rh + 2;
		int f2 = ld;
		int f3 = rd;

		int rv = Math.max(f1, Math.max(f2, f3));

		return rv;
	}

	private class Diapair {
		int height;
		int diameter;

	}

	public int diameter2() {
		Diapair dp = this.diameter2(this.root);
		return dp.diameter;
	}

	private Diapair diameter2(Node node) {
		if (node == null) {
			Diapair bp = new Diapair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}
		Diapair lp = this.diameter2(node.left);
		Diapair rp = this.diameter2(node.right);
		Diapair mp = new Diapair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		int f1 = lp.height + rp.height + 2;
		int f2 = lp.diameter;
		int f3 = rp.diameter;
		mp.diameter = Math.max(f1, Math.max(f2, f3));

		return mp;

	}

	private class balanced {
		int height;

		boolean isbalanced;
	}

	public boolean Isbalanced() {
		balanced bp = this.Isbalanced(this.root);
		return bp.isbalanced;
	}

	private balanced Isbalanced(Node node) {
		if (node == null) {
			balanced bp = new balanced();
			bp.height = -1;
			bp.isbalanced = true;
			return bp;
		}
		balanced lp = this.Isbalanced(node.left);
		balanced rp = this.Isbalanced(node.right);
		balanced mp = new balanced();

		mp.height = Math.max(lp.height, rp.height) + 1;

		if (Math.abs(lp.height - rp.height) <= 1 && lp.isbalanced == true && rp.isbalanced == true) {
			mp.isbalanced = true;
		} else {
			mp.isbalanced = false;
		}

		return mp;

	}

	private class balanced1 {
		int min;
		int max;
		boolean isbst;
	}

	public boolean IsBST() {
		balanced1 bp = this.IsBST(this.root);
		return bp.isbst;
	}

	private balanced1 IsBST(Node node) {
		if (node == null) {
			balanced1 bp = new balanced1();
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.isbst = true;
			return bp;
		}
		balanced1 lp = this.IsBST(node.left);
		balanced1 rp = this.IsBST(node.right);
		balanced1 mp = new balanced1();

		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

		if (lp.isbst == true && rp.isbst == true && node.data > lp.max && node.data < rp.min) {
			mp.isbst = true;
		} else {
			mp.isbst = false;
		}

		return mp;

	}

	public boolean IsBST2() {
		return this.IsBST2(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean IsBST2(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}

		boolean f1 = this.IsBST2(node.left, min, max);
		boolean f2 = this.IsBST2(node.right, min, max);

		return f1 || f2;

	}

	private class Composite {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int height = 0;
		boolean found = false;
		Node JustLarger = null;
		Node Pred = null;
		Node Success = null;
		int sum = 0;

		@Override
		public String toString() {
			String rv = "";
			rv += "Size: " + this.size + "\n";
			rv += "Max: " + this.max + "\n";
			rv += "Height: " + this.height + "\n";
			rv += "Min: " + this.min + "\n";
			rv += "Found: " + this.found + "\n";

			if (this.JustLarger == null) {
				rv += "Just Larger" + "null" + "\n";
			} else {
				rv += "Just Larger" + this.JustLarger.data + "\n";
			}

			if (this.Pred == null || this.found == false) {
				rv += "Predecessor " + " null" + "\n";
			} else {
				rv += "Predecessor " + this.Pred.data + "\n";
			}

			if (this.Success == null || this.found == false) {
				rv += "Successor" + " null" + "\n";
			} else {
				rv += "Successor " + this.Success.data + "\n";
			}

			return rv;

		}

	}

	public void multiSolver(int data) {
		Composite com = new Composite();
		this.multiSolver(com, this.root, 0, data);
		System.out.println(com);
	}

	private void multiSolver(Composite com, Node node, int depth, int data) {
		com.size++;
		if (node.data > com.max) {
			com.max = node.data;
		}
		if (node.data < com.min) {
			com.min = node.data;
		}
		if (depth > com.height) {
			com.height = depth;
		}

		if (node.data > data) {
			if (com.JustLarger == null) {
				com.JustLarger = node;
			} else {
				if (node.data < com.JustLarger.data) {
					com.JustLarger = node;
				}

			}
		}
		if (com.found) {
			if (com.Success == null) {
				com.Success = node;
			}
		}

		if (data == node.data) {
			com.found = true;
		}

		if (com.found == false) {
			com.Pred = node;
		}

		if (node.left != null) {
			this.multiSolver(com, node.left, depth + 1, data);
		}

		if (node.right != null) {
			this.multiSolver(com, node.right, depth + 1, data);
		}
	}

	public void add(int data) {
		if (this.size == 0) {
			this.root = new Node(data, null, null);
			this.size = 1;
		} else {
			this.add(this.root, data);
		}

	}

	private void add(Node node, int data) {
		if (data > node.data) {
			if (node.right != null) {
				this.add(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}

		} else if (data < node.data) {
			if (node.left != null) {
				this.add(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}
		} else {
			// already exists

		}
	}

	public void remove(int data) {
		if (this.size == 1) {
			this.root = null;
			this.size--;
		} else {
			this.remove(this.root, null, false, data);
		}

	}

	private void remove(Node node, Node parent, boolean ilc, int data) {
		if (data > node.data) {
			if (node.right != null) {
				this.remove(node.right, node, false, data);
			}
		} else if (data < node.data) {
			if (node.left != null) {
				this.remove(node.left, node, true, data);
			}
		} else {

			if (node.left != null && node.right != null) {
				int lmax = this.max(node.left);
				node.data = lmax;
				this.remove(node.left, node, true, lmax);

			} else {
				Node n2a = null;
				if (node.left != null) {
					n2a = node.left;
				} else {
					n2a = node.right;
				}

				if (ilc) {
					parent.left = n2a;

				} else {
					parent.right = n2a;
				}
				this.size--;
			}
		}
	}

	public void PrintInRange(int sn, int ln) {
		this.PrintInRange(this.root, sn, ln);

	}

	private void PrintInRange(Node node, int sn, int ln) {
		if (node == null) {
			return;
		}
		if (node.data < sn) {
			this.PrintInRange(node.right, sn, ln);
		}

		if (node.data < sn && node.data > ln) {
			System.out.println(node.data);
			this.PrintInRange(node.right, sn, ln);
			this.PrintInRange(node.left, sn, ln);

		}
		if (ln < node.data) {

			this.PrintInRange(node.left, sn, ln);
		}

	}

	public void replacebySum() {
		Composite c = new Composite();
		this.replacebySum(this.root, c);

	}

	private void replacebySum(Node node, Composite c) {

		if (node == null) {
			return;
		}

		this.replacebySum(node.right, c);
		int temp = node.data;
		node.data = c.sum;
		c.sum += temp;

		this.replacebySum(node.left, c);

	}
}
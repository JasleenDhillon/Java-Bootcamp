package lecture22ndApril;

import java.util.LinkedList;
import java.util.Scanner;

import lecture16thApril.GenericTree1;

public class BinaryTree {
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

	public BinaryTree() {
		this.root = this.takeInput(new Scanner(System.in), null, false);
	}

	public Node takeInput(Scanner scn, Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter data for parent:");
		} else {
			if (ilc) {
				System.out.println("Enter data for left child of " + parent.data);
			} else {
				System.out.println("Enter data for right child of " + parent.data);
			}
		}
		int cdata = scn.nextInt();
		Node rv = new Node(cdata, null, null);
		this.size++;
		System.out.println("is Left child present for" + rv.data);
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			rv.left = this.takeInput(scn, rv, true);
		}

		System.out.println("is Left child present for" + rv.data);
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			rv.right = this.takeInput(scn, rv, false);
		}

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
		int rv = node.data;
		if (node.left != null) {
			int cmax = this.max(node.left);
			if (cmax > rv) {
				rv = cmax;
			}
		}

		if (node.right != null) {
			int cmax1 = this.max(node.right);
			if (cmax1 > rv) {
				rv = cmax1;
			}
		}
		return rv;
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
		}
		if (node.left != null) {
			if (this.find(node.left, data) == true) {
				return true;
			}
		}

		if (node.right != null) {
			if (this.find(node.right, data) == true) {
				return true;
			}
		}

		return false;
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

	/*
	 * public BinaryTree(int[] pre, int[] in) { this.root = this.construct(pre,
	 * 0, pre.length - 1, in, 0, in.length - 1); }
	 * 
	 * private Node construct(int[] pre, int psi, int pei, int[] in, int isi,
	 * int iei) {
	 * 
	 * if (isi > iei) { return null; } Node node = new Node(pre[psi], null,
	 * null);
	 * 
	 * this.size++; int si = 0;
	 * 
	 * for (int i = isi; i <= iei; i++) { if (pre[psi] == in[i]) { si = i;
	 * break;
	 * 
	 * } } int count = si - isi; Node left = this.construct(pre, psi + 1, psi +
	 * count, in, isi, si - 1); Node right = this.construct(pre, psi + count +
	 * 1, pei, in, si + 1, iei);
	 * 
	 * node.left = left; node.right = right;
	 * 
	 * return node;
	 * 
	 * }
	 */

	/*
	 * public BinaryTree(int[] post, int[] in) { this.root =
	 * this.construct(post, 0, post.length - 1, in, 0, in.length - 1); }
	 * 
	 * private Node construct(int[] post, int psi, int pei, int[] in, int isi,
	 * int iei) {
	 * 
	 * if (isi > iei) { return null; } Node node = new Node(post[pei], null,
	 * null); this.size++;
	 * 
	 * int si = 0;
	 * 
	 * for (int i = isi; i <= iei; i++) { if (post[pei] == in[i]) { si = i;
	 * break;
	 * 
	 * } } int count = si - isi; Node left = this.construct(post, psi, psi +
	 * count - 1, in, isi, si - 1); Node right = this.construct(post, psi +
	 * count, pei - 1, in, si + 1, iei);
	 * 
	 * node.left = left; node.right = right;
	 * 
	 * return node;
	 * 
	 * }
	 */

	public BinaryTree(int[] pre, int[] post) {
		this.root = this.construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	private Node construct(int[] pre, int psi, int pei, int[] post, int posi, int poei) {

		Node node = new Node(pre[psi], null, null);
		this.size++;
		int si = 0;
		for (int i = posi; i <= poei; i++) {
			if (pre[posi + 1] == post[i]) {
				si = i;
				break;
			}

		}
		int count = si - posi;
		node.left = this.construct(pre, 0, 0, post, 0, 0);
		node.right = this.construct(pre, 0, 0, post, 0, 0);

		return node;

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

}
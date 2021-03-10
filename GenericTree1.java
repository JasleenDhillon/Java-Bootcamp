package lecture16thApril;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import lecture13thApril.Stack1;

public class GenericTree1 {
	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	public GenericTree1() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, 0);

	}

	private Node takeInput(Scanner scn, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter data for root:");
		} else {
			System.out.println("Enter data for " + ithchild + " th child of parent ");
		}
		int childData = scn.nextInt();
		Node child = new Node(childData);
		this.size++;
		System.out.println("Enter no of children for " + child.data);
		int numGC = scn.nextInt();
		for (int i = 0; i < numGC; i++) {
			Node grandchild = this.takeInput(scn, child, i);
			child.children.add(grandchild);
		}
		return child;

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
		String str = node.data + " => ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += "END";
		System.out.println(str);
		for (Node child : node.children) {
			this.display(child);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int rv = 0;
		for (Node child : node.children) {
			rv += this.size2(child);
		}
		rv = rv + 1;
		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int rv = node.data;
		for (Node child : node.children) {
			int cmax = this.max(child);
			if (cmax > rv) {
				rv = cmax;
			}
		}
		return rv;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int rv = 0;
		int maxCht = -1;
		for (Node child : node.children) {

			int Cht = this.height(child);
			if (Cht > maxCht) {
				maxCht = Cht;
			}
		}
		rv = maxCht + 1;
		return rv;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			if (this.find(child, data) == true) {
				return true;
			}
		}
		return false;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		System.out.print(node.data + ", ");
		for (Node child : node.children) {
			this.preorder(child);
		}
	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");

	}

	private void postorder(Node node) {
		for (Node child : node.children) {
			this.postorder(child);
		}

		System.out.print(node.data + ", ");

	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (queue.size() != 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ,");
			for (Node child : temp.children) {
				queue.addLast(child);

			}
		}
		System.out.println("END");
	}

	public void preorderIterative() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(this.root);
		while (stack.size() != 0) {
			Node temp = stack.removeFirst();
			System.out.print(temp.data + " ,");
			for (int i = temp.children.size() - 1; i >= 0; i--) {
				Node child = temp.children.get(i);
				stack.addFirst(child);

			}
		}
		System.out.println("END");
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
					com.JustLarger = null;
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

		for (Node child : node.children) {
			this.multiSolver(com, child, depth + 1, data);
		}
	}

	public void levelOrderline() {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();

		queue1.addLast(this.root);

		while (queue1.size() != 0 || queue2.size() != 0) {
			Node temp1 = queue1.removeFirst();
			System.out.println(temp1.data + " : ");
			for (Node child : temp1.children) {
				queue2.addLast(child);

				Node temp2 = queue2.removeFirst();
				System.out.println(temp2.data + " : ");
			}

		}

	}

	public void linearize() {
		this.linearize(this.root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}
		while (node.children.size() > 1) {
			Node childRemove = node.children.remove(1);
			Node NewTail = gettail(node.children.get(0));
			NewTail.children.add(childRemove);
		}
	}

	private Node gettail(Node node) {
		Node rv = node;
		while (rv.children.size() != 0) {
			rv = rv.children.get(0);
		}
		return rv;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			this.mirror(child);
		}

		int li = 0;
		int ri = node.children.size() - 1;

		while (li < ri) {
			Node left = node.children.get(li);
			Node right = node.children.get(ri);
			node.children.set(li, right);
			node.children.set(ri, left);
			li++;
			ri--;
		}
	}

	public boolean IsIsomorphic(GenericTree1 other) {
		return this.IsIsomorphic(this.root, other.root);
	}

	private boolean IsIsomorphic(Node thisnode, Node othernode) {
		if (thisnode.children.size() != othernode.children.size()) {
			return false;

		}
		if (thisnode.children.size() == othernode.children.size()) {
			for (int i = 0; i < thisnode.children.size(); i++) {
				Node thischild = thisnode.children.get(i);
				Node otherchild = othernode.children.get(i);
				if (IsIsomorphic(thischild, otherchild) == false) {
					return false;
				}
			}
		}
		return true;

	}

	public int countLeafnodes() {
		return this.countLeafnodes(this.root);
	}

	private int countLeafnodes(Node node) {
		int rv = 0;
		if (node.children.size() == 0) {
			return 1;
		}

		for (Node child : node.children) {
			rv += countLeafnodes(child);
		}
		return rv;

	}

	public void printAtlevel(int level) {
		this.printAtlevel(this.root, 0, level);
	}

	private void printAtlevel(Node node, int cl, int destl) {
		if (cl == destl) {
			System.out.println(node.data);
			return;
		}
		for (Node child : node.children) {

			printAtlevel(child, cl + 1, destl);
		}
	}

	public void levelorderLW() {
		LinkedList<Node> currlevel = new LinkedList<>();
		LinkedList<Node> nextlevel = new LinkedList<>();

		currlevel.addLast(this.root);

		while (!currlevel.isEmpty()) {
			Node temp = currlevel.removeFirst();
			System.out.print(temp.data + ", ");

			for (Node child : temp.children) {
				nextlevel.addLast(child);
			}

			if (currlevel.isEmpty()) {
				System.out.println();
				currlevel = nextlevel;
				nextlevel = new LinkedList<>();
			}
		}
	}

	public void levelorderZigZag() {
		LinkedList<Node> currlevel = new LinkedList<>();
		LinkedList<Node> nextlevel = new LinkedList<>();

		currlevel.addLast(this.root);
		boolean ltor = true;

		while (!currlevel.isEmpty()) {
			Node temp = currlevel.removeFirst();
			System.out.print(temp.data + ", ");
			if (ltor == true) {
				for (int i = 0; i < temp.children.size(); i++) {
					Node child = temp.children.get(i);
					nextlevel.addFirst(child);
				}
			} else {
				for (int i = temp.children.size() - 1; i >= 0; i--) {
					Node child = temp.children.get(i);
					nextlevel.addFirst(child);
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

	public int LevelMax(int level) {
		return this.LevelMax(this.root, 0, level);

	}

	private int LevelMax(Node node, int cl, int destl) {
		if (cl == destl) {

			return node.data;
		}
		for (Node child : node.children) {

			printAtlevel(child, cl + 1, destl);
		}
		return 0;

	}

	public void linearize2() {
		this.linearize2(this.root);
	}

	private Node linearize2(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		Node tail = this.linearize2(node.children.get(0));

		while (node.children.size() > 1) {
			Node remove = node.children.remove(1);
			Node removeTail = this.linearize2(remove);

			tail.children.add(remove);

			tail = removeTail;

		}
		return tail;
	}

}

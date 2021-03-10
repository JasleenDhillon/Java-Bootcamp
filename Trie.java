package lecture26thApril;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Trie {

	private class Node {
		Character data;
		boolean Iseow;
		HashMap<Character, Node> children = new HashMap<>();

		Node(Character data, boolean Iseow) {
			this.data = data;
			this.Iseow = false;
			this.children = new HashMap<>();
		}

	}

	Node root;
	int size;
	int WordCount;

	Trie() {
		this.root = new Node('\0', false);
		this.size = 1;
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

	public void AddWord(String word) {
		this.AddWord(this.root, word);
	}

	private void AddWord(Node node, String word) {
		if (word.length() == 0) {
			node.Iseow = true;
			this.WordCount++;
			return;
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			this.size++;
			node.children.put(ch, child);
		}
		this.AddWord(child, ros);
	}

	public boolean SearchWord(String word) {
		return this.SearchWord(this.root, word);
	}

	private boolean SearchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.Iseow;
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {

			return false;
		}
		return this.SearchWord(child, ros);
	}

	public void RemoveWord(String word) {
		this.RemoveWord(this.root, word);
	}

	private void RemoveWord(Node node, String word) {
		if (word.length() == 0) {
			node.Iseow = false;
			this.WordCount--;
			return;
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = node.children.get(ch);

		if (child == null) {

			return;
		}

		this.RemoveWord(child, ros);
		if (child.Iseow == false || child.children.size() == 0) {
			node.children.remove(ch);
			this.size--;
		}

	}

	public void displayWords() {
		this.displayWords(this.root, "");

	}

	private void displayWords(Node node, String osf) {
		if (node.Iseow) {
			System.out.println(osf);
		}

		Set<Character> chars = node.children.keySet();

		for (Character ch : chars) {
			Node child = node.children.get(ch);
			this.displayWords(child, osf + ch);

		}

	}

	public void displayTree() {
		this.displayTree(this.root);
	}

	private void displayTree(Node node) {
		String str = node.data + " => ";
		Set<Character> chars = node.children.keySet();

		for (Character ch : chars) {
			Node child = node.children.get(ch);

			str += child.data + ", ";
		}
		str += "END";
		System.out.println(str);

	}

	public static ArrayList<Integer> KLargest(Integer[] arr, Integer k) {
		PriorityQueue<Integer> pqueue1 = new PriorityQueue<>();

		ArrayList<Integer> rv = new ArrayList<>();

		for (int i = 0; i < k; i++) {

			pqueue1.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			Integer current = arr[i];
			Integer SmallestInQueue = pqueue1.peek();

			if (current > SmallestInQueue) {
				pqueue1.remove();
				pqueue1.add(current);
			}

		}

		while (!pqueue1.isEmpty()) {
			rv.add(pqueue1.remove());
		}
		return rv;

	}

	public static ArrayList<Integer> KSmallest(Integer[] arr, Integer k) {
		PriorityQueue<Integer> pqueue1 = new PriorityQueue<>();

		ArrayList<Integer> rv = new ArrayList<>();

		for (int i = 0; i < k; i++) {

			pqueue1.add((-1) * arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			Integer current = (-1) * arr[i];
			Integer SmallestInQueue = pqueue1.peek();

			if (current > SmallestInQueue) {
				pqueue1.remove();
				pqueue1.add(current);
			}

		}

		while (!pqueue1.isEmpty()) {
			rv.add((-1) * pqueue1.remove());
		}
		return rv;

	}

}
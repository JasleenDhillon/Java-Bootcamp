package lecture26thApril;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TrieClient {

	public static void main(String[] args) {
		Integer[] arr = { 15, 37, 1, 19, 63, 82, 18, 20, 25, 45 };

		Trie t = new Trie();
		t.AddWord("arts");
		t.AddWord("art");
		t.AddWord("act");
		t.AddWord("are");
		t.AddWord("and");
		t.AddWord("buy");
		t.AddWord("bug");
		t.AddWord("bee");

		System.out.println(t.SearchWord("buy"));

		// t.RemoveWord("bee");

		System.out.println(t.SearchWord("bee"));

		t.displayWords();
		t.displayTree();

		System.out.println(t.KLargest(arr, 3));

		System.out.println(t.KSmallest(arr, 3));

		ArrayList<Integer> list0 = new ArrayList<>(Arrays.asList(1, 5, 8, 12));
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(-3, 9, 11, 17));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 16, 20, 25));
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(-5, 0, 4, 10));

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>(Arrays.asList(list0, list1, list2, list3));

		System.out.println(mergeKSortedLists(lists));

	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int itemNo;

		@Override
		public int compareTo(Pair o) {
			return this.data - o.data;
		}

	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.listNo = i;
			p.itemNo = 0;
			p.data = lists.get(p.listNo).get(p.itemNo);
			pq.add(p);
		}
		while (!pq.isEmpty()) {
			Pair rp = pq.remove();
			rv.add(rp.data);

			if (rp.itemNo == lists.get(rp.listNo).size() - 1) {

			} else {
				rp.itemNo++;
				rp.data = lists.get(rp.listNo).get(rp.itemNo);
				pq.add(rp);
			}
		}

		return rv;

	}

}

package lecture24thApril;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapping {

	public static void main(String[] args) {
		System.out.println(getHighestFrequency("abracadabra"));
		Integer[] one = { 1, 1, 2, 2, 2, 3, 5 };
		Integer[] two = { 1, 1, 1, 2, 2, 4, 5 };
		System.out.println(GCE1(one, two));
		System.out.println(GCE2(one, two));

		Integer[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		System.out.println(longestconsequetiveseq(arr));

	}

	public static Character getHighestFrequency(String word) {
		HashMap<Character, Integer> freqmap = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			if (freqmap.containsKey(ch)) {
				int ov = freqmap.get(ch);
				int nv = ov + 1;
				freqmap.put(ch, nv);
			} else {
				freqmap.put(ch, 1);

			}
		}

		Integer maxf = Integer.MIN_VALUE;
		Character maxfchar = '\0';
		for (Character key : freqmap.keySet()) {
			if (freqmap.get(key) > maxf) {
				maxf = freqmap.get(key);
				maxfchar = key;
			}
		}
		return maxfchar;
	}

	public static ArrayList<Integer> GCE1(Integer[] one, Integer[] two) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer> rv = new ArrayList<>();

		for (Integer i : one) {
			map.put(i, false);
		}
		for (Integer j : two) {
			if (map.containsKey(j) && !map.get(j)) {
				rv.add(j);
				map.put(j, true);
			}
		}

		return rv;
	}

	public static ArrayList<Integer> GCE2(Integer[] one, Integer[] two) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();

		ArrayList<Integer> rv = new ArrayList<>();
		for (Integer N : one) {
			if (map1.containsKey(N)) {
				int ov = map1.get(N);
				int nv = ov + 1;
				map1.put(N, nv);
			} else {
				map1.put(N, 1);
			}
		}

		for (Integer N : two) {
			if (map2.containsKey(N)) {
				int ov = map2.get(N);
				int nv = ov + 1;
				map2.put(N, nv);
			} else {
				map2.put(N, 1);
			}
		}

		for (Integer n : map1.keySet()) {
			if (map2.containsKey(n)) {
				for (int i = 0; i < Integer.min(map1.get(n), map2.get(n)); i++) {
					rv.add(n);
				}
			}
		}

		return rv;
	}

	public static ArrayList<Integer> longestconsequetiveseq(Integer[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer> rv = new ArrayList<>();

		for (Integer val : arr) {
			int valm1 = val - 1;
			int valp1 = val + 1;
			if (map.containsKey(valm1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(valp1)) {
				map.put(valp1, false);
			}
		}

		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());

		for (int key : keys) {
			if (map.get(key) == true) {
				int counter = 0;
				ArrayList<Integer> currseq = new ArrayList<>();
				while (map.containsKey(counter + key)) {
					currseq.add(key + counter);
					counter++;
				}
				if (currseq.size() > rv.size()) {
					rv = currseq;
				}
			}
		}
		return rv;

	}
}
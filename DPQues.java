package lecture26thApril;

import java.util.Arrays;
import java.util.HashMap;

public class DPQues {

	public static void main(String[] args) {

		System.out.println(PatternMatching1("abcdef", "de"));
		int[] arr = { 1, 5, 5, 10, 10 };
		
		
		System.out.println(Equalize(arr));

		System.out.println();
	}

	public static int PatternMatching(String s1, String s2) {
		while (s1.length() > s2.length()) {
			for (int i = 0; i < s1.length() && (i + s2.length()) <= s1.length(); i++) {
				if (s1.substring(i, i + s2.length()).equals(s2)) { // iski
																	// O(s1.length)
																	// complexity
																	// hoti h
					return i;
				}
			}

			for (int i = 0; i < s2.length(); i++) {
				if (s1.substring(i, i + s1.length()).equals(s1)) {
					return i;
				}
			}
		}
		return -1;
	}

	public static int Equalize(int[] arr) {

		Arrays.sort(arr);
		int min = arr[0];
		HashMap<Integer, Integer> fMap = new HashMap<>();

		fMap.put(0, 0);
		fMap.put(1, 0);
		fMap.put(2, 0);
		fMap.put(3, 0);
		fMap.put(4, 0);

		int ops = 0;

		for (int i = 0; i < arr.length; i++) {

			int delta = arr[i] - min;
			int numops = delta / 5;
			int finalspot = delta % 5;

			ops += numops;

			int ov = fMap.get(finalspot);
			int nv = ov + 1;
			fMap.put(finalspot, nv);
		}

		int fn = fMap.get(0) * 0 + fMap.get(1) * 1 + fMap.get(2) * 1 + fMap.get(3) * 2 + fMap.get(4) * 2;
		int fnm1 = fMap.get(0) * 1 + fMap.get(1) * 1 + fMap.get(2) * 2 + fMap.get(3) * 2 + fMap.get(4) * 1;
		int fnm2 = fMap.get(0) * 1 + fMap.get(1) * 2 + fMap.get(2) * 2 + fMap.get(3) * 1 + fMap.get(4) * 2;

		ops = ops + Math.min(fn, Math.min(fnm1, fnm2));
		return ops;
	}

	public static int PatternMatching1(String s1, String s2) {
		while (s1.length() > s2.length()) {
			for (int i = 0; i < s1.length() && (i + s2.length()) <= s1.length(); i++) {
				for (int j = 0; j < s2.length(); j++) {
					if (s1.charAt(i + j) == s2.charAt(j)) {
						return i;
					}
				}
			}

		}
		return -1;

	}

}

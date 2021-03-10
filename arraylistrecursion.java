package recursion;

import java.util.ArrayList;

public class arraylistrecursion {

	public static void main(String[] args) {
		System.out.println(getSS("abbab"));

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");
			return base;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rec = getSS(ros);
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 0; i < rec.size(); i++) {
			myrec.add("" + rec.get(i));
			myrec.add(ch + rec.get(i));

		}
		return myrec;
	}

	public static ArrayList<String> getSSASCI(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");
			return base;
		}

		char ch = str.charAt(0);
		int n = ch;
		String ros = str.substring(1);

		ArrayList<String> rec = getSSASCI(ros);
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 0; i < rec.size(); i++) {
			myrec.add("" + rec.get(i));
			myrec.add(n + rec.get(i));
			myrec.add(ch + rec.get(i));

		}
		return myrec;
	}

	public static String[] kpc = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPWords(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");
			return base;
		}

		char ch = str.charAt(0);
		int cha = (int) ch - 48;

		String ros = str.substring(1);

		ArrayList<String> rec = getKPWords(ros);
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 0; i < rec.size(); i++) {
			String s = kpc[cha];
			for (int j = 0; j < s.length(); j++) {
				myrec.add(s.charAt(j) + rec.get(i));
			}

		}
		return myrec;

	}

	public static ArrayList<String> getBP(int c, int e) {
		if (c == e) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");

			return base;
		}
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 1; i <= 6 && i + c <= e; i++) {
			ArrayList<String> rec = getBP(c + i, e);

			for (int j = 0; j < rec.size(); j++) {
				myrec.add(i + rec.get(j));
			}
		}
		return myrec;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");
			return base;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rec = getPermutations(ros);
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 0; i < rec.size(); i++) {
			String s1 = rec.get(i);
			for (int j = 0; j <= s1.length(); j++) {
				myrec.add(s1.substring(0, j) + ch + s1.substring(j));
			}

		}

		return myrec;
	}

	public static ArrayList<String> permutationDuplicacy(String str) {  //do it again
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();

			base.add(" ");
			return base;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rec = permutationDuplicacy(ros);
		ArrayList<String> myrec = new ArrayList<>();

		for (int i = 0; i < rec.size(); i++) {
			String s1 = rec.get(i);
			for (int j = 0; j <= s1.length(); j++) {
				myrec.add(s1.substring(0, j) + ch + s1.substring(j));

			}
		}
		for (int i = 0; i < myrec.size(); i++) {
			for (int j = i + 1; j < (myrec.size()) + 1; j++) {
				String a = myrec.get(i);
				String b = myrec.get(j);
				if(a.equals(b)){
					myrec.remove(j);
				}
			}
		}
		return myrec;

	}

}

package lec9;

import java.util.ArrayList;

import java.util.Scanner;

public class ArrayLists {
	public static void main(String args[]) {
		ArrayList<String> list;
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		list = getSS(str);
		System.out.println(list);

	}

	public static ArrayList<String> getSS(String str) {
		ArrayList<String> list1;
		list1 = new ArrayList<>();
		int d = (int) Math.pow(2, str.length());
		int c = 0;
		while (c < d) {
			int e = c;
			String ss = "";
			for (int i = 0; i < str.length(); i++) {
				int rem = e % 2;
				if (rem == 1) {
					ss = ss + str.charAt(i);
				}
				e = e / 2;
			}

			c++;
			list1.add(ss);

		}

		return list1;
	}
}

package lec10;

import java.util.ArrayList;
import java.util.Scanner;

public class Rec {
	public static String[] kypc = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void main(String args[]) {
		// ArrayList<String> list = new ArrayList<>();
		// list = getSS("acd");
		// System.out.println(list);
		// printSSAscii("ab","");
		// printMazePathsmultidig(0,0,2,2,"");
		// System.out.println(getMazePathsdiag(0, 0, 2, 2));
		// printChessPathExtra(0, 0, 4, 4, "");
		// System.out.println(getChessPaths(0, 0, 2, 2));
		// Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// boolean[][] board = new boolean[4][4];
		// System.out.println(getNQueens(board, 0));
		// int[] wts={20,10,30,45,2,12,15};
		// int[] vals={20,20,30,50,12,15,10};
		// int capacity=100;
		// System.out.println(KS(wts,vals,capacity,0,0));

		int n = 1123;
		allstring(n,4,"");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> rs = new ArrayList<>();
			rs.add("");
			return rs;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mylist = getSS(ros);
		ArrayList<String> rslist = new ArrayList<>();

		for (int i = 0; i < mylist.size(); i++) {
			rslist.add("" + mylist.get(i));
			rslist.add(ch + mylist.get(i));

		}
		return rslist;

	}

	public static ArrayList<String> getSSAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> rs = new ArrayList<>();
			rs.add("");
			return rs;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mylist = getSSAscii(ros);
		ArrayList<String> rslist = new ArrayList<>();

		for (int i = 0; i < mylist.size(); i++) {
			rslist.add("" + mylist.get(i));
			rslist.add(ch + mylist.get(i));
			rslist.add(mylist.get(i) + (int) ch);

		}
		return rslist;
	}

	public static ArrayList<String> getKmsg(String str) {
		if (str.length() == 0) {
			ArrayList<String> rs = new ArrayList<>();
			rs.add("");
			return rs;
		}
		char ch = str.charAt(0);
		int av = ch - 48;
		String ros = str.substring(1);
		ArrayList<String> mylist = getKmsg(ros);
		ArrayList<String> rslist = new ArrayList<>();

		for (int i = 0; i < mylist.size(); i++) {
			String a = kypc[av];
			for (int j = 0; j < a.length(); j++) {

				rslist.add(a.charAt(j) + mylist.get(i));
			}
		}
		return rslist;
	}

	public static ArrayList<String> getpath(int si, int di) {
		if (si == di) {
			ArrayList<String> rs = new ArrayList<>();
			rs.add("\n");
			return rs;

		}
		ArrayList<String> rest = new ArrayList<>();
		ArrayList<String> myresult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			if (si + dice <= di) {
				rest = getpath(dice + si, di);

				for (int j = 0; j < rest.size(); j++) {
					myresult.add(dice + (rest.get(j)));

				}
			}
		}
		return myresult;

	}

	public static ArrayList<String> per(String str) {

		if (str.length() == 0) {
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mylist = per(ros);
		ArrayList<String> rlist = new ArrayList<>();

		for (int k = 0; k < mylist.size(); k++) {
			String a = mylist.get(k);
			for (int i = 0; i <= a.length(); i++) {

				rlist.add(a.substring(0, i) + ch + a.substring(i));
			}
		}
		return rlist;

	}

	public static void printSS(String quest, String soln) {
		if (quest.length() == 0) {
			System.out.println(soln);
			return;
		}
		char ch = quest.charAt(0);
		String ros = quest.substring(1);

		printSS(ros, soln + "");
		printSS(ros, soln + ch);
	}

	public static void printSSAscii(String quest, String soln) {
		if (quest.length() == 0) {
			System.out.println(soln);
			return;
		}
		char ch = quest.charAt(0);
		String ros = quest.substring(1);

		printSSAscii(ros, soln + "");
		printSSAscii(ros, soln + ch);
		printSSAscii(ros, soln + (int) ch);
	}

	public static void printpath(int si, int di, String soln) {
		if (si == di) {
			System.out.println(soln);
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			if (si + dice <= di) {
				printpath(si + dice, di, soln + dice);
			}

		}
	}

	public static void printMazePaths(int cc, int cr, int ec, int er, String path) {
		if (cc == ec && cr == er) {
			System.out.println(path);
			return;
		}

		if (cc < ec)
			printMazePaths(cc + 1, cr, ec, er, path + "H");
		if (cr < er)
			printMazePaths(cc, cr + 1, ec, er, path + "V");

	}

	public static void printMazePathsdig(int cc, int cr, int ec, int er, String path) {
		if (cc == ec && cr == er) {
			System.out.println(path);
			return;
		}
		if (cc < ec && cr < er)
			printMazePathsmultidig(cc + 1, cr + 1, ec, er, path + "D");
		if (cc < ec)
			printMazePathsdig(cc + 1, cr, ec, er, path + "H");
		if (cr < er)
			printMazePathsdig(cc, cr + 1, ec, er, path + "V");

	}

	public static void printMazePathsmultidig(int cc, int cr, int ec, int er, String path) {
		if (cc == ec && cr == er) {
			System.out.println(path);
			return;
		}
		if (cc < ec && cr < er)
			for (int i = 1; i <= er && i <= ec; i++)
				printMazePathsmultidig(cc + i, cr + i, ec, er, path + "D" + i);
		if (cc < ec)
			printMazePathsmultidig(cc + 1, cr, ec, er, path + "H");
		if (cr < er)
			printMazePathsmultidig(cc, cr + 1, ec, er, path + "V");

	}

	public static ArrayList<String> getMazePaths(int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;
		}
		ArrayList<String> Hrec = null;
		ArrayList<String> Vrec = null;
		ArrayList<String> myresult = new ArrayList<>();
		if (cc < ec) {
			Hrec = getMazePaths(cc + 1, cr, ec, er);
			for (int i = 0; i < Hrec.size(); i++) {
				myresult.add("H" + Hrec.get(i));
			}
		}
		if (cr < er) {
			Vrec = getMazePaths(cc, cr + 1, ec, er);
			for (int i = 0; i < Vrec.size(); i++) {
				myresult.add("V" + Vrec.get(i));
			}
		}
		return myresult;
	}

	public static ArrayList<String> getMazePathsdiag(int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;
		}
		ArrayList<String> Hrec = null;
		ArrayList<String> Vrec = null;
		ArrayList<String> Drec = null;
		ArrayList<String> myresult = new ArrayList<>();
		if (cc < ec) {
			Hrec = getMazePathsdiag(cc + 1, cr, ec, er);
			for (int i = 0; i < Hrec.size(); i++) {
				myresult.add("H" + Hrec.get(i));
			}
		}
		if (cr < er) {
			Vrec = getMazePathsdiag(cc, cr + 1, ec, er);
			for (int i = 0; i < Vrec.size(); i++) {
				myresult.add("V" + Vrec.get(i));
			}
		}
		if (cr < er && cc < ec) {
			Drec = getMazePathsdiag(cc + 1, cr + 1, ec, er);
			for (int i = 0; i < Drec.size(); i++) {
				myresult.add("D" + Drec.get(i));
			}
		}
		return myresult;
	}

	public static void printChessPaths(int cc, int cr, int ec, int er, String path) {
		if (cc == ec && cr == er) {
			System.out.println(path);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}
		printChessPaths(cc + 1, cr + 2, ec, er, path + "K1");
		printChessPaths(cc + 2, cr + 1, ec, er, path + "K2");
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			for (int i = 1; i <= ec; i++) {

				printChessPaths(cc + i, cr, ec, er, path + "RH" + i);
				printChessPaths(cc, cr + i, ec, er, path + "RV" + i);
			}
		}
		if (cc == cr || cc + cr == ec) {
			for (int i = 1; i <= ec; i++) {

				printChessPaths(cc + i, cr + i, ec, er, path + "B" + i);
			}
		}
	}

	public static ArrayList<String> getChessPaths(int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> rv = new ArrayList<>();
			return rv;

		}
		ArrayList<String> myresult = new ArrayList<>();
		ArrayList<String> K1 = getChessPaths(cc + 1, cr + 2, ec, er);
		for (int i = 0; i < K1.size(); i++)
			myresult.add("K1" + K1.get(i));
		ArrayList<String> K2 = getChessPaths(cc + 2, cr + 1, ec, er);
		for (int i = 0; i < K2.size(); i++)
			myresult.add("K2" + K2.get(i));
		if (cc == cr || cc + cr == ec) {
			for (int i = 1; i <= ec; i++) {
				ArrayList<String> B = getChessPaths(cc + i, cr + i, ec, er);
				for (int k = 0; k < B.size(); k++)
					myresult.add("B" + i + B.get(k));
			}
		}

		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			for (int i = 1; i <= ec; i++) {
				ArrayList<String> RH = getChessPaths(cc + i, cr, ec, er);
				for (int k = 0; k < RH.size(); k++) {
					myresult.add("RH" + i + RH.get(k));
				}
				ArrayList<String> RV = getChessPaths(cc, cr + i, ec, er);
				for (int k = 0; k < RV.size(); k++) {
					myresult.add("RV" + i + RV.get(k));
				}
			}
		}

		return myresult;
	}

	public static void printChessPathExtra(int cc, int cr, int ec, int er, String path) {
		int a = cc + (ec + 1) * cr + 1;

		if (cc == ec && cr == er) {
			System.out.println(path);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}
		if (a % 3 == 0 && a % 2 == 0) {
			System.out.println(path + "p");
			return;
		}
		if (a % 3 == 0 && a % 2 != 0) {
			return;
		}

		printChessPathExtra(cc + 1, cr + 2, ec, er, path + "K1");
		printChessPathExtra(cc + 2, cr + 1, ec, er, path + "K2");
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			for (int i = 1; i <= ec; i++) {

				printChessPathExtra(cc + i, cr, ec, er, path + "RH" + i);
				printChessPathExtra(cc, cr + i, ec, er, path + "RV" + i);
			}
		}
		if (cc == cr || cc + cr == ec) {
			for (int i = 1; i <= ec; i++) {

				printChessPathExtra(cc + i, cr + i, ec, er, path + "B" + i);
			}
		}
	}

	public static void printNQueens(boolean[][] board, int row, String config) {
		int n = board.length;
		if (row == n) {
			System.out.println(config);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isitsafeTPQ(board, row, col)) {
				board[row][col] = true;
				printNQueens(board, row + 1, config + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static boolean isitsafeTPQ(boolean[][] board, int row, int col) {
		for (int i = row; i >= 0; i--) {
			if (board[i][col] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == true) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> getNQueens(boolean[][] board, int row) {
		int n = board.length;
		if (row == n) {
			ArrayList<String> rv = new ArrayList<>();
			rv.add("");
			return rv;

		}
		ArrayList<String> myresult = new ArrayList<>();
		for (int col = 0; col < n; col++)
			if (isitsafeTPQ(board, row, col)) {
				board[row][col] = true;
				ArrayList<String> recresult = getNQueens(board, row + 1);
				for (int i = 0; i < recresult.size(); i++) {
					myresult.add("{" + row + "-" + col + "} " + recresult.get(i));
				}
				board[row][col] = false;
			}

		return myresult;
	}

	public static int KS(int[] weight, int[] vals, int rc, int vsf, int si) // rc-->remaining
																			// capacity,vsf-->valuesofar
	{
		if (si == weight.length) {
			return vsf;
		}
		int rv = 0;
		int vale = KS(weight, vals, rc, vsf, si + 1);
		int vali = 0;
		if (rc >= weight[si])
			vali = KS(weight, vals, rc - weight[si], vsf + vals[si], si + 1);
		rv = Math.max(vali, vale);
		return rv;
	}

	public static void allstring(int n,int dig, String str) {
		if (n==0) {
			System.out.println(str);
		}

		int l=(int)Math.pow(10,dig-1);
		allstring(n /l,dig-1,str + (char)(n /l) + 96);
		if (n / 100 <= 26)
		{
			int j=(int)Math.pow(10,dig-2);
			allstring(n / j,dig-2,str + (char)(n / j) + 96);
		}
	}

}
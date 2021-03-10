package lec9;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Recurssion {
	public static void main(String args[]) {
		/**********Si=Starting index;
		csf=countsofar**********/
		Scanner scn = new Scanner(System.in);
//		 int n = scn.nextInt();
//		 altdecinc(5);
//		 revtrian(1, 1, n);
//		 System.out.println(pow(n,3));
//		 System.out.println(fact(3));
//		box(1,1,5);
//	int[] arr = { 1, 1, 5, 1, 3, 1, 4, 1, 2 };
//	System.out.println(find(arr,0,6));
	
//		 System.out.println(max(arr, 0));
//		int[] arry = allIndicies(arr, 0, 1, 0);
//		for (int i = 0; i < arry.length; i++)
//		System.out.println(arry[i]);
		int[]arr={3,4,0,1,2};
		inverse(arr,0);
		for(int i=0;i<5;i++)
			System.out.print(arr[i]);
	}

	public static void decinc(int n) {
		if (n == 0)
			return;

		System.out.println(n);
		decinc(n - 1);
		System.out.println(n);

	}

	public static void altdecinc(int n) {
		if (n == 0)
			return;
		if (n % 2 == 1)
		System.out.println(n);
		altdecinc(n - 1);
		if (n % 2 == 0)
			System.out.println(n);

	}

	public static void box(int row, int col, int total) {
		if (row > total)
			return;
		
		if (col > total) {
			
			System.out.println();
			box(row + 1, 1, total);
			return;

		}
		System.out.print("*");
		box(row, col + 1, total);

	}

	public static void triangle(int row, int col, int total) {
		if (row > total)
			return;
		if (col > row) {
			System.out.println();
			triangle(row + 1, 1, total);
			return;
		}

		System.out.print("*");
		triangle(row, col + 1, total);

	}

	public static void revtrian(int row, int col, int total) {
		if (row > total)
			return;
		if (col > row) {

			revtrian(row + 1, 1, total);
			if (row != total)
				System.out.println();
			return;
		}
		revtrian(row, col + 1, total);
		System.out.print("*");

	}

	public static int fact(int n) {
		if (n == 0)
			return 1;
		int fact = fact(n - 1);
		fact = fact * n;
		return fact;

	}

	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int res = pow(x, n - 1);
		res = res * x;
		return res;

	}

	public static void display(int[] arr, int si) {
		if (si == arr.length) {
			System.out.println("END");
			return;
		}
		System.out.print(arr[si] + ",");
		display(arr, si + 1);

	}

	public static int max(int[] arr, int si) {
		if (si == arr.length)
			return arr[si-1];

		int max = max(arr, si + 1);
		if (arr[si] > max)
			max = arr[si];

		return max;
	}

	public static boolean find(int[] arr, int si, int data) {
		boolean rv = false;
		if (si == arr.length)
			return false;
		if (arr[si] == data)
			return true;
		rv = find(arr, si + 1, data);
		return rv;
	}

	public static int[] allIndicies(int[] arr, int si, int data, int csf) {
		if (si == arr.length) {
			return new int[csf];

		}
		if (arr[si] == data) {
			csf++;
		}
		int[] rv = allIndicies(arr, si + 1, data, csf);
		if (arr[si] == data)
			rv[--csf] = si;

		return rv;

	}
	public static void inverse(int[]arr,int si)
	{	
		if(si==arr.length)
			return;
		int temp=arr[si];
		inverse(arr,si+1);
		arr[temp]=si;
		return;
	}

}

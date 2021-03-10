package lec6;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Arrayops {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[] arr = takeinput();
		// display(arr);
		// int result = max(arr);
		// System.out.println(result);
		// reverse(arr);
		// display(arr);
		// int[]inv=invr(arr);
		// display(inv);
		// System.out.println("Enter No of Rotation to be display");
		// int n=scn.nextInt();
		// int []rot=rotate(arr,n);
		// display(rot);
		int[] one = { 1, 2, 3, 4, 5 };
		 int[] two = { 8, 9, 2, 11, 3 };
		// int[] res = sumofArrays(one, two);
		//
		// display(res);
		System.out.println(binary(one, 3));
//		Arrays.sort(two);//to sort an array
//		display(two);

	}

	public static int[] takeinput() {
		int n;
		System.out.println("Enter size of array");
		n = scn.nextInt();
		int[] arr = null;
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter value of " + i + "th element ");
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println("Over");
	}

	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			if (max < arr[i])
				max = arr[i];
		return max;
	}

	public static void reverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		for (; i < arr.length / 2; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

		}
	}

	public static int[] invr(int[] arr) {
		int[] arrb = new int[arr.length];
		int i = 0;
		while (i < arr.length) {
			int val = arr[i];
			arrb[val] = i;
			i++;
		}
		return arrb;
	}

	public static int[] rotate(int[] arr, int k) {
		int[] rot = new int[arr.length];
		k = k % arr.length;
		if (k < 0)
			k = k + arr.length;
		int l = arr.length - k;
		int i = 0;
		while (l < arr.length) {
			rot[i] = arr[l];
			i++;
			l++;
		}
		i = 0;
		while (k < arr.length) {
			rot[k] = arr[i];
			k++;
			i++;
		}
		return rot;
	}

	public static void path2d(int[][] arr2d) {
		int row = arr2d.length;
		int col = arr2d[0].length;
		int i = 0;
		int j = 0;
		int cd = 0, rd = 0, ci = 1, ri = 0;
		do {
			if (i == row || j == col)
				if (arr2d[i][j] == 1)
					break;
			if (ci == 1) {
				while (j < col) {

				}
			}

		} while (true);

	}

	public static int[] sumofArrays(int[] one, int[] two) {
		int[] rv = null;
		int len1 = one.length;
		int len2 = two.length;
		if (len1 > len2) {
			rv = new int[len1 + 1];
		} else {
			rv = new int[len2 + 1];
		}
		int k = rv.length - 1;
		int carry = 0;
		int sum = 0;
		for (int i = one.length - 1, j = two.length - 1; k >= 0; i--, j--, k--) {
			if (i >= 0 && j >= 0) {
				sum = carry + one[i] + two[j];

			} else if (i >= 0 && j < 0) {
				sum = carry + one[i];

			} else if (i < 0 && j >= 0) {
				sum = carry + two[j];

			} else {
				sum = carry;

			}
			carry = sum / 10;
			sum = sum % 10;
			rv[k] = sum;
		}
		return rv;
	}

	public static int binary(int[] arr, int data) {
		int rv = -1;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == data)

			{
				rv = mid;
				break;
			} else if (arr[mid] > data)
				right = mid - 1;
			else
				left = mid + 1;

		}
		return rv;

	}
	public static int[] sets(int[]arr)
	{
		
		
	}
}
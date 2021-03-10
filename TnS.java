package TimeAndSpace;

public class TnS {

	public static void main(String[] args) {
		int[] one = { 1, 4, 6 };
		int[] two = { 2, 3, 5 };
		int[] res = mergetwosortedarray(one, two);
		display(res);
		int[] arr = { 2, 5, 7, 1, 3, 6, 9, 8, 4 };
//		int[] reslt = mergesort(arr, 0, arr.length - 1);
//		display(reslt);
		quicksort(arr, 0, arr.length - 1);
		display(arr);
	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] mergetwosortedarray(int[] one, int[] two) {
		int i = 0, j = 0, k = 0;
		int[] arr = new int[one.length + two.length];
		while (i < one.length && j < two.length) {
			if (one[i] <= two[j]) {
				arr[k] = one[i];
				k++;
				i++;
			} else {
				arr[k] = two[j];
				k++;
				j++;
			}
		}
		
		while (i < one.length) {
			arr[k] = one[i];
			k++;
			i++;
		}
		while (j < two.length) {
			arr[k] = two[j];
			k++;
			j++;
		}
		return arr;
	}

	public static int[] mergesort(int[] arr, int left, int right) {
		if (left == right) {
			int[] rv = new int[1];
			rv[0] = arr[left];
			return rv;
		}
		int mid = (left + right) / 2;
		int fhalf[] = mergesort(arr, left, mid);
		int shalf[] = mergesort(arr, mid + 1, right);
		int[] sorted = mergetwosortedarray(fhalf, shalf);
		return sorted;
	}
	public static void quicksort(int[]arr,int lo,int hi){
		if(lo>=hi)
		{
			return;
		}
		
		int left=lo;
		int right=hi;
		int mid=(lo+hi)/2;
		int pivot=arr[mid];
		while(left<=right){
			while(arr[left]<pivot){
				left++;
			}
			while(arr[right]>pivot){
				right--;
			}
			if(left<=right){
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
			
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}
	public static int power(int x,int n)
	{
		if(n==0){
			return 1;
		}
		int xpn1=power(x,n/2);
		int xpn=xpn1*xpn1;
		if(n%2==1)
			xpn=xpn1*x;
		return xpn1;
	}
	
}

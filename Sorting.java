package lec7;

import lec6.*;

public class Sorting {
public static void main(String args[])
{
	int[] arr = null;
	 arr = Arrayops.takeinput();
	selectionsort(arr);
	for(int i:arr){
		System.out.print(i);}
}

	public static void bubblesort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++)
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);

			counter++;

		}
	}
		public static void swap(int[]arr,int i,int j)
		{
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}
		public static void selectionsort(int[] arr) {
				for (int i = 0; i < arr.length; i++)
					for(int j=i;j<arr.length-1;j++)
					if (arr[i] > arr[j + 1])
						swap(arr, i, j + 1);

			}
		public static void set(int []arr)
		{
			int n=(int)Math.pow(2, arr.length);
			for(int i=0;i<n;i++)
			{
				int j=i;
				for(int k=0;k<arr.length;k++)
				{
					int rem=j%2;
					j=j/2;
					if(rem==1)
						System.out.print(arr[k]);
				}
				System.out.print(",");
				
			}
			
			
		}
		public static void Maxset(int []arr)
		{
			int n=(int)Math.pow(2, arr.length);
			int[] rv=new int[n];
			int fres=0;
			int result=0;
			for(int i=0;i<n;i++)
			{
				int j=i;
				result=0;
				for(int k=0;k<arr.length;k++)
				{
					 
					int rem=j%2;
					j=j/2;
					if(rem==1)
					{
						System.out.print(arr[k]);
						result=result+arr[k];
					}
				}
				if(fres<result)
					fres=result;
				System.out.print(",");
				
			}
			System.out.println(fres);
			
		}
		public static void Mindifset(int []arr)
		
		{
			int n=(int)Math.pow(2, arr.length);
			int fres=10000;
			int result1=0;
			int result2=0;
			for(int i=0;i<n;i++)
			{
				int j=i;
				result1=0;
				result2=0;
				for(int k=0;k<arr.length;k++)
				{
					 
					int rem=j%2;
					j=j/2;
					if(rem==1)
					{
						result1=result1+arr[k];
					}
					else
						result2=result2+arr[k];
				}
				int result=Math.abs(result1-result2);
				if(fres>result)
					fres=result;
			}
			System.out.println(fres);
			
		}
		public static void tripleset(int []arr)
		{
			int n=(int)Math.pow(3, arr.length);
			int[] rv=new int[n];
			for(int i=0;i<n;i++)
			{
				int j=i;
				for(int k=0;k<arr.length;k++)
				{
					int rem=j%3;
					j=j/3;
					
					if(rem==0)
						System.out.print(",");
					else if(rem==1)
						System.out.print(arr[k]+",");
					else
					System.out.print(-1*arr[k]+",");
				}
					
				System.out.println();
			}
			
			}
		}	
package lec8;

import java.util.Scanner;

public class Stringops {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		String str = scn.nextLine();
//		printChars(str);
//		printSubStrings(str);
//		printsubset(str);
//		removedupicate(str);
//		strcompress(str);
//		System.out.println(maxfreq(str));
//		int a='a';
//		int b='z';
//		System.out.println(b+""+a);
//		System.out.println(toggleCase("aBCdeF"));
		System.out.println(pattern2("acf"));
	}

	public static void printChars(String str) {
		for (int i = 0; i < str.length(); i++)
			System.out.print(str.charAt(i));
		System.out.println();
	}

	public static void printSubStrings(String str) {
		for (int i = 0; i < str.length(); i++){
			for (int j = i+1; j <= str.length(); j++) {
				String str1 = str.substring(i, j);
				printChars(str1);
			}
		}
	}
	public static void printsubset(String str)
	{
		int len=str.length();
		int size=(int)Math.pow(2, len);
		
		for(int i=0;i<size;i++)
		{
			int l=i;
			for(int j=0;j<len;j++)
			{
				int rem=l%2;
				if(rem==1)
					System.out.print(str.charAt(j));
				l=l/2;
			}
			System.out.println();
		}
	}
	public static void removedupicate(String str )
	{
		String str1=str.substring(0,1);
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)!=str.charAt(i-1))
			{
				str1=str1+str.charAt(i);
			}
			
		}
		System.out.println(str1);
		
		
	}
	public static void strcompress(String str)
	{
		int count=1;
		String res=str.substring(0,1);
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==str.charAt(i-1)){
				count++;
			}
			else
			{
				if(count>1)
				res=res+count+str.charAt(i);
				else
					res=res+str.charAt(i);
				count=1;
			}
		}
		System.out.println(res);
	}
	public static char maxfreq(String str)
	{
		int max=0;
		char rv='\0';
		for(int i=0;i<str.length();i++)
		{	int count =1;
			char ch=str.charAt(i);
			for(int j=i+1;j<str.length();j++)
			{
				if(ch==str.charAt(j)){
					count++;
				}
			}
			if(max<count)
			{
				max=count;
				rv=ch;
			}
		}
		return rv;
	}
//	public static void permutation(String str)
//	{
//		
//		
//	}
	public static String toggleCase(String str)
	{
		StringBuilder str1=new StringBuilder(str);
		for(int i=0;i<str1.length();i++)
		{
			int a=str1.charAt(i);
			if(a>=97&&a<=122)
				a=a-32;
			else
				a=a+32;
			char ch=(char)a;
			str1.setCharAt(i, ch);
		}
		
		return str1.toString();
	}
	public static String pattern1(String str)
	{
		StringBuilder str1=new StringBuilder(str);
		for(int i=0;i<str.length();i++)
		{
			int v=str1.charAt(i);
			if(i%2==0)
			{
				v--;
			}
			else
				v++;
			str1.setCharAt(i,(char)v);
		}
		
		return str1.toString();
	}
	public static String pattern2(String str)
	{
		StringBuilder str1=new StringBuilder();
		char prev=str.charAt(0);
		char curr='\0';
		int asc=0;
		str1.append(prev);
		for(int i=1;i<str.length();i++)
		{
			curr=str.charAt(i);
			asc=(int)curr-prev;
			str1.append(asc);
			str1.append(curr);
			prev=curr;
			
			
		}
		return str1.toString();
	}
}

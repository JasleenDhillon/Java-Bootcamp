package lec4;

import java.util.Scanner;

public class AnybaseToDecimal {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Decimal number ");
		int av=scn.nextInt();
		int ab=scn.nextInt();
		int sv=anybaseToDecimal(av,ab);
		System.out.println(sv);
}

	public static int anybaseToDecimal(int av,int ab)
	{
		int sv=0;
		int abpower=1;
		while(av!=0)
		{
			int rem=av%10;
			sv=sv+rem*abpower;
			av/=10;
			abpower*=ab;
		}
		
		return sv;
	}
}

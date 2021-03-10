package lec4;

import java.util.Scanner;

public class AnybaseToAnybase {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int sv, sb, dv, db;
		sv = scn.nextInt();
		sb = scn.nextInt();
		db = scn.nextInt();
		dv = anybaseToAnybase(sv, sb, db);

	}

	public static int anybaseToAnybase(int sv, int sb, int db) {
		int dv = AnybaseToDecimal.anybaseToDecimal(sv, sb);
		int result = DecimalToAnyBase.decimalToAnybase(dv, db);
		return result;
	}
}
package lecture13thApril;

public class dp {

	public static void main(String[] args) {

		int d = EDIter("abcdg", "acdg");
		System.out.println(d);

	}

	public static int EDRec(String str1, String str2) {

		if (str1.length() == 0) {
			return str2.length();
		}

		if (str2.length() == 0) {
			return str1.length();
		}

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String s1 = str1.substring(1);
		String s2 = str2.substring(1);

		int rv = 0;
		int rem, rep, ins;

		if (ch1 == ch2) {
			rv = EDRec(s1, s2);
		}

		else {
			rep = 1 + EDRec(s1, s2);
			rem = 1 + EDRec(str1, s2);
			ins = 1 + EDRec(s1, str2);

			rv = Math.min(ins, Math.min(rep, rem));

		}

		return rv;

	}

	public static int EDIter(String str1, String str2) {

		int n1 = str1.length();
		int n2 = str2.length();
		int[][] strg = new int[n1 + 1][n2 + 1];

		for (int i = 0; i <= n1; i++) {
			strg[i][n2] = str1.length() - i;
		}

		for (int j = 0; j <= n2; j++) {
			strg[n1][j] = str2.length() - j;

		}

		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				if (str1.charAt(i) == str2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1];
				} else {
					strg[i][j] = 1 + Math.min(strg[i][j + 1], Math.min(strg[i + 1][j + 1], strg[i + 1][j]));
				}
			}
		}
		return strg[0][0];
	}

	public static int NoReduce(String s1, String s2) {
		int rv = 0;
		if (s2.length() == 0) {
			return 0;
		}
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] strg = new int[n1 + 1][n2 + 1];

		for (int i = 0; i <= n1; i++) {
			strg[i][n2] = 0;
		}

		for (int j = 0; j <= n2; j++) {
			strg[n1][j] = 0;
		}

		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				if(true){
					
				}

			}
		}
		return rv;
	}

}

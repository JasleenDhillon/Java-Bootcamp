package lecture27thApril;

public class HEClient {

	public static void main(String[] args) {

		HuffmanEncoder he = new HuffmanEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(he.encoder("aabbccddd"));
		
	}

}

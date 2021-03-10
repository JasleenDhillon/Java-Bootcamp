package lecture24thApril;

public class HashClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		HashMap1<String, Integer> h = new HashMap1(4);

		h.put("A", 10);
		h.put("B", 20);
		h.put("C", 30);
		h.put("D", 40);

		h.display();
		h.put("E", 50);
		h.put("F", 60);
		h.put("G", 70);
		h.put("H", 80);
		h.put("I", 90);
		h.put("J", 100);

		h.display();

	}

}

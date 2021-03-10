package lecture27thApril;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanEncoder {

	private class Node implements Comparable<Node> {
		Character data;
		Integer cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public HuffmanEncoder(String feeder) {
		HashMap<Character, Integer> fm = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			Character ch = feeder.charAt(i);
			if (fm.containsKey(ch)) {
				int ov = fm.get(ch);
				int nv = ov + 1;
				fm.put(ch, nv);
			} else {
				fm.put(ch, 1);
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		Set<Character> chars = fm.keySet();
		for (Character ch : chars) {
			Node node = new Node();
			node.data = ch;
			node.cost = fm.get(ch);
			node.left = null;
			node.right = null;
			pq.add(node);
		}

		while (pq.size() != 1) {
			Node one = pq.remove();
			Node two = pq.remove();
			Node node = new Node();
			node.data = '\0';
			node.cost = one.cost + two.cost;
			node.left = one;
			node.right = two;
			pq.add(node);

		}
		Node finished = pq.remove();
		this.fillencoderdecoder(finished, "");

	}

	private void fillencoderdecoder(Node node, String osf) {
		if (node.left == null && node.right == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);

			this.fillencoderdecoder(node.left, osf + "0");
			this.fillencoderdecoder(node.right, osf + "1");

		}
	}

	public String encoder(String str) {
		String rv = "";
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (encoder.containsKey(ch)) {
		Character code = encoder.get(ch);
				rv += code;
			}
		}
		return rv;

	}

	public String decoder(String str) {
		String rv = "";
		String prefix = "";
		for (int i = 0; i < str.length(); i++) {
			prefix += str.charAt(i);
			if (decoder.containsKey(prefix)) {
				Character code = decoder.get(prefix);
				rv += code;
				prefix = "";
			}
		}
		return rv;

	}

}

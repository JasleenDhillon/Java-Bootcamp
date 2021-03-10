package lecture24thApril;


public class hashmapcreation<K, V> {

	private class HMNode {
		K key;
		V value;

		HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private linkedlist<HMNode>[] bucketArray;
	private int size;

	public hashmapcreation(int cap) {
		this.bucketArray = (linkedlist<HMNode>[]) new linkedlist[cap];
		this.size = 0;
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		return Math.abs(hc % bucketArray.length);
	}

	public void put(K key, V value) throws Exception {
		int bi = this.hashFunction(key);

		linkedlist<HMNode> bucket = this.bucketArray[bi];

		if (bucket == null) {
			linkedlist<HMNode> bucketnew = new linkedlist<>();

			HMNode node = new HMNode(key, value);
			bucketnew.addLast(node);

			this.bucketArray[bi] = bucket;
			this.size++;

		} else {
			int foundAt = findInBucket(bucket, key);
			if (foundAt == -1) {
				HMNode node = new HMNode(key, value);
				bucket.addLast(node);
				this.size++;
			} else {
				HMNode node = bucket.getAt(foundAt);
				node.value = value;

			}
		}
	}

	private int findInBucket(linkedlist<HMNode> bucket, K key) throws Exception {
		int rv = -1;

		for (int i = 0; i < bucket.size(); i++) {
			HMNode temp = bucket.removeFirst();

			if (temp.key.equals(key)) {
				rv = i;
			}

			bucket.addLast(temp);

		}

		return rv;

	}

}

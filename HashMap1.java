package lecture24thApril;

import java.util.ArrayList;

public class HashMap1<K, V> {

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

	public HashMap1(int cap) {
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

			this.bucketArray[bi] = bucketnew;
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

	public V get(K key, V value) throws Exception {
		int bi = this.hashFunction(key);

		linkedlist<HMNode> bucket = this.bucketArray[bi];

		if (bucket == null) {

			return null;

		} else {
			int foundAt = findInBucket(bucket, key);
			if (foundAt == -1) {
				return null;

			} else {
				HMNode node = bucket.getAt(foundAt);
				return node.value;

			}
		}
	}

	public boolean containsKey(K key) throws Exception {
		int bi = this.hashFunction(key);

		linkedlist<HMNode> bucket = this.bucketArray[bi];

		if (bucket == null) {

			return false;

		} else {
			int foundAt = findInBucket(bucket, key);
			if (foundAt == -1) {
				return false;

			} else {
				return true;

			}
		}
	}

	public V remove(K key) throws Exception {
		int bi = this.hashFunction(key);

		linkedlist<HMNode> bucket = this.bucketArray[bi];

		if (bucket == null) {

			return null;

		} else {
			int foundAt = findInBucket(bucket, key);
			if (foundAt == -1) {
				return null;

			} else {
				HMNode node = bucket.removeAt(foundAt);
				this.size--;
				return node.value;

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

	public void display() throws Exception {

		System.out.println("~~~~~~~~~~~~~~~~~~~~");

		for (int i = 0; i < this.bucketArray.length; i++) {

			String str = "Bucket [" + i + "]" + "=>";
			for (int j = 0; this.bucketArray[i] != null && j < this.bucketArray[i].size(); j++) {
				HMNode node = this.bucketArray[i].removeFirst();

				str += "[" + node.key + ":" + node.value + " ]";
				this.bucketArray[i].addLast(node);

			}
			System.out.println(str + "END");
		}

		System.out.println("~~~~~~~~~~~~~~~~");

	}

	private void rehash() throws Exception {

		linkedlist<HMNode>[] oba = this.bucketArray;
		this.bucketArray = (linkedlist<HMNode>[]) new linkedlist[oba.length * 2];

		this.size = 0;

		for (int i = 0; i < oba.length; i++) {
			for (int j = 0; this.bucketArray[i] != null && j < this.bucketArray[i].size(); j++) {
				HMNode node = this.bucketArray[i].removeFirst();
				this.bucketArray[i].addLast(node);

				this.put(node.key, node.value);

			}
		}
	}

	private ArrayList<K> keySet() throws Exception {
		ArrayList<K> rv = new ArrayList<>();

		for (int i = 0; i < this.bucketArray.length; i++) {
			for (int j = 0; this.bucketArray[i] != null && j < this.bucketArray[i].size(); j++) {
				HMNode node = this.bucketArray[i].removeFirst();
				rv.add(node.key);
				this.bucketArray[i].addLast(node);

			}
		}
		return rv;
	}

}

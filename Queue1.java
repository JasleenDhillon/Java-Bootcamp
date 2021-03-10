package lecture13thApril;

public class Queue1 {
	private int[] data;
	private int front = 0;
	private int size = 0;

	public Queue1(int cap) {
		this.data = new int[cap];
	}

	public int size() {
		return this.size;
	}

	public boolean IsEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int tempE = (this.front + i) % this.data.length;
			System.out.print(this.data[tempE] + " =>");

		}
		System.out.println("END");

	}

	public void enqueue(int item) throws Exception {
		if (this.size == this.data.length) {
			throw new Exception("cannot add");
		}
		int end = (this.front + this.size) % this.data.length;
		this.data[end] = item;
		this.size++;

	}

	public int front() throws Exception {
		if (this.size == 0) {
			throw new Exception("empty");
		}
		int rv = this.data[this.front];
		return rv;
	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("empty");
		}
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;

	}

}

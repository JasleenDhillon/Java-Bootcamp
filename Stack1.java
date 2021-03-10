package lecture13thApril;

public class Stack1 {

	private int[] data;
	private int tos;

	public Stack1(int capacity) {
		this.data = new int[capacity];
		this.tos = -1;
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is full");
		}

		this.tos++;
		this.data[this.tos] = item;
	}

	public int pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos];

		this.data[this.tos] = 0;
		this.tos--;

		return rv;
	}

	public int top() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is empty");
		}

		int rv = this.data[this.tos];

		return rv;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + "=>");
		}
		System.out.println("END");
	}
}

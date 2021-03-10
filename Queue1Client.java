package lecture13thApril;

public class Queue1Client {

	public static void main(String[] args) throws Exception {

		Queue1 q = new Queue1(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.display();
		System.out.println(q.front());

		System.out.println(q.dequeue());
		q.display();
		q.enqueue(50);
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.enqueue(70);
		q.display();

		// System.out.println(q.dequeue());
		// q.display();

		// System.out.println(q.dequeue());
		// q.display();

		// System.out.println(q.dequeue());
		// q.display();

		// System.out.println(q.dequeue());
		// q.display();

		// System.out.println(q.dequeue());
		// q.display();

		displayReverse(q, 0);
		q.display();
		

		reverseQueue(q);
		q.display();

	}

	public static void reverseQueue(Queue1 q) throws Exception {
		if (q.IsEmpty()) {
			return;
		}

		int temp = q.dequeue();
		reverseQueue(q);
		q.enqueue(temp);
	}

	public static void displayReverse(Queue1 q, int count) throws Exception {
		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		displayReverse(q, count + 1);

		System.out.println(temp);
	}


}

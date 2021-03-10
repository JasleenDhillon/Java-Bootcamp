package lecture24thApril;

public class linkedlistclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		linkedlist<Car> ll = new linkedlist();
		ll.addLast(new Car("A", 100, 25));
		ll.addLast(new Car("B", 300, 45));
		ll.addLast(new Car("C", 400, 15));
		ll.addLast(new Car("D", 400, 15));
		ll.addLast(new Car("E", 400, 15));
		
		ll.removeLast();
		
		ll.display();

	}

	private static class Car implements Comparable<Car> {
		String name;
		int speed;
		int price;

		Car(String name, int speed, int price) {
			this.name = name;
			this.speed = speed;
			this.price = price;
		}

		@Override
		public int compareTo(Car other) {
			// TODO Auto-generated method stub
			return this.price - other.price;
		}

		@Override
		public String toString() {
			String rv = "";
			rv = rv + this.name + ": " + this.speed + "," + this.price;
			return rv;

		}
	}
}

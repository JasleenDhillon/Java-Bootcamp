package lecture1stMay;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap<Student> hp = new Heap<>(true);

		hp.add(new Student("A", 60));
		hp.add(new Student("B", 70));
		hp.add(new Student("C", 20));
		hp.add(new Student("D", 10));
		hp.add(new Student("E", 50));
		hp.add(new Student("F", 40));
		hp.add(new Student("G", 30));

		hp.display();

		System.out.println(hp.getHP());

		System.out.println(hp.removeHP());
		hp.display();

	}

	public static class Student implements Comparable<Student> {

		String name;
		int rank;

		public Student(String name, int rank) {
			this.name = name;
			this.rank = rank;

		}

		public String toString() {
			String rv = "";

			rv += this.name + " [" + this.rank + "] ";
			return rv;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.rank - o.rank;
		}

	}

}

package lecture24thApril;

public class BSTClient {

	public static void main(String[] args) {

		int[] SA = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		BST bt = new BST(SA);
		bt.display();
		System.out.println(bt.max());
		System.out.println(bt.height());
		System.out.println(bt.find(62));
		System.out.println(bt.size2());

		bt.preorder();
		bt.postorder();
		bt.inorder();
		bt.preorderIterative();
		bt.levelorder();

		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());
		System.out.println(bt.Isbalanced());
		System.out.println(bt.IsBST());
		System.out.println(bt.IsBST2());

		bt.add(88);
		bt.display();
		System.out.println("-------------------");

		bt.remove(50);
		bt.display();

		bt.PrintInRange(20, 50);
		
		System.out.println("------------");
		bt.replacebySum();
		bt.display();

	}

}

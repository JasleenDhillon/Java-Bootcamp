package lecture22ndApril;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// 50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false

		 BinaryTree bt = new BinaryTree();

		 bt.display();
		 System.out.println(bt.max());
		 System.out.println(bt.height());
		 System.out.println(bt.find(62));
		 System.out.println(bt.size2());

		/* bt.preorder();
		 bt.postorder();
		 bt.inorder();
		 bt.preorderIterative();
		 bt.levelorder();
*/
/*		int[] pre = { 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87 };
		int[] in = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		int[] post = { 12, 30, 40, 37, 25, 60, 70, 62, 87, 75, 50 };

		BinaryTree b = new BinaryTree(pre, post);
		b.display();
		
*/	
		 System.out.println(bt.diameter());
		 System.out.println(bt.diameter2());
		 System.out.println(bt.Isbalanced());
		 System.out.println(bt.IsBST());
		 System.out.println(bt.IsBST2());
		 System.out.println("------------------");

		// bt.levelOrderline();
		// bt.levelorederZigzag();
		 
		 bt.multiSolver(65);
	
	
	}

}

package lecture13thApril;

public class Stack1Client {

	public static void main(String[] args) throws Exception {
		Stack1 st = new Stack1(5);
		Stack1 helper = new Stack1(5);

		st.push(10);

		st.push(20);

		st.push(30);

		st.push(40);

		st.push(50);
		st.display();

		// displayReverseStack(st);

		// st.display();

		// ReverseStack(st, helper, false);
		st.display();
		// System.out.println(BalanceBrackets1("[{(a+b)+(c+d)}]"));
		System.out.println(DuplicateParanthesis("((a+b)c)"));
	}

	public static boolean BalanceBrackets1(String str) throws Exception {
		Stack1 s = new Stack1(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				s.push(ch);
			}
			if (ch == '[') {
				s.push(ch);
			}
			if (ch == '{') {
				s.push(ch);
			}

			if (ch == ')') {

				if (s.isEmpty() || s.top() != '(') {
					return false;
				} else {
					s.pop();
				}
			}
			if (ch == '[') {

				if (s.isEmpty() || s.top() != '[') {
					return false;
				} else {
					s.pop();
				}
			}
			if (ch == '}') {

				if (s.isEmpty() || s.top() != '{') {
					return false;
				} else {
					s.pop();
				}
			}
		}
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean DuplicateParanthesis(String str) throws Exception {
		Stack1 s = new Stack1(str.length());
		s.push(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (s.top() != ')') {
				s.push(ch);
				continue;
			} else {

				if (ch == ')') {
					return false;
				} else {
					while (s.top() != '(') {
						s.pop();
					}
					s.pop();
				}

			}
		}
		return true;
	}

	public static void displayReverseStack(Stack1 stack) throws Exception {
		if (stack.isEmpty()) {
			return;
		}

		int item = stack.pop();
		displayReverseStack(stack);

		System.out.println(item);
		stack.push(item);
	}

	public static void ReverseStack(Stack1 s, Stack1 helper, boolean flag) throws Exception {
		if (flag == false) {
			if (s.isEmpty()) {
				ReverseStack(s, helper, true);
				return;
			}
			int temp = s.pop();
			helper.push(temp);
			ReverseStack(s, helper, flag);

		} else {
			if (helper.isEmpty()) {
				return;
			}

			int temp1 = helper.pop();
			ReverseStack(s, helper, flag);
			s.push(temp1);
		}
	}

}

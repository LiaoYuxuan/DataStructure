package stack;

import java.util.Stack;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverse("droW olleH"));
	}

	public static String reverse(String words){
		java.util.Stack<String> stack = new Stack<String>();
		char[] wchar = words.toCharArray();
		for (char c : wchar) {
			stack.push(String.valueOf(c));
		}
		String reverse = "";
		while (!stack.isEmpty()) {
			reverse += stack.pop();
		}
		return reverse;
	}

}

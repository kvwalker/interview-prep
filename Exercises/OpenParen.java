// check to see if parenthesis match
import java.util.*;
public class OpenParen {

	public boolean isOpen (char c) {
		if (c == '{' || c == '(' || c == '[') {
			return true;
		}
		return false;
	}

	public boolean isClosed (char c) {
		if (c == '}' || c == ']' || c == ')') {
			return true;
		}
		return false;
	}

	public boolean closes (char c, char d) {
		if (c == '{') {
			return d == '}';
		}
		if (c == '[') {
			return d == ']';
		}
		if (c == '(') {
			return d == ')';
		}
		return false;
	}
	
	public boolean isMatch (String s) {
		char[] chars = s.toCharArray();
		Stack<Character> matches = new Stack<Character>();
		for (char c : chars) {
			if (isOpen(c)) {
				matches.push(c);
			} else if (isClosed(c)) {
				if (matches.isEmpty() || !closes(matches.pop(), c)) {
					return false;
				}
			}
		}

		return matches.isEmpty();
	}

	public static void main (String[] args) {
		OpenParen op = new OpenParen();
		System.out.println(op.isMatch("{{(())}}"));
		System.out.println(op.isMatch("{[)[]]))}}"));
	}
}
import java.util.*;

public class EnglishInt {

	String[] smalls = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	String[] bigs = {"", "thousand", "million", "billion"};
	String negative = "negative";

	public String convert (int n) {
		// count number of digits
		if (n == 0) {
			return smalls[0];
		}
		if (n < 0) {
			return negative + " " + convert(-1*n);
		}

		LinkedList<String> parts = new LinkedList<String>();
		int commaCount = 0;

		while (n > 0) {
			if (n % 1000 != 0) {
				String chunk = convertChunk(n%1000) + " " + bigs[commaCount];
				parts.addFirst(chunk);
			}
			n /= 1000;
			commaCount++;
		}
		return makeString(parts);
	}

	public String convertChunk (int n) {
		LinkedList<String> parts = new LinkedList<String>();

		// convert hundreds
		if (n >= 100) {
			parts.addLast(smalls[n/100] + " hundred");
			n %= 100;
		}

		// convert tens
		if (n >= 10 && n <= 19) {
			parts.addLast(smalls[n]);
		} else if (n >= 20) {
			parts.addLast(tens[n/10]);
			n %= 10;
		}

		// convert ones
		if (n >= 1 && n <= 9) {
			parts.addLast(smalls[n]);
		}

		return makeString(parts);
	}

	public String makeString (LinkedList<String> l) {
		StringBuilder sb = new StringBuilder();
		while (l.size() > 1) {
			sb.append(l.pop());
			sb.append(" ");
		}
		sb.append(l.pop());
		return sb.toString();
	}

	public static void main (String[] args) {
		EnglishInt test = new EnglishInt();
		System.out.println(test.convert(19323984));
	}
}
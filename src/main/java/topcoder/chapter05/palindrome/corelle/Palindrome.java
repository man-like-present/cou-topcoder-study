package topcoder.chapter05.palindrome.corelle;

/**
 * Created by noblesm on 2017. 6. 24..
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(find("a"));
		System.out.println(find("abab"));
		System.out.println(find("abacaba"));
		System.out.println(find("qwerty"));
		System.out.println(find("abdfhdyrbdbsdfghjkllkjhgfds"));
	}

	private static int find(String s) {
		int count = s.length();

		int head = 0;
		int tail = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {

			if (head == tail) {
				break;
			}

			if (s.charAt(head) == s.charAt(tail)) {
				head += 1;
				tail -= 1;
			} else {
				count += 1;
				head += 1;
			}
		}

		return count;
	}
}

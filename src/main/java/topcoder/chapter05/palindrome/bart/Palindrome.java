package topcoder.chapter05.palindrome.bart;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println(String.valueOf(find("ab")));
		System.out.println(String.valueOf(find("abacaba")));
		System.out.println(String.valueOf(find("qwerty")));
		System.out.println(String.valueOf(find("abdfhdyrbdbsdfghjkllkjhgfds")));
		System.out.println(String.valueOf(find("aabb")));
		System.out.println(String.valueOf(find("a")));
	}

	public static int find(String s) {
		char[] input = s.toCharArray();
		int length = input.length;
		while (true) {
			int centerPivot = findCenterPivot(length);
			int lengthAddCount = 1;
			int searchPivotToEnd = findEndPivot(centerPivot, length);
			int searchPivotToStart = centerPivot-1;
			boolean palindromeFlag = true;

			while(searchPivotToStart >= 0 && searchPivotToEnd < input.length) {
				if(input[searchPivotToStart] == input[searchPivotToEnd]) {
					lengthAddCount++;
					searchPivotToEnd++;
					searchPivotToStart--;
				} else {
					length += lengthAddCount;
					palindromeFlag = false;
					break;
				}
			}

			if(!palindromeFlag) {
				continue;
			}

			break;
		}

		return length;
	}

	private static int findEndPivot(int centerPivot, int length) {
		if(isEven(length)) {
			return centerPivot;
		}
		return centerPivot+1;
	}

	private static int findCenterPivot(int length) {
		if(isEven(length)) {
			return length / 2;
		}
		return Math.floorDiv(length, 2) ;
	}

	private static boolean isEven(int val) {
		return val % 2 == 0;
	}
}
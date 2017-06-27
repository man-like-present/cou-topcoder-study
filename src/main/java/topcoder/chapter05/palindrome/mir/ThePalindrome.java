package topcoder.chapter05.palindrome.mir;

public class ThePalindrome {
    public int find(String s) {
        int length = s.length();
        int halfLength = length / 2;
        for (; halfLength < length; halfLength++) {
            int i;
            for (i = 0; halfLength + i < length; i++) {
                if (s.charAt(halfLength + i) == s.charAt(halfLength - i)) {
                    continue;
                }
                break;
            }
            if (halfLength + i == length) {
                return halfLength * 2 + 1;
            }
            for (i = 0; halfLength+ 1 + i  < length; i++) {
                if (s.charAt(halfLength+ 1 + i ) == s.charAt(halfLength - i)) {
                    continue;
                }
                break;
            }
            if (halfLength + 1 + i  == length) {
                return (halfLength + 1) * 2;
            }
        }
        return s.length() * 2;
    }
}
//
//
//package topcoder.chapter05.palindrome.mir;
//
//public class ThePalindrome {
//    public int find(String s) {
//        int length = s.length();
//        int halfLength = length / 2;
//        for (; halfLength < length; halfLength++) {
//            for (int evenNumber = 0; evenNumber <= 1; evenNumber++) {
//                if (checkPalindrome(s, length, halfLength, evenNumber)) {
//                    return halfLength * 2 + (evenNumber == 1 ? 0 : 1);
//                }
//            }
//        }
//        return s.length() * 2;
//    }
//
//    private boolean checkPalindrome(String s, int length, int halfLength, int evenNumber) {
//        int i;
//        for (i = 0; halfLength + i + evenNumber < length; i++) {
//            if (s.charAt(halfLength + i + evenNumber) == s.charAt(halfLength - i)) {
//                continue;
//            }
//            break;
//        }
//        if (halfLength + i + evenNumber == length) {
//            return true;
//        }
//        return false;
//    }
//}

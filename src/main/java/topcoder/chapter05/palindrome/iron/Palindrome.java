package topcoder.chapter05.palindrome.iron;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 6. 25.
 * Time: 오후 9:52
 */
public class Palindrome {

    public static void main(String[] agrs) {
        Palindrome palindrome = new Palindrome();

        System.out.println(palindrome.find("abdfhdyrbdbsdfghjkllkjhgfds"));
    }

    public int find(String s) {
        int length = s.length();
        while(true) {
            boolean isPalindrome = true;
            for(int i = 0; i < s.length(); i++) {
                if((length - s.length() - 1) <  i && s.charAt(i) !=s.charAt(length - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }

            if(isPalindrome) {
                return length;
            }

            length++;
        }
    }


}

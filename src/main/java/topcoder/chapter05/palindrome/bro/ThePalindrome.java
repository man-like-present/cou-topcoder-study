package topcoder.chapter05.palindrome.bro;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

/**
 * Created by bro. on 2017. 6. 26..
 */
public class ThePalindrome {

    public int find(String s) {

        if (this.isValidInput(s)) {
            return NumberUtils.INTEGER_MINUS_ONE;
        }

        // size 만을 리턴하기 위해 길이만 계산
        char [] splitString = s.toCharArray();

        int stringLength = s.length();
        int target = splitString.length - NumberUtils.INTEGER_ONE;

        for (int current = NumberUtils.INTEGER_ZERO ; current < splitString.length && current != target ; current++) {
            if (splitString[current] != splitString[target]) {
                // 길이만 필요하기 때문에 굳이 문자열을 저장하지 않는다.
                stringLength++;
            } else {
                target--;
            }
        }

        return stringLength;
    }

    private boolean isValidInput(String s) {
        return !s.matches("[a-z]+");
    }


    public String findString(String s) {
        if (this.isValidInput(s)) {
            return "Permission Denied(allowed Only [a-z]+)";
        }

        char [] splitString = s.toCharArray();
        List<String> additionalCharList = Lists.newArrayList();

        int target = splitString.length - NumberUtils.INTEGER_ONE;
        for (int current = NumberUtils.INTEGER_ZERO ; current < splitString.length && current != target ; current++) {
            if (splitString[current] != splitString[target]) {
                additionalCharList.add(NumberUtils.INTEGER_ZERO, String.valueOf(splitString[current]));
            } else {
                target--;
            }
        }

        StringBuilder result = new StringBuilder(s);
        for (String additionalString : additionalCharList) {
            result.append(additionalString);
        }

        return result.toString();
    }
}

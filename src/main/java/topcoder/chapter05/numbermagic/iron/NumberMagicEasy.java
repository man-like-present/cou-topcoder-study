package topcoder.chapter05.numbermagic.iron;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 7. 9.
 * Time: 오후 10:33
 */
public class NumberMagicEasy {


    public static void main(String[] args) {
        NumberMagicEasy numberMagic = new NumberMagicEasy();

        System.out.println(numberMagic.theNumber("NNNN"));
    }

    private String[] card = {
            "YYYYYYYYNNNNNNNN",
            "YYYYNNNNYYYYNNNN",
            "YYNNYYNNYYNNYYNN",
            "YNYNYNYNYNYNYNYN"

    };

    private String[] isAnswers = new String[16];

    public int theNumber(String answer) {
        init();
        for(int i = 0; i < StringUtils.length(answer); i++) {
            setNumber(card[i], isAnswers, answer.charAt(i));
        }


        for(int i = 0; i < isAnswers.length; i++) {
            if("YYYY".equals(isAnswers[i])) {
                return i + 1;
            }
        }

        return 0;
    }


    private String[] setNumber(String card, String[] answers, char yn) {
        for(int i = 0; i < 16; i++) {
            if(BooleanUtils.toBooleanObject(String.valueOf(yn))) {
                isAnswers[i] += card.charAt(i);
            } else {
                isAnswers[i] += opposite(card.charAt(i));
            }
        }

        return answers;
    }

    private char opposite(char yn) {
        return yn == 'Y' ? 'N' : 'Y';
    }

    private void init() {
        for(int i = 0; i < isAnswers.length; i++) {
            isAnswers[i] = "";
        }
    }
}

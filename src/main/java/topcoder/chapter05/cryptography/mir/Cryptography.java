package topcoder.chapter05.cryptography.mir;


import java.util.ArrayList;
import java.util.List;

public class Cryptography {
    public long encrypt(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort(Integer::compareTo);
        Integer min = list.get(0)+1;
        list.add(0, min);
        long result = 1;
        for (Integer integer : list) {
            result *= integer;
        }
        return result;
    }
}
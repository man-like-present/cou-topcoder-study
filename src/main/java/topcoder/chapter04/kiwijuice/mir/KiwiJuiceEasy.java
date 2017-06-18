package topcoder.chapter04.kiwijuice.mir;

public class KiwiJuiceEasy {
    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        int count = fromId.length;
        for (int i = 0; i < count; i++) {
            int sum = bottles[toId[i]] + bottles[fromId[i]];
            if (capacities[toId[i]] < sum) {
                bottles[toId[i]] = capacities[toId[i]];
                bottles[fromId[i]] = sum - capacities[toId[i]];
            } else {
                bottles[toId[i]] = sum;
                bottles[fromId[i]] = 0;
            }
        }
        return bottles;
    }
}

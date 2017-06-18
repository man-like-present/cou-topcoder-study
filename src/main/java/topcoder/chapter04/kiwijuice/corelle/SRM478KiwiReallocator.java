package topcoder.chapter04.kiwijuice.corelle;

import java.util.Arrays;

public class SRM478KiwiReallocator {

    public static void main(String[] args) {
        int[] capacities = {14, 35, 86, 58, 25, 62};
        int[] bottles = {6, 34, 27, 38, 9, 60};
        int[] fromIds = {1,2,4,5,3,3,1,0};
        int[] toIds = {0,1,2,4,2,5,3,1};

        System.out.println(Arrays.toString(thePouring3(capacities, bottles, fromIds, toIds)));
        System.out.println("[0, 14, 65, 35, 25, 35] -> Answer");
    }

    private static int[] thePouring1(int[] capacities, int[] bottles, int[] fromIds, int[] toIds) {
        for (int i = 0; i < fromIds.length; i++) {
            int fromKiwi = bottles[fromIds[i]];
            int space = capacities[toIds[i]] - bottles[toIds[i]];

            if (fromKiwi <= space) {
                bottles[toIds[i]] += bottles[fromIds[i]];
                bottles[fromIds[i]] = 0;
            } else {
                bottles[toIds[i]] += space;
                bottles[fromIds[i]] -= space;
            }
        }
        return bottles;
    }

    private static int[] thePouring2(int[] capacities, int[] bottles, int[] fromIds, int[] toIds) {
        for (int i = 0; i < fromIds.length; i++) {
            int amount = bottles[fromIds[i]];
            int space = capacities[toIds[i]] - bottles[toIds[i]];

            int min = Math.min(amount, space);
            bottles[fromIds[i]] -= min;
            bottles[toIds[i]] += min;
        }
        return bottles;
    }

    private static int[] thePouring3(int[] capacities, int[] bottles, int[] fromIds, int[] toIds) {
        for (int i = 0; i < fromIds.length; i++) {
            int sum = bottles[fromIds[i]] + bottles[toIds[i]];
            int min = Math.min(sum, capacities[toIds[i]]);
            bottles[toIds[i]] = min;
            bottles[fromIds[i]] = sum - min;
        }
        return bottles;
    }
}

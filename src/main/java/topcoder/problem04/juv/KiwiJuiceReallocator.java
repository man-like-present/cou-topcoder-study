package topcoder.problem04.juv;

import java.util.Arrays;

/**
 * Created by Juv on 2017-06-11.
 */
public class KiwiJuiceReallocator {
    // 각 병의 용량
    private int[] capacities;

    // 각 병의 주스량
    private int[] bottles;

    private int[] fromId;

    private int[] toId;

    public KiwiJuiceReallocator capacities(int[] capacities) {
        this.capacities = capacities;
        return this;
    }

    public KiwiJuiceReallocator bottles(int[] bottles) {
        this.bottles = bottles;
        return this;
    }

    public KiwiJuiceReallocator fromId(int[] fromId) {
        this.fromId = fromId;
        return this;
    }

    public KiwiJuiceReallocator toId(int[] toId) {
        this.toId = toId;
        return this;
    }

    public int[] reallocate() {
        if (fromId.length != toId.length) {
            throw new IllegalArgumentException();
        }
        int m = fromId.length;

        for (int i = 0; i < m; i++) {
            int from = fromId[i];
            int to = toId[i];

            int sum = bottles[from] + bottles[to];
            bottles[to] = sum > capacities[to] ? capacities[to] : sum;
            bottles[from] = sum - bottles[to];
        }


        return bottles;
    }
}

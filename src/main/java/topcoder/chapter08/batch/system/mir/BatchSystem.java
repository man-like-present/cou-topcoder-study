package topcoder.chapter08.batch.system.mir;

import java.util.ArrayList;
import java.util.List;

public class BatchSystem {
    private static final int[] WRONG_VALUE = new int[0];


    public int[] schedule(int[] duration, String[] user) {
        if (duration.length != user.length) {
            return WRONG_VALUE;
        }
        List<Program> programs = new ArrayList<>();
        for (int i = 0; i < duration.length; i++) {
            programs.add(new Program(i, user[i], duration[i]));
        }

        int[] objects = programs.stream()
                .sorted((o1, o2) -> {
                    if (o1.duration == o2.duration) {
                        return String.CASE_INSENSITIVE_ORDER.compare(o1.userName, o2.userName);
                    }
                    return o1.duration - o2.duration;
                })
                .mapToInt(value -> value.order)
                .toArray();
        return objects;
    }

    class Program {
        private int order;
        private String userName;
        private int duration;

        public Program(int order, String userName, int duration) {
            this.order = order;
            this.userName = userName;
            this.duration = duration;
        }
    }
}

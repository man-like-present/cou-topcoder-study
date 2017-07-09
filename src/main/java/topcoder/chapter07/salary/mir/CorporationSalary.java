package topcoder.chapter07.salary.mir;

public class CorporationSalary {
    private long[] counts;

    public long totalSalary(String[] relations) {
        long sum = 0;
        counts = new long[relations.length];
        for (int i = 0; i < relations.length; i++) {
            sum += check(relations, i);
        }
        return sum;
    }

    private long check(String[] relations, int i) {
        if (counts[i] != 0) {
            return counts[i];
        }
        long count = 0;
        for (int j = 0; j < relations.length; j++) {
            if (relations[i].charAt(j) == 'Y') {
                count += check(relations, j);
            }
        }
        if (count == 0) {
            return 1;
        }
        counts[i] = count;
        return count;
    }
}

package topcoder.chapter07.salary.juv;

import java.util.HashMap;

/**
 * @author Juv
 * @since 2017-07-06
 */
public class CorporationSalary {

    private static final char SUBORDINATE = 'Y';

    public long totalSalary(String[] relations) {

        validate(relations);

        /*
        // calculateSalary()는 for문 사용을 유지하고
        // stream 사용시 -> 95ms
        // for 문 사용시  -> 5ms
        return IntStream.range(0, relations.length)
                .mapToLong(employeeIndex -> calculateSalary(relations, employeeIndex))
                .sum();
        */

        long totalSalary = 0L;
        HashMap<Integer, Long> salaries = new HashMap<>();
        for (int employeeIndex = 0; employeeIndex < relations.length; employeeIndex++) {
            totalSalary += calculateSalary(employeeIndex, relations, salaries);
        }
        return totalSalary;
    }

    private long calculateSalary(int targetEmployeeIndex, String[] relations, HashMap<Integer, Long> salaries) {
        if (salaries.get(targetEmployeeIndex) != null) {
            return salaries.get(targetEmployeeIndex);
        }

        char[] relation = relations[targetEmployeeIndex].toCharArray();

        long salary = 0L;
        for (int subordinateIndex = 0; subordinateIndex < relation.length; subordinateIndex++) {
            if (SUBORDINATE == relation[subordinateIndex]) {
                salary += calculateSalary(subordinateIndex, relations, salaries);
            }
        }

        /*
        // totalSalary 구하는 부분 for문 사용 유지하고
        // for문 사용시 5ms -> stream 사용시 110ms
        long salary = IntStream.range(0, relation.length)
                .filter(employeeIndex -> isSubordinate(relation[employeeIndex]))
                .mapToLong(employeeIndex -> calculateSalary(relations, employeeIndex))
                .sum();
        */

        salary = salary == 0L ? 1L : salary;
        salaries.put(targetEmployeeIndex, salary);
        return salary;
    }

    private void validate(String[] relations) {
        int length = relations.length;

        if (length == 0 || length != relations[0].length()) {
            throw new IllegalArgumentException("Illegal Input : relation");
        }
    }

    /*
    private boolean isSubordinate(char c) {
        return SUBORDINATE == c;
    }
    */
}

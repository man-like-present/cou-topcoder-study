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
}

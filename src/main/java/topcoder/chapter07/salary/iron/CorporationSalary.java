package topcoder.chapter07.salary.iron;

/**
 * Created with IntelliJ IDEA
 * User: 아이언
 * Date: 2017. 7. 10.
 * Time: 오후 11:04
 */
public class CorporationSalary {


    public static void main(String[] args) {
        CorporationSalary corporationSalary = new CorporationSalary();
        String[] a  = {
                "NNNNNN",
                "YNYNNY",
                "YNNNNY",
                "NNNNNN",
                "YNYNNN",
                "YNNYNN"
        };
        System.out.println(corporationSalary.totalSalary(a));
    }


    private long[] salaries = new long[50];
    private String unRelated = "";
    public long totalSalary(String[] relation) {
        for (int i = 0; i < relation[0].length(); i++) {
            unRelated += "N";
        }

        long total = 0;
        for (int i=0; i<relation.length; i++) {
            total += total(i, relation);
        }

        return total;
    }

    private long total(int n, String[] relations) {
        if (salaries[n] != 0) return salaries[n];

        String relation = relations[n];
        long sal = 0;
        if (relations[n].equals(unRelated)) return 1;
        for (int i=0; i<relation.length();i++) {
            if (relation.charAt(i) == 'Y') {
                sal += total(i, relations);
            }
        }

        salaries[n] = sal;
        return salaries[n];

    }
}

package topcoder.chapter07.salary.bro;

/** * Created with Intellij IDEA_17.
 * cou-topcoder-study
 * for
 */
public class CorporationSalary {

	private static final char MY_SUBORDINATE = 'Y';

	private static final long THE_TRICKSTER = -1;
	private static final long MIN_SALARY = 1;

	private static final int MIN_LENGTH = 1;

	public long totalSalary(String[] relations) {

		if (this.isInvalidInput(relations)) {
			return THE_TRICKSTER;
		}

		long salaries[] = new long[relations.length];
		long total = 0;
		for (int employNumber = 0; employNumber < relations.length; employNumber++) {
			total += this.getSalaryOfMine(employNumber, salaries, relations);
		}

		return total;
	}

	private long getSalaryOfMine(int employNumber, long[] salaries, String[] relations) {
		long myTotal = 0;

		char[] myRelation = relations[employNumber].toCharArray();

		if (!relations[employNumber].matches("N+")) {
			for (int subordinateNumber = 0; subordinateNumber < myRelation.length; subordinateNumber++) {
				if (myRelation[subordinateNumber] == MY_SUBORDINATE) {
					myTotal += this.getSalaryOfMine(subordinateNumber, salaries, relations);
				}
			}
		} else {
			myTotal = MIN_SALARY;
		}

		salaries[employNumber] = myTotal;
		return myTotal;
	}

	private boolean isInvalidInput(String[] relations) {

		if (relations.length < MIN_LENGTH) {
			System.out.println("Trickster!! You must answer 1 ~ 50 relations");
			return true;
		}

		for (String relation : relations) {
			if (relation.matches("/[YN]+/")) {
				System.out.println("Trickster!! You must answer only use the Y or N");
				System.out.println("=> [" + relation + "] is invalid Input.");
				return true;
			}
		}

		return false;
	}
}

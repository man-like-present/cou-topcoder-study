package topcoder.chapter08.auto.loan.corelle;

public class AutoLoan {

	public static void main(String[] args) {
		AutoLoan autoLoan = new AutoLoan();
		System.out.println(autoLoan.interestRate(6800, 100, 68));
		System.out.println(autoLoan.interestRate(2000, 510, 4));
		System.out.println(autoLoan.interestRate(15000, 364, 48));
	}

	public double interestRate(double price, double monthlyPayment, int loanTerm) {
		double maxRate = 1;
		double minRate = 0;
		double pivotRate = 0;

		for (int i = 0; i < 600; i++) {
//		while ((1e-9 < maxRate - minRate) && (1e-9 < (maxRate - minRate) / maxRate)) {
			double balance = price;
			pivotRate = (maxRate + minRate) / 2;

			for (int j = 0; j < loanTerm; j++) {
				balance *= (pivotRate / 12) + 1;
				balance -= monthlyPayment;
			}

			if (0 < balance) {
				maxRate = pivotRate;
			} else {
				minRate = pivotRate;
			}
		}

		return pivotRate * 100;
	}
}

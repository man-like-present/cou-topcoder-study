package topcoder.chapter08.auto.loan.bart;

public class AutoLoan {

	private static final double UPPER_LIMIT = 100;
	private static final double BOTTOM_LIMIT = 0;
	private static final int SEARCH_LIMIT = 600;

	public double interestRate(double price, double monthlyPayment, int loanTerm) {

		double upper = UPPER_LIMIT;
		double bottom = BOTTOM_LIMIT;
		double middle = 0;

		for(int i=0; i<SEARCH_LIMIT; i++) {
			middle = (upper + bottom) / 2;
			double balance = price;

			for(int j=0; j<loanTerm; j++) {
				balance *= middle / 1200 + 1;
				balance -= monthlyPayment;
				//1E-10자리부터 계산값이 다름...??
				//balance = balance + (balance * middle / (12 * 100)) - monthlyPayment;
			}

			if(balance > 0) {
				upper = middle;
			}else {
				bottom = middle;
			}
		}

		return middle;
	}
}

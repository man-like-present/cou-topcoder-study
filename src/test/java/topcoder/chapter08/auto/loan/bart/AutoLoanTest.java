package topcoder.chapter08.auto.loan.bart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class AutoLoanTest {

	private AutoLoan autoLoan;

	@Before
	public void setUp() throws Exception {
		this.autoLoan = new AutoLoan();
	}

	//arena에서는 돌아가는데 뭐지?
	@Test
	public void autoLoan_case0() throws Exception {
		double expected = 1.3322616182218813E-13;

		double actual = autoLoan.interestRate(6800,68,100);

		Assert.assertThat(actual, is(expected));
	}

	@Test
	public void autoLoan_case1() throws Exception {
		double expected = 9.56205462458368;

		double actual = autoLoan.interestRate(2000,510,4);

		Assert.assertThat(actual, is(expected));
	}

	@Test
	public void autoLoan_case2() throws Exception {
		double expected = 7.687856394581649;

		double actual = autoLoan.interestRate(15000,364,48);

		Assert.assertThat(actual, is(expected));
	}

}
package topcoder.chapter05.cryptography.bro;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

import static org.junit.Assert.*;

/** * Created with Intellij IDEA_17.
 * User: Scenestealer / Team_Oslo
 * Date: 2017-06-18
 * Time: 오후 10:09
 * cou-topcoder-study
 * for
 */
public class CryptographyTest {

	private Cryptography cryptography = new Cryptography();

	@Test
	public void encrypt_example1() throws Exception {
		int [] testNumbers = {1, 2, 3};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == 12L);
	}

	@Test
	public void encrypt_example2() throws Exception {
		int [] testNumbers = {1, 3, 2, 1, 1, 3};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == 36L);
	}

	@Test
	public void encrypt_example3() throws Exception {
		int [] testNumbers = {1000, 999, 998, 997, 996, 995};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == 986074810223904000L);
	}

	@Test
	public void encrypt_example4() throws Exception {
		int [] testNumbers = {1, 1, 1, 1};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Example Result ##\n=> " + result);

		assertTrue(result == 2L);
	}

	@Test
	public void encrypt_test1() throws Exception {
		int [] testNumbers = {};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Test1 Result ##\n=> " + result);

		assertTrue(result == NumberUtils.LONG_ZERO);
	}

	@Test
	public void encrypt_test2() throws Exception {
		int [] testNumbers = {1001, 1002, 1003, 1000, 999, 998, 997, 996, 995};

		long result = cryptography.encrypt(testNumbers);
		System.out.println("## Test2 Result ##\n=> " + result);

		assertTrue(result == 986074810223904000L);
	}
}
package numberproblems;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestMultiplyWithoutOperator {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiply() {
		assertEquals("235 x 853 =", 200455, MultiplyWithoutOperator.multiply(235, 853));
	}

}

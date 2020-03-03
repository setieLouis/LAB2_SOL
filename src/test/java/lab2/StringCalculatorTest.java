package lab2;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class StringCalculatorTest {

	@Rule
  public Timeout globalTimeout = Timeout.seconds(2);

	Calculator calculator = null;

	@Before
	public void setUp(){
		calculator = new StringCalculator();
	}

	@Test
	public void onlyTestNumberTest(){
		assertThat(calculator.add("")).isEqualTo(0);
		assertThat(calculator.add("1,3")).isEqualTo(4);
		assertThat(calculator.add("3,2,0")).isEqualTo(5);
		assertThat(calculator.add("2,5,5")).isEqualTo(12);
	}

	@Test
	public void metaCharaterReturnTest(){
		assertThat(calculator.add("1\n2,3")).isEqualTo(6);
	}

	@Test
	public void generalMetaCharaterTest(){
		assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
		assertThat(calculator.add("//;\n1;2,3\n10")).isEqualTo(16);
	}



}

package it.unimi.di.se.lab03;

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

}

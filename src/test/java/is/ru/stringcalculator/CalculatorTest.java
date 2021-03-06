package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hamcrest.Matcher;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testALotOfNumbers(){
   		assertEquals(50, Calculator.add("10,10,10,10,10"));
    }

    @Test
    public void testAddUsingNewLine(){
   		assertEquals(10, Calculator.add("5\n3\n2"));
    }

    @Test
    public void testNegativeNumberAlone(){
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Negatives not allowed: -5");
    	Calculator.add("-5");
    }

    @Test
    public void testMultipleNegativeNumbers(){
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Negatives not allowed: -5,-2");
    	Calculator.add("-5\n3,-2");
    }

    @Test
    public void testNumbersAboveThousand(){
    	assertEquals(1005, Calculator.add("1000\n5,1001"));
    }

     @Test
    public void testSoloNumberAboveThousand(){
    	assertEquals(0, Calculator.add("1001"));
    }

    @Test
    public void testCustomDelimiter1Char(){
    	assertEquals(6, Calculator.add("// \n3 3"));
    }

    @Test
    public void testCustomDelimiterString(){
    	assertEquals(6, Calculator.add("//siggi\n3siggi3siggi3000"));
    }

}
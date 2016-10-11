package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(123, Calculator.add("123"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(46, Calculator.add("12,34"));
	}

	@Test
    public void testMultipleNumbers() {
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(36, Calculator.add("1,3,5,7,9,11"));
    }

    @Test
    public void testNewLine() {
    	assertEquals(6, Calculator.add("1\n2,3"));
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeNumbers() {
    	try
   		{
   			Calculator.add("2,-4,3,-5");
   		}
   		catch(IllegalArgumentException ex)
   		{
    		String message = "Negatives not allowed: -4,-5";
      		assertEquals(message, ex.getMessage());
      		throw ex;
    	}
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativeNumbers2() {
    	try
   		{
   			Calculator.add("//;\n1;-2");
   		}
   		catch(IllegalArgumentException ex)
   		{
    		String message = "Negatives not allowed: -2";
      		assertEquals(message, ex.getMessage());
      		throw ex;
    	}
    }

    @Test
    public void testLargeNumbers() {
    	assertEquals(2, Calculator.add("1001,2"));
    	assertEquals(1002, Calculator.add("1000,2"));
    }

    @Test
    public void testDifferentDelimiter() {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    	assertEquals(6, Calculator.add("//#\n1#2#3"));
    	assertEquals(9, Calculator.add("//Gunnar\n1Gunnar3Gunnar5"));
    }

}

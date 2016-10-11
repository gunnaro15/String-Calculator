package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) {
			return 0;
		}

		String[] numbers = text.split("[,\n]");

		if(text.contains("-")) {
			String neg = "Negatives not allowed: ";
			for(String number : numbers) {
				if(number.contains("-")) {
					neg += (number + ",");
				}
			}
			neg = neg.substring(0, neg.length()-1);
			throw new IllegalArgumentException(neg);
		}

		int total = 0;
		for(String number : numbers) {
			total += Integer.parseInt(number);
		}
		return total;
	}
}

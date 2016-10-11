package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) {
			return 0;
		}

		String del = "[,\n]";
		if(text.startsWith("//")) {
			del = text.split("\n")[0].substring(2);
			text = text.split("\n")[1];
		}

		String[] numbers = text.split(del);

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
			int num = Integer.parseInt(number);
			if(num <= 1000) total += num;
		}
		return total;
	}
}

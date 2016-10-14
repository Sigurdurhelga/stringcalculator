package is.ru.stringcalculator;

import java.lang.String;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else {
			text = text.replace("\n", ",");
			return sum(splitNumbers(text, ","));
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiter){
	    return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    int currentNumer;
 	    ArrayList<String> negativeNumbers = new ArrayList<String>();

        for(String number : numbers){
        	currentNumer = toInt(number);
        	if(currentNumer < 0) {
        		negativeNumbers.add(number);
        	}
        	if(currentNumer < 1001)
		    	total += currentNumer;
		}
		if(!negativeNumbers.isEmpty())
			throw new IllegalArgumentException("Negatives not allowed: " + String.join(",", negativeNumbers));
		return total;
    }



}
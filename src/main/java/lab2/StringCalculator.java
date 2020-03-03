package lab2;

import static java.util.Objects.isNull;

public class StringCalculator implements Calculator {
    @Override
    public int add(String expression) {
        if(isNull(expression) || expression.trim().length() == 0) return 0;
        String[] numbers = expression.split(",");
        int result = 0;
        for(String num: numbers) result += Integer.parseInt(num);
        return result;
    }
}

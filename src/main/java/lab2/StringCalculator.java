package lab2;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class StringCalculator implements Calculator {
    @Override
    public int add(String expression) {
        if(isNull(expression) || expression.trim().length() == 0)
            return 0;
        String separator = ",|\n";
        String numbers[];
        if(expression.substring(0,2).equals("//")){
            separator +="|" + expression.substring(2,3);
            numbers = expression.substring(expression.indexOf("\n") + 1).split(separator);
        }else{
            numbers = expression.split(separator);
        }

        int result = 0;
        for(String num: numbers) result += Integer.parseInt(num);
        return result;
    }
}

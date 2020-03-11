package lab2;

import static java.util.Objects.isNull;

public class StringCalculator implements Calculator {
    private String delimiter;

    public StringCalculator(){
        delimiter =  ",|\n";
    }

    private String addDelimiter(String expression){
        if(!expression.substring(0,2).equals("//"))
            return expression;
        delimiter +="|" + String.valueOf(expression.charAt(2));

        return expression.substring(4);
    }

    @Override
    public int add(String expression) {
        if(isNull(expression) || expression.trim().length() == 0)
            return 0;

        String numbers[] = addDelimiter(expression).split(delimiter);
        int result = 0;
        for(String num: numbers) result += Integer.parseInt(num);
        return result;
    }
}

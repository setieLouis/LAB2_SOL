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
        if(expression.charAt(2) == '[') delimiter += "|" + expression.substring(2, expression.indexOf('\n'));
        else delimiter +="|" + expression.charAt(2);
        return expression.substring(expression.indexOf('\n') + 1);
    }

    @Override
    public int add(String expression) {
        if(isNull(expression) || expression.trim().length() == 0)
            return 0;
        expression = addDelimiter(expression);
        String numbers[] = expression.split(delimiter);
        int result = 0;
        for(String num: numbers){
            if (num.isEmpty())
                continue;
            result +=  checkIllegalArgument(Integer.parseInt(num));
        }
        return result;
    }

    private Integer checkIllegalArgument(Integer num) {
        if(num < 0 )
            throw new IllegalArgumentException("I valori negativi non sono ammessi");
        else if (num > 1000)
            return 0;
        return num;
    }


}

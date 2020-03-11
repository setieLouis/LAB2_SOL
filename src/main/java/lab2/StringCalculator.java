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
        takeDelimiter(expression);
        return expression.substring(expression.indexOf('\n') + 1);
    }

    private void takeDelimiter(String expression) {
        if(expression.charAt(2) == '[') {
            String multipleSequence =  expression.substring(2, expression.indexOf('\n'));
            String tmpDelimiter = "";
            while(!multipleSequence.isEmpty()){
                tmpDelimiter += "|" + multipleSequence.substring(0, (multipleSequence.indexOf("]") + 1));
                multipleSequence = multipleSequence.substring(multipleSequence.indexOf("]") + 1);
            }
            delimiter += tmpDelimiter;
            return;
        }
        delimiter +="|" + expression.charAt(2);
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

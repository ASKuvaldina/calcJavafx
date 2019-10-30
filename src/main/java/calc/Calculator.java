package calc;

import java.util.ArrayList;

public class Calculator {
    private static String FirstStr = "0";
    private static String SecondStr = "";
    private static String Memory = "0";


    public static String getFirstStr() {
        return FirstStr;
    }

    public static String getSecondStr() {
        return SecondStr;
    }

    public static String getMemory() {
        return Memory;
    }

    public static String setFirstStr(String firstStr) {
        FirstStr = firstStr;
        return firstStr;
    }

    public static String setSecondStr(String secondStr) {
        SecondStr = secondStr;
        return secondStr;
    }

    public static void setMemory(String memory) {
        Memory = memory;
    }

    public static String Mplus() {
        float mem = ValueOf(getMemory()); //достать из памяти число
        float num1 = ValueOf(getFirstStr()); //достать из главной строки число
        return checkForDotNull("" + (mem + num1)); // вернуть сумму числа из памяти и числа из главной строки
    }

    public static String Mminus() {
        float mem = ValueOf(getMemory()); //достать из памяти число
        float num1 = ValueOf(getFirstStr()); //достать из главной строки число
        return checkForDotNull("" + (mem - num1)); // вернуть разность чисел из памяти и числа из главной строки
    }

    static String AddNum(char num) {
        String result = getFirstStr();
        if(result.length()<25) {
            if (result.equals("0")) {
                if (num == '.')
                    result = "0";
                else
                    result = "";
            }
            if (!(num == '.' && FirstStr.contains(".")))
                result = result + num;
        }
        return result;
    }

    public static String Backspace(){
        String result = getFirstStr();
        if(result==null || result.equals("")) //если результат на главной строке пустое место
            result = "0"; //присвоим значение результату 0
        if(result.length() == 1) //если результат имеет один символ
            result = "0";
        else result = result.substring(0, FirstStr.length() - 1); //вернем результат начиная с индекса 0 до индекса (длина строки - 1)
        return result;
    }



    static String SQRT() {
        float num1 = ValueOf(getFirstStr());
        float result;
        if(num1 < 0)
            result = num1;
        else
            result = (float)Math.sqrt(num1);
        return checkForDotNull("" + result);
    }

    static String Percent() {
        float num1 = ValueOf(getFirstStr());
        float result = num1/100;
        return checkForDotNull("" + result);
    }

    static String Result() {
        int len = getSecondStr().length();
        float num2 = ValueOf(getSecondStr().substring(0, len - 2));
        float num1 = ValueOf(getFirstStr());
        String operator = SecondStr.substring(len - 1, len);

        String temp = SecondStr;
        setSecondStr("");
        float result = 0f;

        if(operator.equals("+"))
            result = num2 + num1;
        if(operator.equals("-"))
            result = num2 - num1;
        if(operator.equals("*"))
            result = num2 * num1;
        if(operator.equals("/")) {
            if(num1 == 0) {
                result = 0;
                SecondStr = temp;
            } else
                result = num2 / num1;
        }
        return checkForDotNull("" + result);
    }

    //checking for insignificant commas and zeros;
    static String checkForDotNull(String str) {
        String res = str;
        if(res.length()>1 && res.substring(res.length()-2, res.length()).equals(".0")) {
            res = res.substring(0, res.length()-2);
        }
        return res;
    }

    //checking for extra commas;
    static float ValueOf(String s) {
        float result;
        try{
            char[] charArr = s.toCharArray();
            for(int i =0; i<charArr.length; i++) {
                if(charArr[i]==',')
                    charArr[i]='.';
            }
            result = Float.valueOf(new String(charArr));
        }catch(Exception ex) {
            result = 0;
        }
        return result;
    }
}
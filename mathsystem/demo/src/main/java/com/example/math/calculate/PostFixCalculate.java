package com.example.math.calculate;

import com.example.math.convertion.IConvertion;
import org.springframework.stereotype.Service;

@Service("PostFixCalculate")
public class PostFixCalculate  implements ICalculate<Integer, String> {

    @Override
    public Integer calculate(String expresion) {

        char[] stringToCharArray = expresion.toCharArray();
        boolean isNum = false;
        String s;
        int a = 0, b = 0;
        double total = 0.0;

        for(char c : stringToCharArray){
            s = String.valueOf(c);
            isNum = isNumeric(s);
            if(isNum && (a!=0)){
                a= Integer.valueOf(s);
            }else if(isNum && (b!=0)){
                b= Integer.valueOf(s);
            }else if(!isNum){
                switch (c){
                    case '+':
                        total += (a+b);
                        break;
                }
            }
        }

        return null;
    }

    public  boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}

package com.example.math.convertion;

import com.example.math.data.IOperatorData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Service("PostfixConvertion")
public class PostfixConvertion implements IConvertion<String, String>  {

    private Map<String, Integer> ops= new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
    }};
    private IOperatorData operatorData;

    public PostfixConvertion(@Qualifier("OperatorBean") IOperatorData operatorData) {
        this.operatorData = operatorData;
    }


    @Override
    public String convert(String infixExpresion) {
        StringBuilder output = new StringBuilder();
        // Se optienen nuevos operadores que se quieran agregar.
        Map<String, Integer> opsUpdate = (Map<String, Integer>) operatorData.getOperator();

        if(!opsUpdate.isEmpty()){
            setOps(opsUpdate);
        }

        if(ops.containsKey(infixExpresion.substring(0,1))){
            return null;
        }

        char[] stringToCharArray = infixExpresion.toCharArray();
        Deque<String> stackOperadores = new LinkedList<>();
        String r = "";
        String s;
        int i;

        for (char c : stringToCharArray) {
            s = String.valueOf(c);
            if (ops.containsKey(s)) {
                while( !stackOperadores.isEmpty() && nivelPrioridad(s,stackOperadores.peek()))
                    output.append(stackOperadores.pop());
                stackOperadores.push(s);
            } else {
                output.append(s);
            }
        }
        while (!stackOperadores.isEmpty())
            output.append(stackOperadores.pop());

        return output.toString();
    }

    public   Map<String, Integer> getOps() {
        return ops;
    }
    public void setOps(Map<String, Integer> ops) {
        this.ops = ops;
    }
    public  boolean nivelPrioridad(String op, String sub)
    {
        return (ops.containsKey(sub) && ops.get(sub).intValue() >= ops.get(op).intValue());
    }



}

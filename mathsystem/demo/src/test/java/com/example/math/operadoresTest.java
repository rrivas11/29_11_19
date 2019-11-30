package com.example.math;

import com.example.math.convertion.PostfixConvertion;
import com.example.math.data.OperatorDB;
import com.example.math.pojos.svc.ResquestPostfix;
import com.example.math.process.CalculateProcess;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.mockito.Mockito.*;


public class operadoresTest {

    @Test
    public void DivMayorSumCase()  {

        PostfixConvertion postfixCalculate = new PostfixConvertion(mock(OperatorDB.class));
        boolean b =  postfixCalculate.nivelPrioridad("+", "/");
        Assert.assertTrue(b);

    }

    @Test
    public void MulMayorDivCase()  {

        PostfixConvertion postfixCalculate = new PostfixConvertion(mock(OperatorDB.class));
        boolean b =  postfixCalculate.nivelPrioridad("/", "*");
        Assert.assertFalse(b);

    }

    @Test
    public void SuccessCase(){
        OperatorDB operatorData = mock(OperatorDB.class);
        PostfixConvertion postfixCalculate = new PostfixConvertion(mock(OperatorDB.class));
        when(operatorData.getOperator()).thenReturn(new HashMap<>());
        String result = postfixCalculate.convert("1+2.5/3*4");

        Assert.assertEquals(result,"12.53/4*+");

    }

    @Test
    public void BadRequestTest(){
        OperatorDB operatorData = mock(OperatorDB.class);
        PostfixConvertion postfixConvertion = new PostfixConvertion(operatorData);
        ResquestPostfix resquestPostfix = new ResquestPostfix();
        CalculateProcess calculateProcess =  new CalculateProcess(postfixConvertion);

        when(operatorData.getOperator()).thenReturn(new HashMap<>());
        resquestPostfix.setInfix("-2+3-4");
        ResponseEntity<?> entity = calculateProcess.process(resquestPostfix);

        Assert.assertEquals(HttpStatus.BAD_REQUEST,entity.getStatusCode());

    }

}

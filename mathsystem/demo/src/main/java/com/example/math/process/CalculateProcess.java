package com.example.math.process;

import com.example.math.build.ResponseBuilder;
import com.example.math.convertion.IConvertion;
import com.example.math.pojos.svc.ResponsePostfix;
import com.example.math.pojos.svc.ResquestPostfix;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// Clase encargada de llevar proceso del negocio.

@Service("ConvertProcess")
public class CalculateProcess implements IProcess<ResquestPostfix> {
    private IConvertion postfixConvertion;


    public CalculateProcess(@Qualifier("BeanPostfixConvertion") IConvertion PostfixConvertion) {
        this.postfixConvertion = PostfixConvertion;
    }

    @Override
    public ResponseEntity<?> process(ResquestPostfix request) {
        ResponsePostfix responsePostfix = new ResponsePostfix();
        // Constructor de respuesta del servicio.
        ResponseBuilder responseBuilder = new ResponseBuilder(request.getInfix());
        HttpStatus code;

        String result = (String) postfixConvertion.convert(request.getInfix());

        if(result != null ) {
            responsePostfix = responseBuilder
                    .whitpPostfix(result)
                    .build();

            code = HttpStatus.OK;
        }else{
            responsePostfix = responseBuilder
                    .whitMessage("The Expression {"+ request.getInfix()+"}  is invalid")
                    .build();
            code = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responsePostfix, code) ;
    }
}

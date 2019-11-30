package com.example.math.controller;

import com.example.math.pojos.svc.ResquestPostfix;
import com.example.math.process.IProcess;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*  Autor: Ricardo Salvador Rivas Franco
    Descripcion: Interprete de expresiones matematicas.
    Funciones: transaforma una expresion infija a postfija
*/

@RestController
@PropertySource("classpath:application.properties")
@RequestMapping("${service.url.mathsrv}")
public class Controller {
    private Logger log;
    private IProcess process;

    public Controller(@Qualifier("BeanConvertProcess") IProcess process) {
        this.log = LoggerFactory.getLogger(getClass());
        this.process = process;
    }

    //Endpoint para obtener la notación posfija de notacion infija
    @PostMapping("${app-properties.controller.postfix}")
    public ResponseEntity<?> getProducts(@RequestBody ResquestPostfix request) {
        try {
            return process.process(request);
        }catch (Exception e){
            log.error("Hubo un error en getProducts, en la línea {} en el método {}, detalle del error {}",e.getStackTrace()[0].getLineNumber(),e.getStackTrace()[0].getMethodName(),e);
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

    }




}

package com.example.math.process;

import org.springframework.http.ResponseEntity;

public interface IProcess<H>  {

    public ResponseEntity<?> process(H object);


}

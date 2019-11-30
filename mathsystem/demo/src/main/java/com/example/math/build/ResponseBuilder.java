package com.example.math.build;

import com.example.math.pojos.svc.ResponsePostfix;

public class ResponseBuilder implements IBuilder<ResponsePostfix> {

    private String infix;
    private String postfix;
    private String message;
    private Integer result;
    private ResponsePostfix responsePostfix;

    public ResponseBuilder(String infix) {
        this.infix = infix;
    }

    public ResponseBuilder whitpPostfix(String postfix){
        this.postfix = postfix;
        return  this;
    }
    public ResponseBuilder whitMessage(String message){
        this.message = message;
        return  this;
    }
    public ResponseBuilder whitResult(Integer result){
        this.result = result;
        return  this;
    }


    @Override
    public ResponsePostfix build() {
        ResponsePostfix responsePostfix = new ResponsePostfix();
        responsePostfix.setInfix(this.infix);
        responsePostfix.setPostfix(this.postfix);
        responsePostfix.setMessage(this.message);
        responsePostfix.setResult(this.result);
        return responsePostfix;
    }
}

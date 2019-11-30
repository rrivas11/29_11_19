package com.example.math.data;

import com.example.math.pojos.database.MathOperator;
import com.example.math.repository.IOperatorRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("OperatorDB")
public class OperatorDB implements IOperatorData<Map<String, Integer>> {

    IOperatorRepository repository;

    public OperatorDB(IOperatorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Integer> getOperator() {
        Map<String, Integer> ops =  new HashMap<>();
        try {
            // Funcion que se conecta a base de datos para obtener nuevos operandos.
            Iterable<MathOperator> operators = repository.findAll();
            for(MathOperator mathOperator : operators){
                ops.put(mathOperator.getOperador().toString(),mathOperator.getValor());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ops;
    }
}

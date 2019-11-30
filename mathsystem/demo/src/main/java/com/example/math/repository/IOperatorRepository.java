package com.example.math.repository;

import com.example.math.pojos.database.MathOperator;
import org.springframework.data.repository.CrudRepository;

public interface IOperatorRepository extends CrudRepository<MathOperator, String> {
}

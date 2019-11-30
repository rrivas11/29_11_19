package com.example.math.pojos.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="math_operator"
    ,schema="math_svc"
)
public class MathOperator  implements java.io.Serializable {

     private String id;
     private Character operador;
     private Integer valor;

    public MathOperator() {
    }

	
    public MathOperator(String id) {
        this.id = id;
    }
    public MathOperator(String id, Character operador, Integer valor) {
       this.id = id;
       this.operador = operador;
       this.valor = valor;
    }
   
     @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="operador", length=1)
    public Character getOperador() {
        return this.operador;
    }
    
    public void setOperador(Character operador) {
        this.operador = operador;
    }

    
    @Column(name="valor")
    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }




}



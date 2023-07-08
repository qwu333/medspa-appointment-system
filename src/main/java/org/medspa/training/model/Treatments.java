package org.medspa.training.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "treatments")
public class Treatments {
    public Treatments(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "treatment_name")
    private String name;

    @Column(name = "treatment_cost")
    private BigDecimal cost;

    @Column(name = "treatment_price")
    private BigDecimal price;

    @Column(name = "treatment_length")
    private int length;

    @Column(name = "treatment_target")
    private String target;

    @Column(name = "nurses")
    private String nurses;


    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCost(BigDecimal cost){
        this.cost = cost;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public void setNurses(String nurses){
        this.nurses = nurses;
    }


}

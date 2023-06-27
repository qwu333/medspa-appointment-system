package org.medspa.training.model;
import javax.persistence.*;

@Entity
@Table(name = "Treatments")
public class Treatments {
    public Treatments(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Treatment_Name")
    private String name;

    @Column(name = "Treatment_Cost")
    private float cost;

    @Column(name = "Treatment_Price")
    private float price;

    @Column(name = "Treatment_Length")
    private int length;

    @Column(name = "Treatment_Target")
    private String target;

    @Column(name = "Nurses")
    private String nurses;


    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCost(float cost){
        this.cost = cost;
    }
    public void setPrice(float price){
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

package org.medspa.training.model;

public class Treatments {
    public Treatments(){}

    private long id;
    private String name;
    private Float cost;
    private Float price;
    private int length;
    private String target;
    private String nurses;

    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCost(Float cost){
        this.cost = cost;
    }
    public void setPrice(Float price){
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

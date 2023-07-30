package org.medspa.training.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "treatments")
public class Treatments {
    public Treatments(){}

    public Treatments(long id, String treatmentName, BigDecimal cost, BigDecimal price, int length, String target, String nurses){
        this.id = id;
        this.treatmentName = treatmentName;
        this.cost = cost;
        this.price = price;
        this.length = length;
        this.target = target;
        this.nurses = nurses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "treatment_name")
    private String treatmentName;

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

    @OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Appointments> appointments;


    public void setId(long id){
        this.id = id;
    }
    public void setTreatmentName(String treatmentName){
        this.treatmentName = treatmentName;
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

    public long getId() {
        return id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getLength() {
        return length;
    }

    public String getTarget() {
        return target;
    }

    public String getNurses() {
        return nurses;
    }

    public Set<Appointments> getAppointments() {
        return appointments;
    }
}

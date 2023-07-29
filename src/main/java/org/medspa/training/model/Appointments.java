package org.medspa.training.model;
import javax.persistence.*;
import javax.persistence.ManyToOne;


import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "appointments")
public class Appointments {
    public Appointments(){}
    public Appointments(Date date, Time time){
        this.date = date;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "treatment")
    private Treatments treatment;

    @ManyToOne
    @JoinColumn(name = "client")
    private Clients client;

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public void setTime(Time time){
        this.time = time;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
    public void setTreatment(Treatments treatment){
        this.treatment = treatment;
    }

    public Clients getClient(long client) {
        return this.client;
    }
    public Treatments getTreatment(long treatment){
        return this.treatment;
    }
}

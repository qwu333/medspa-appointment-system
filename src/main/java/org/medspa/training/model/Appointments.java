package org.medspa.training.model;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "appointments")
public class Appointments {
    public Appointments(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "treatment")
    private long treatment;

    public void setId(long id){
        this.id = id;
    }
    public void setClientId(long id){
        this.clientId = clientId;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setTime(Time time){
        this.time = time;
    }
    public void setTreatment(long treatment){
        this.treatment = treatment;
    }

}

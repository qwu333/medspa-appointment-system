package org.medspa.training.model;
import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {
    public Clients(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "targets")
    private String targets;



    public void setId(long id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber (int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setAllergies (String allergies){
        this.allergies = allergies;
    }
    public void setTargets(String targets){
        this.targets = targets;
    }

    }




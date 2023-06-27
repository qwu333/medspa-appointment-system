package org.medspa.training.model;
import javax.persistence.*;

@Entity
@Table(name = "Clients")
public class Clients {
    public Clients(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Phone_Number")
    private int phoneNumber;

    @Column(name = "Email_Address")
    private String emailAddress;

    @Column(name = "Allergies")
    private String allergies;

    @Column(name = "Targets")
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




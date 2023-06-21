package org.medspa.training.model;
import java.util.ArrayList;
import java.util.List;
public class Clients {
    public Clients(){}
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailAddress;
    private String allergies;
    private String targets;
    private String nursePreferences;

    public void setId(long id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber (long phoneNumber){
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
    public void setNursePreferences(String nursePreferences){
        this.nursePreferences=nursePreferences;
    }
}

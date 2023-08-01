package org.medspa.training.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Clients {
    public Clients() {
    }

    public Clients(long id, String firstName, String lastName, String phoneNumber, String emailAddress, String allergies, String targets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.allergies = allergies;
        this.targets = targets;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "targets")
    private String targets;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointments> appointments;


    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getTargets() {
        return targets;
    }

    public Set<Appointments> getAppointments() {
        return appointments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, emailAddress, allergies, targets);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Clients client = (Clients) o;
        return  id == client.id &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName,client.lastName) &&
                Objects.equals(phoneNumber,client.phoneNumber) &&
                Objects.equals(emailAddress, client.emailAddress) &&
                Objects.equals(allergies,client.allergies) &&
                Objects.equals(targets, client.targets);
    }
}





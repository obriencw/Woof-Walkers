package com.woofWalkers.models;

import com.woofWalkers.userRegistrationSecurity.User;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

// Appointment model for creating table columns in database
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private String appointmentDate;

    @Column(name = "time")
    private String appointmentTime;

    @ManyToMany
    @JoinColumn(name = "dogId")
    Set<Dog> dogs;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private User user;

    public Appointment() {
    }

    // constructor for Appointment model
    public Appointment(long id, String appointmentDate, String appointmentTime, Set<Dog> dogs, String comments, User user) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.dogs = dogs;
        this.comments = comments;
        this.user = user;
    }

    // getters and setters for Appointment model
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // method used for testing whether an appointment is added to the table in database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return id == appointment.id && Objects.equals(appointmentDate, appointment.appointmentDate) && Objects.equals(appointmentTime, appointment.appointmentTime);
    }

    // method used for testing whether an appointment is in the table
    @Override
    public int hashCode() {return Objects.hash(id, appointmentDate, appointmentTime); }
}

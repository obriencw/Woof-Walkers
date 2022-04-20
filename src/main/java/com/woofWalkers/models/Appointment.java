package com.woofWalkers.models;

import com.woofWalkers.userRegistrationSecurity.User;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;

    @Column(name = "date")
    private String appointmentDate;

    @Column(name = "time")
    private String appointmentTime;

    @ManyToOne
    @JoinColumn(name = "dogId")
    private Dog dog;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private User user;

    public Appointment() {
    }

    public Appointment(Long id, String appointmentDate, String appointmentTime, Dog dog, User user, String comments) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.dog = dog;
        this.user = user;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

package com.example.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "order_")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(insertable = false,updatable = false)
    private int car_id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_id")
    private Car car;

    /*@JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "car_id")
    private Car car;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = Timestamp.valueOf(startTime);
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = Timestamp.valueOf(endTime);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

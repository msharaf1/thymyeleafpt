package com.msx.thymyeleafpt.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, max=255, message = "Please type a valid firstName")
    private String firstName;
    @Size(min=1, max=255, message = "Please type a valid latName")
    private String lastName;

    @Min(1)
    private int age;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Ninja(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Dojo getDojo() {
        return dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }
}

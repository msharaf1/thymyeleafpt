package com.msx.thymyeleafpt.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dojo")
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, max=255, message = "Can not be blank")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjaList;



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
    public Dojo(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ninja> getNinjaList() {
        return ninjaList;
    }

    public void setNinjaList(List<Ninja> ninjaList) {
        this.ninjaList = ninjaList;
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
}

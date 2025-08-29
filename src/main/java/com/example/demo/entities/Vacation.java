package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions = new HashSet<>();

    public Vacation() {}

    public Vacation(long id, String vacation_title, String description,
                    BigDecimal travel_price, String image_URL, Date create_date,
                    Date last_update, Set<Excursion> excursions) {
        this.id = id;
        this.vacation_title = vacation_title;
        this.description = description;
        this.travel_price = travel_price;
        this.image_URL = image_URL;
        this.create_date = create_date;
        this.last_update = last_update;
        this.excursions = excursions;
    }

    public Vacation(String vacation_title, String description,
                    BigDecimal travel_price, String image_URL, Date create_date,
                    Date last_update, Set<Excursion> excursions) {
        this.vacation_title = vacation_title;
        this.description = description;
        this.travel_price = travel_price;
        this.image_URL = image_URL;
        this.create_date = create_date;
        this.last_update = last_update;
        this.excursions = excursions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVacation_title() {
        return vacation_title;
    }

    public void setVacation_title(String vacation_title) {
        this.vacation_title = vacation_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTravel_price() {
        return travel_price;
    }

    public void setTravel_price(BigDecimal travel_price) {
        this.travel_price = travel_price;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }


}

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
@Table(name = "excursions")
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private long id;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartitems = new HashSet<>();

    public Excursion() {}

    public Excursion(long id, String excursion_title, BigDecimal excursion_price,
                     String image_URL, Date create_date, Date last_update,
                     Vacation vacation, Set<CartItem> cartItems) {
        this.id = id;
        this.excursion_title = excursion_title;
        this.excursion_price = excursion_price;
        this.image_URL = image_URL;
        this.create_date = create_date;
        this.last_update = last_update;
        this.vacation = vacation;
        this.cartitems = cartItems;
    }

    public Excursion(String excursion_title, BigDecimal excursion_price,
                     String image_URL, Date create_date, Date last_update,
                     Vacation vacation, Set<CartItem> cartItems) {
        this.excursion_title = excursion_title;
        this.excursion_price = excursion_price;
        this.image_URL = image_URL;
        this.create_date = create_date;
        this.last_update = last_update;
        this.vacation = vacation;
        this.cartitems = cartItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExcursion_title() {
        return excursion_title;
    }

    public void setExcursion_title(String excursion_title) {
        this.excursion_title = excursion_title;
    }

    public BigDecimal getExcursion_price() {
        return excursion_price;
    }

    public void setExcursion_price(BigDecimal excursion_price) {
        this.excursion_price = excursion_price;
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

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Set<CartItem> getCartitems() {
        return cartitems;
    }

    public void setCartitems(Set<CartItem> cartitems) {
        this.cartitems = cartitems;
    }


}

package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem", joinColumns = {@JoinColumn(name = "cart_item_id")}, inverseJoinColumns = {@JoinColumn(name = "excursion_id")})
    private Set<Excursion> excursions = new HashSet<>();

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    public CartItem() {}

    public CartItem(long id, Vacation vacation, Cart cart, Set<Excursion> excursion, Date create_date, Date last_update) {
        this.id = id;
        this.vacation = vacation;
        this.cart = cart;
        this.excursions = excursion;
        this.create_date = create_date;
        this.last_update = last_update;
    }

    public CartItem(Vacation vacation, Cart cart, Set<Excursion> excursion, Date create_date, Date last_update) {
        this.vacation = vacation;
        this.cart = cart;
        this.excursions = excursion;
        this.create_date = create_date;
        this.last_update = last_update;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

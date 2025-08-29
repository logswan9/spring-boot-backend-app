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
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "status", nullable = false, insertable = false, updatable = false)
    private StatusType status;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>();

    public Cart(){}

    public Cart(long id, String orderTrackingNumber, BigDecimal package_price, int party_size,
                StatusType status, Date create_date, Date last_update, Customer customer,
                Set<CartItem> cartItems) {
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.package_price = package_price;
        this.party_size = party_size;
        this.status = status;
        this.create_date = create_date;
        this.last_update = last_update;
        this.customer = customer;
        this.cartItem = cartItems;
    }

    public Cart(String orderTrackingNumber, BigDecimal package_price, int party_size,
                StatusType status, Date create_date, Date last_update, Customer customer,
                Set<CartItem> cartItems) {
        this.orderTrackingNumber = orderTrackingNumber;
        this.package_price = package_price;
        this.party_size = party_size;
        this.status = status;
        this.create_date = create_date;
        this.last_update = last_update;
        this.customer = customer;
        this.cartItem = cartItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public BigDecimal getPackage_price() {
        return package_price;
    }

    public void setPackage_price(BigDecimal package_price) {
        this.package_price = package_price;
    }

    public int getParty_size() {
        return party_size;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

}

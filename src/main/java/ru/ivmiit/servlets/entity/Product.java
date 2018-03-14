package ru.ivmiit.servlets.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "NAME")
    private String name;
    @Column (name = "COUNT")
    private int count;
    @Column (name = "PRICE")
    private double price;

    public Product() {
    }

    public Product(String name, int count, double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

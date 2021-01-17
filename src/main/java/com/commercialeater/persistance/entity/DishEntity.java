package com.commercialeater.persistance.entity;

import com.commercialeater.models.Diet;
import com.commercialeater.models.DishType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "dishes")
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DishType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Diet diet;

    @ManyToOne
    private RestaurantEntity restaurant;

    public DishEntity() {
    }

    public DishEntity(String name, String description, BigDecimal price, DishType type, Diet diet) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.diet = diet;
    }

    public DishEntity(String name, String description, BigDecimal price, DishType type, Diet diet, RestaurantEntity restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.diet = diet;
        this.restaurant = restaurant;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
}

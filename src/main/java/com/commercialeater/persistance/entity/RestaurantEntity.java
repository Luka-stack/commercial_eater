package com.commercialeater.persistance.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE)
    //@JoinColumn(name = "restaurant_id")
    private Set<DishEntity> dishes;

    public RestaurantEntity() {}

    public RestaurantEntity(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<DishEntity> getDishes() {
        return dishes;
    }

    public void setDishes(Set<DishEntity> dishes) {
        this.dishes = dishes;
    }
}

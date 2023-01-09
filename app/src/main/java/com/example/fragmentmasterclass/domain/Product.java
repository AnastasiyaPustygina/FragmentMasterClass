package com.example.fragmentmasterclass.domain;

import android.graphics.drawable.Drawable;

public class Product {

    private final int id;
    private final String name;
    private final String description;
    private final int cost;
    private final Drawable image;

    public Product(int id, String name, int cost, Drawable image) {
        this.id = id;
        this.name = name;
        description = "descriptionDefault";
        this.cost = cost;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Drawable getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}

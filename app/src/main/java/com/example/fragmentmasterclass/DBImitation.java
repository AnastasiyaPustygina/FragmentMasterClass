package com.example.fragmentmasterclass;

import android.util.Log;

import com.example.fragmentmasterclass.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class DBImitation {
    public static List<Product> allProducts;
    public static List<Product> basket = new ArrayList<>();

    public static void setAllProducts(List<Product> allProducts) {
        DBImitation.allProducts = allProducts;
    }

    public static List<Product> getAllProducts() {
        return allProducts;
    }

    public static List<Product> getBasket() {
        return basket;
    }

    public static Product findById(int id){
        for (Product p: allProducts) {
            if(id == p.getId()) return p;
        }
        return null;
    }

    public static void addToBasket(Product product){
        basket.add(product);
    }

}

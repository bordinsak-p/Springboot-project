package com.basic.resful.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="food_menu")
public class FoodMenuBean {
    @Id
    @SequenceGenerator(name = "FoodMenuSesqence", sequenceName = "FoodMenu_id_seq", allocationSize = 1, initialValue = 15)
    @GeneratedValue(generator = "FoodMenuSesqence")
    private Integer id;

    @Column(name = "foodName", length = 100)
    private String foodName;
    
    @Column(name = "price", length = 10)
    private Double price;
    
    @Column(name = "image", length = 255)
    private String image;
}

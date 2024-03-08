package com.basic.resful.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @SequenceGenerator(name = "OrderSesqence", sequenceName = "Order_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "OrderSesqence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "food_menu_id", referencedColumnName = "id")
    private FoodMenu foodMenu;
    
    @ManyToOne
    @JoinColumn(name = "table_food_id", referencedColumnName = "id")
    private TableFood tableFood;

    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "status")
    private String status;
     
    @Column(name = "quantity")
    private Integer quantity;
    
    @Column(name = "total_price")
    private Double totalprice;


}

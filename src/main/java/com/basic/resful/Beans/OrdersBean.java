package com.basic.resful.Beans;

import java.util.Date;

import com.basic.resful.entity.FoodMenu;
import com.basic.resful.entity.TableFood;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersBean {
    FoodMenu foodMenu;
    TableFood tableFood;
    Date createdAt;
    String status;
    Integer quantity;
    Double totalprice;
}

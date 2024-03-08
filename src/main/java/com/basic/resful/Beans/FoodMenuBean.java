package com.basic.resful.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenuBean {
    private Integer id;
    private String foodName;
    private Double price;
    private String image;
}

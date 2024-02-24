package com.basic.resful.controller;

import com.basic.resful.entity.FoodMenuBean;
import com.basic.resful.services.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/foodmenu")
public class FoodMenuControllder {
    @Autowired
    private FoodMenuService foodMenuService;

    @GetMapping
    public List<FoodMenuBean> getAllFoodMenu() {
        return foodMenuService.getAllFoodMenu();
    }

    @GetMapping("/{id}")
    public FoodMenuBean getProductById(@PathVariable Integer id) {
        return foodMenuService.getFoodMenuById(id);
    }

    @PostMapping
    public FoodMenuBean createFoodMenu(@RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("foodName") String foodName, @RequestParam("price") double price) {
        return foodMenuService.createFoodMenu(foodName, price, imageFile);
    }

    @PutMapping("/{id}")
    public FoodMenuBean updateFoodMenu(@PathVariable Integer id,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("foodName") String foodName,
            @RequestParam("price") double price) {
        return foodMenuService.updateFoodMenu(id, foodName, price, imageFile);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodMenu(@PathVariable Integer id) {
        foodMenuService.deleteFoodMenu(id);
    }
}

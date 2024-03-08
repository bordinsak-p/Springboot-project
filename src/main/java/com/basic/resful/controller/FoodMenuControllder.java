package com.basic.resful.controller;

import com.basic.resful.entity.FoodMenu;
import com.basic.resful.services.FoodMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/foodmenu")
public class FoodMenuControllder {
    @Autowired
    private FoodMenuService foodMenuService;

    @GetMapping
    public List<FoodMenu> getAllFoodMenu() {
        return foodMenuService.getAllFoodMenu();
    }

    @GetMapping("/{id}")
    public FoodMenu getProductById(@PathVariable Integer id) {
        return foodMenuService.getFoodMenuById(id);
    }

    @PostMapping
    public FoodMenu createFoodMenu(@RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("foodName") String foodName, @RequestParam("price") double price) {
        return foodMenuService.createFoodMenu(foodName, price, imageFile);
    }

    @PutMapping("/{id}")
    public FoodMenu updateFoodMenu(@PathVariable Integer id,
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

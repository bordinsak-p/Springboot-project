package com.basic.resful.controller;

import com.basic.resful.Beans.FoodMenuBean;
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
    public FoodMenu createFoodMenu(FoodMenuBean foodMenuBean, @RequestParam("imageFile") MultipartFile imageFile) {
        return foodMenuService.createFoodMenu(foodMenuBean, imageFile);
    }

    @PutMapping
    public FoodMenu updateFoodMenu(FoodMenuBean foodMenuBean, @RequestParam("imageFile") MultipartFile imageFile) {
        return foodMenuService.updateFoodMenu(foodMenuBean, imageFile);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodMenu(@PathVariable Integer id) {
        foodMenuService.deleteFoodMenu(id);
    }
}

package com.basic.resful.services;

import com.basic.resful.entity.FoodMenuBean;
import com.basic.resful.repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FoodMenuService {
    @Autowired
    FoodMenuRepository foodMenuRepository;

    public List<FoodMenuBean> getAllFoodMenu() {
        return foodMenuRepository.findAll();
    }

    public FoodMenuBean getFoodMenuById(Integer id) {
        return foodMenuRepository.findById(id).orElse(null);
    }

    public FoodMenuBean createFoodMenu(String foodName, double price, MultipartFile imageFile) {
        FoodMenuBean newFoodMenu = new FoodMenuBean();

        newFoodMenu.setFoodName(foodName);
        newFoodMenu.setPrice(price);
    
        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String dir = "src/main/resources/uploads/";
                String fileName = imageFile.getOriginalFilename().replaceAll("\\s", "");
                Path filePath = Paths.get(dir, fileName);
                Files.write(filePath, imageFile.getBytes());
    
                newFoodMenu.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // insert to db
        return foodMenuRepository.save(newFoodMenu);
    }
    
    public FoodMenuBean updateFoodMenu(Integer id, String foodName, double price, MultipartFile imageFile) {
        // query data from db
        FoodMenuBean foodMenuQuery = foodMenuRepository.findById(id).orElse(null);

        if (foodMenuQuery != null) {

            foodMenuQuery.setFoodName(foodName);
            foodMenuQuery.setPrice(price);
    
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    String dir = "src/main/resources/uploads/";
                    String fileName = imageFile.getOriginalFilename().replaceAll("\\s", "");
                    Path filePath = Paths.get(dir, fileName);
                    Files.write(filePath, imageFile.getBytes());
    
                    foodMenuQuery.setImage(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // insert new data to db
            return foodMenuRepository.save(foodMenuQuery);
        }
        return null;
    }
    

    public void deleteFoodMenu(Integer id) {
        foodMenuRepository.deleteById(id);
    }

}

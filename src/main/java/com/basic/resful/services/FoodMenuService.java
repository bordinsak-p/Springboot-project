package com.basic.resful.services;

import com.basic.resful.Beans.FoodMenuBean;
import com.basic.resful.entity.FoodMenu;
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

    public List<FoodMenu> getAllFoodMenu() {
        return foodMenuRepository.findAll();
    }

    // insert
    public FoodMenu getFoodMenuById(Integer id) {
        return foodMenuRepository.findById(id).orElse(null);
    }

    public FoodMenu createFoodMenu(FoodMenuBean foodMenuBean, MultipartFile imageFile) {
        FoodMenu newFoodMenu = new FoodMenu();

        newFoodMenu.setFoodName(foodMenuBean.getFoodName());
        newFoodMenu.setPrice(foodMenuBean.getPrice());
    
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

    // update
    public FoodMenu updateFoodMenu(FoodMenuBean foodMenuBean, MultipartFile imageFile) {
        // query data from db
        int foodMenuId = foodMenuBean.getId();
        FoodMenu foodMenuQuery = foodMenuRepository.findById(foodMenuId).orElse(null);

        if (foodMenuQuery != null) {

            foodMenuQuery.setFoodName(foodMenuBean.getFoodName());
            foodMenuQuery.setPrice(foodMenuBean.getPrice());
    
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
    
    //delete 
    public void deleteFoodMenu(Integer id) {
        try {
            foodMenuRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

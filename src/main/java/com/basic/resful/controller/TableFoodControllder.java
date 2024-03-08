package com.basic.resful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.basic.resful.Beans.TableBean;
import com.basic.resful.entity.TableFood;
import com.basic.resful.services.TableFoodService;

@RestController
@RequestMapping("/table")
public class TableFoodControllder {
    @Autowired
    TableFoodService tableFoodService;

    @GetMapping
    public List<TableFood> getAllTableFoods() {
        return tableFoodService.getAllTable();
    }

    @PostMapping
    public TableFood createTableFood(@RequestBody TableBean tableBean) {
        return tableFoodService.createTableFood(tableBean);
    }

    @DeleteMapping("/{id}")
    public void deleteTableById(@PathVariable Integer id) {
         tableFoodService.deleteTableById(id);
    }
}

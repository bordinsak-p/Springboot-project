package com.basic.resful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.resful.Beans.TableBean;
import com.basic.resful.entity.TableFood;
import com.basic.resful.repository.TableFoodRepository;

@Service
public class TableFoodService {
    @Autowired
    TableFoodRepository tableFoodRepository;

    public List<TableFood> getAllTable() {
        return tableFoodRepository.findAll();
    }

    public TableFood createTableFood(TableBean tableBean) {
        TableFood tableFood = new TableFood();

        try {
            tableFood.setTableCode(tableBean.getTableCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tableFoodRepository.save(tableFood);
    }

    public void deleteTableById(Integer tableId) {
        try {
            tableFoodRepository.deleteById(tableId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

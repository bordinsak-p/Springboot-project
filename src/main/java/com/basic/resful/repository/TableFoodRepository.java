package com.basic.resful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.resful.entity.TableFood;

public interface TableFoodRepository  extends JpaRepository<TableFood, Integer>{
} 
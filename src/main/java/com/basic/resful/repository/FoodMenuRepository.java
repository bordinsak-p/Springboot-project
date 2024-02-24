package com.basic.resful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.resful.entity.FoodMenuBean;

public interface FoodMenuRepository extends JpaRepository<FoodMenuBean, Integer> {
}

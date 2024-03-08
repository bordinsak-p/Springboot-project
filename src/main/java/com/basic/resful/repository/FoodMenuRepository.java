package com.basic.resful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.resful.entity.FoodMenu;

public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {
}

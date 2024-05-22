package com.formacionbdi.springboot.app.test.car.controller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.springboot.app.test.car.controller.model.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long>{

}

package com.formacionbdi.springboot.app.test.car.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.springboot.app.test.car.model.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long>{

}

package com.formacionbdi.springboot.app.test.car.dto;

import com.formacionbdi.springboot.app.test.car.controller.model.CarEntity;

public class CarDto {

	private Long id;
	private String nombre;
	private Double precio;
	
	public CarDto() {}
	
	public CarDto(Long id, String nombre, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return nombre;
	}
	public void setName(String name) {
		this.nombre = name;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public CarDto EntityToDto(CarEntity entity) {
		return new CarDto(entity.getId(), entity.getName(), entity.getPrecio());
	}
}

package com.formacionbdi.springboot.app.test.concessionarie.dto;

import java.util.List;

import com.formacionbdi.springboot.app.test.concessionarie.controller.model.ConcessionarieEntity;

public class ConcessionarieWithCarsDto {

	private Long id;
	private String nombre;
	private List<CarDto> vehiculos;
	
	public ConcessionarieWithCarsDto(Long id, String nombre, List<CarDto> car) {
		this.id = id;
		this.nombre = nombre;
		this.vehiculos = car;
	}
	
	public ConcessionarieWithCarsDto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<CarDto> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<CarDto> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public ConcessionarieWithCarsDto EntityToDto(ConcessionarieEntity entity, List<CarDto> vehicles) {
		return new ConcessionarieWithCarsDto(entity.getId(), entity.getNombre(), vehicles);
	}

}

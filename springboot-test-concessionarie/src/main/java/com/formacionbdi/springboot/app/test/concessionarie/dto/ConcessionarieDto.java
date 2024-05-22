package com.formacionbdi.springboot.app.test.concessionarie.dto;

import com.formacionbdi.springboot.app.test.concessionarie.controller.model.ConcessionarieEntity;

public class ConcessionarieDto {

	private Long id;
	private String nombre;
	
	public ConcessionarieDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public ConcessionarieDto() {}
	
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
	
	public ConcessionarieDto EntityToDto(ConcessionarieEntity entity) {
		return new ConcessionarieDto(entity.getId(), entity.getNombre());
	}
}

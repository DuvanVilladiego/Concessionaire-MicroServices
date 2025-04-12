package com.formacionbdi.springboot.app.test.concessionarie.dto;

import com.formacionbdi.springboot.app.test.concessionarie.model.ConcessionarieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionarieDto {

	private Long id;
	private String nombre;
		
	public ConcessionarieDto EntityToDto(ConcessionarieEntity entity) {
		return new ConcessionarieDto(entity.getId(), entity.getNombre());
	}
}

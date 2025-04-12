package com.formacionbdi.springboot.app.test.concessionarie.dto;

import java.util.List;

import com.formacionbdi.springboot.app.test.concessionarie.model.ConcessionarieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionarieWithCarsDto {

	private Long id;
	private String nombre;
	private List<CarDto> vehiculos;
		
	public ConcessionarieWithCarsDto EntityToDto(ConcessionarieEntity entity, List<CarDto> vehicles) {
		return new ConcessionarieWithCarsDto(entity.getId(), entity.getNombre(), vehicles);
	}

}

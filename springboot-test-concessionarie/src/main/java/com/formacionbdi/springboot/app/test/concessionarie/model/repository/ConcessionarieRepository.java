package com.formacionbdi.springboot.app.test.concessionarie.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.springboot.app.test.concessionarie.model.ConcessionarieEntity;

public interface ConcessionarieRepository extends JpaRepository<ConcessionarieEntity, Long> {

}

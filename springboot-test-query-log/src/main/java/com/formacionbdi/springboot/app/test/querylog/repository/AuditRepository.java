package com.formacionbdi.springboot.app.test.querylog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.app.test.querylog.model.Audit;

@Repository
public interface AuditRepository extends MongoRepository<Audit, String>{

}

package com.utfpr.db.task8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utfpr.db.task8.entity.Departamento;

@Repository
 public interface DepartamentoRepository extends CrudRepository<Departamento, Long> 
{
}

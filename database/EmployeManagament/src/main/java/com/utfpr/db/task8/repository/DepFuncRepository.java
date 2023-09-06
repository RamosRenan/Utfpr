package com.utfpr.db.task8.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.utfpr.db.task8.entity.DepFunc;

@Repository
@Transactional(readOnly = false)
public interface DepFuncRepository extends CrudRepository<DepFunc, Long>{
	@Query(value =  "	 select df.id, cd_dep,   dep.nome, func.nome, idfuncionario, iddepartamento, iddepartamento_id, idfuncionario_id from dep_func as df\r\n"
			+ "	 inner join departamento as dep\r\n"
			+ "	 	on dep.id = ?1	 \r\n"
			+ " 		and iddepartamento = ?1 \r\n"
			+ "		\r\n"
			+ "		inner join funcionario as func\r\n"
			+ "			on func.id = df.idfuncionario", nativeQuery = true)
	public List<DepFunc> findAllFuncionariosByDepartamentWithoutSoon(int idDepart);
	
	

	@Query(value = "update dep_func set iddepartamento = 1, iddepartamento_id = 1\r\n"
			+ "		 	where iddepartamento = 3 and iddepartamento_id = 3", nativeQuery = true)
	default public boolean changeAllEmployesFromOneDepToAnother(@Param("num1") int num1, @Param("num2") int num2)
	{
		return true;
	}
	
	@Query(value = "insert into dep_func (iddepartamento, idfuncionario) values (?1, ?2)", nativeQuery = true)
	default public boolean saving(@Param("iddepartamento") long l, @Param("idfuncionario") long m)
	{
		return true;
	}
	
	@Modifying 
	@Transactional
	@Query(value = "delete from dep_func where iddepartamento = 1", nativeQuery = true)
	public void deleteAllEmployesFromOneDep();
}

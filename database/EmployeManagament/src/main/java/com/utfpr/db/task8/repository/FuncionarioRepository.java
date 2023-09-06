package com.utfpr.db.task8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utfpr.db.task8.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> 
{
	@Query(value = "	insert into funcionario (cd_funcionario, nome, qtd_dependentes, salario, cargo) \r\n"
			+ "		values (1248, 'marcus vinicius', 8, 79000, 'desenvolvedor')", nativeQuery = true)
	default Funcionario saving()
	{
		return this.getReferenceById((long) 1248);
	}
}

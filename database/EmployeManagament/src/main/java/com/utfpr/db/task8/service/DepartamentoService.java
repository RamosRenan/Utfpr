package com.utfpr.db.task8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.utfpr.db.task8.entity.DepFunc;
import com.utfpr.db.task8.entity.Departamento;
import com.utfpr.db.task8.entity.Funcionario;
import com.utfpr.db.task8.repository.DepFuncRepository;
import com.utfpr.db.task8.repository.DepartamentoRepository;
import com.utfpr.db.task8.repository.FuncionarioRepository;

@Service
public class DepartamentoService 
{
	@Autowired
	DepartamentoRepository departamentoRepository;
	
	@Autowired 
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	DepFuncRepository depFuncRepository;
	
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public void saveDepartamentoAndFuncionarioAndVincule()
	{
		Departamento departamento = new Departamento();
		
		departamento.setCd_dep(12547);
		
		departamento.setNome("Processamento e suporte");
		
		// recebe departamento
		Departamento departamento2 = departamentoRepository.save(departamento);
		
		System.err.println("departamento id: "+departamento2);
		
		// cria funcionario
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo("DEveloper");
		
		funcionario.setCd_funcionario(2554);
		
		funcionario.setNome("Marcus vini");
		
		funcionario.setQtd_dependentes(45);
		
		Funcionario funcionario2 = funcionarioRepository.save(funcionario);
		
		System.err.println("funcionario id: "+funcionario2);
		
		// cria relação funcionario e departamento
		DepFunc depFunc = new DepFunc();
		
		depFunc.setId(2658L);
		
		depFunc.setIddepartamento(departamento2);
		
		depFunc.setIdfuncionario(funcionario2);
		
		depFuncRepository.save(depFunc);
	}
}

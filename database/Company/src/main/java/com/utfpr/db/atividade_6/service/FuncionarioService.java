/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.db.atividade_6.service;

import com.utfpr.db.atividade_6.entity.Funcionario;
import com.utfpr.db.atividade_6.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author renan
 */
@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario findByNomeAndQtd_dependentes(String nome, int qtddependentes) {
        return funcionarioRepository.findByNomeAndQtddependentes(nome, qtddependentes);
    }

    public Funcionario findTopByOrderBySalarioDesc() {
        return funcionarioRepository.findFirstByOrderBySalarioDesc();
    }

    public List<Funcionario> findTop3ByOrderBySalarioDesc() {
        return funcionarioRepository.findTop3ByOrderBySalarioDesc();
    }

    public List<Funcionario> listAllFuncWithNoDependentes() {
        return funcionarioRepository.listAllFuncWithNoDependentes();
    }

    public List<Funcionario> findBySalarioIsGreaterThen(int salario) {
        return funcionarioRepository.findBySalarioIsGreaterThan(salario);
    }

    public List<Funcionario> findBySalarioIsGreaterThanNativeQuery() {
        return funcionarioRepository.findBySalarioIsGreaterThanNativeQuery();
    }

    public List<Funcionario> allFuncionariosWith2Dependentes() {
        return funcionarioRepository.allFuncionariosWith2Dependentes();
    }

    public List<Funcionario> allFuncionariosWithPartName(String nome) {
        return funcionarioRepository.allFuncionariosWithPartName(nome);
    }

//    public List<Funcionario> allFuncionariosWithPartNameRepo(String nome) {
//        return funcionarioRepository.allFuncionariosWithPartNameRepo(nome);
//    }
}

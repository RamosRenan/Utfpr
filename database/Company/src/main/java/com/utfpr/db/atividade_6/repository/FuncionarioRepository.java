/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.db.atividade_6.repository;

import com.utfpr.db.atividade_6.entity.Funcionario;
import java.util.List;
import javax.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author renan
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>
{
    public Funcionario          findByNomeAndQtddependentes(String nome, int qtddependentes);
    
    public Funcionario          findFirstByOrderBySalarioDesc();
    
    public List<Funcionario>    findTop3ByOrderBySalarioDesc();
    
    @Query("select func from Funcionario func where func.qtddependentes = 0 order by nome asc")
    public List<Funcionario>    listAllFuncWithNoDependentes();
    
    @Query("select func from Funcionario func where func.salario > 2000")
    public List<Funcionario>    findBySalarioIsGreaterThan(int salario);
    
    @Query(value="select * from funcionario func where func.salario > 2000", nativeQuery = true)
    public List<Funcionario>    findBySalarioIsGreaterThanNativeQuery();
    
    @Query(nativeQuery = true, name = "Funcionario.allFuncionariosWith2Dependentes") //  ABRANGE QUESTÃO 11
    public List<Funcionario>    allFuncionariosWith2Dependentes();
    
    @Query(nativeQuery = true, name = "Funcionario.allFuncionariosWithPartName") //  ABRANGE QUESTÃO 11
    public List<Funcionario>    allFuncionariosWithPartName(@Param("nome") String nome); 
    
//    @Query(nativeQuery = true, name = "allFuncionariosWithPartNameRepo")
//    public List<Funcionario>    allFuncionariosWithPartNameRepo(@Param("nome") String nome);
}

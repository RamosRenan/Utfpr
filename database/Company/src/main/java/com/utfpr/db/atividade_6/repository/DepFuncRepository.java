/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.db.atividade_6.repository;

import com.utfpr.db.atividade_6.entity.DepFunc;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renan
 */
public interface DepFuncRepository extends CrudRepository<DepFunc, Long>
{
    @Query("select df from dep_func df where df.iddepartamento = 2")
    public List<DepFunc> listAllFuncionariosByOneDepartamento();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utfpr.db.atividade_6.repository;

import com.utfpr.db.atividade_6.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author renan
 */
public interface DepartamentoRepository extends CrudRepository<Departamento, Long>
{
    public Departamento findFirstByOrderByIdAsc();
}

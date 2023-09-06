/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.db.atividade_6.service;

import com.utfpr.db.atividade_6.entity.Departamento;
import com.utfpr.db.atividade_6.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author renan
 */
@Service
public class DepartamentoService {
    @Autowired DepartamentoRepository departamentoRepository;
    
    public Departamento findFirt1ByOrderByIdAsc()
    {
        return this.departamentoRepository.findFirstByOrderByIdAsc();
    }
}

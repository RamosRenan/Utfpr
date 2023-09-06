/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.db.atividade_6.service;

import com.utfpr.db.atividade_6.entity.DepFunc;
import com.utfpr.db.atividade_6.repository.DepFuncRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author renan
 */
@Service
public class DepFuncService {
    @Autowired DepFuncRepository depFuncRepository;
    
    public List<DepFunc> listAllFuncionariosByOneDepartamento()
    {
        return depFuncRepository.listAllFuncionariosByOneDepartamento();
    }
}

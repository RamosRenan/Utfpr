package com.utfpr.db.task8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utfpr.db.task8.entity.DepFunc;
import com.utfpr.db.task8.repository.DepFuncRepository;

@Service
@Transactional(readOnly = false)
public class DepFuncService {
	@Autowired DepFuncRepository depFuncRepository;
    
    public List<DepFunc> listAllFuncionariosByOneDepartamento(int idDepart)
    {
        return depFuncRepository.findAllFuncionariosByDepartamentWithoutSoon(idDepart);
    }
    
	public void changeAllEmployesFromOneDepToAnother(int num1, int num2)
	{
		depFuncRepository.changeAllEmployesFromOneDepToAnother(num1, num2);
	}
    
    @Transactional
	public void deleteAllEmployesFromOneDep()
	{
		depFuncRepository.deleteAllEmployesFromOneDep();
	}
}

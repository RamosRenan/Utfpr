package com.example.crud.crudcidades.visao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// import java.util.EnumSet;
// import java.util.Set;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renan
 */
@Controller
public class CrudCidadeController {

    // id each city
    private static Long id = 0L;

    // volatil store 
    private static HashSet<Cidade> cidadesHashSet;

    private static HashMap<String, Object> hashMapPageVariables; 

    public CrudCidadeController(){}

    @GetMapping("/")
    public String index(Model bindToPage)
    {
        if(cidadesHashSet == null)
        {
            CrudCidadeController.cidadesHashSet= new HashSet<Cidade>();
            CrudCidadeController.hashMapPageVariables = new HashMap<String, Object>();
            listar();
        }

        // Iterator<Cidade> listaCidades = cidadesHashSet.iterator();
        // bindToPage.addAttribute("listaCidades", listaCidades);

        bindToPage.addAttribute("hashMapPageVariables", hashMapPageVariables);

        return "/crud";
    }

    @GetMapping("/del/cidade")
    public String delete(@RequestParam String name, @RequestParam String state)
    {
        Optional<Cidade> delteCidade = cidadesHashSet.stream().filter(c -> c.getName().equals(name)).findFirst();
        if(!delteCidade.isPresent())
            return "redirect:/";
        
        cidadesHashSet.remove(delteCidade.orElseThrow(null));
        return "redirect:/";
    }

    @PostMapping("/insert/cidade")
    @SuppressWarnings(value = "unchecked")
    public String insert(@Valid Cidade cidade, BindingResult bindResult, Model bindToPage)
    {
        if(bindResult.hasErrors())
        {
            List<FieldError> errors = bindResult.getFieldErrors();
            FieldError fieldError = errors.get(0);
            bindToPage.addAttribute("nameError", fieldError.getField());
            return "crud";
        }
        if(hashMapPageVariables.get("listaCidades") instanceof HashSet)
        {
            HashSet<Cidade> existCity = ( HashSet<Cidade>) hashMapPageVariables.get("listaCidades");

            boolean verifyExistCity = existCity.stream().filter(c -> c.getId().equals(cidade.getId())).findAny().isPresent();
            if(verifyExistCity)
                update(cidade, existCity);
        }

        cidade.setId(id++);

        cidadesHashSet.add(cidade);
        
        hashMapPageVariables.put("listaCidades", cidadesHashSet);
        hashMapPageVariables.put("formImputsDefaultNameCity", cidade.getNameEx());
    
        return "redirect:/";
    }


    private void update(Cidade cidade, HashSet<Cidade> cidades)
    {
       Optional<Cidade> cc = cidades.stream().filter(c -> c.getId().equals(cidade.getId())).findAny();

       cidades.remove(cc.orElseThrow(null));
       cidades.add(cidade);
    }
    
    //@GetMapping("/ex/list")
    private void listar()
    {
        Cidade cidade = new Cidade("Ex.: cidade", "Ex.: estado", null, null);
        List<Cidade> listCidade = new ArrayList<Cidade>();
        listCidade.add(cidade);

        hashMapPageVariables.put("listaCidades", listCidade);
        hashMapPageVariables.put("formImputsDefaultNameCity", cidade.getNameEx());

        System.out.println("hashMapPageVariables: "+hashMapPageVariables.get("formImputsDefaultNameCity"));
        System.out.println("hashMapPageVariables list: "+hashMapPageVariables.get("listaCidades"));
    }
}

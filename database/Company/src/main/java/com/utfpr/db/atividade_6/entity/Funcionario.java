/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.db.atividade_6.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author renan
 */
@Entity
@Table(name = "funcionario")
@NamedQuery(name = "Funcionario.allFuncionariosWith2Dependentes", query = "select func from Funcionario func where func.qtddependentes = 2")
@NamedNativeQuery(name = "Funcionario.allFuncionariosWithPartName", query = "select * from funcionario where nome like 'lu%'", resultClass = Funcionario.class)
public class Funcionario implements Serializable{

    @Id
    private Long id;
    
    @Column
    private int cd_funcionario;
    
    @Column
    private String nome;
    
    @Column(name = "qtd_dependentes")
    private Integer qtddependentes;
    
    @Column 
    private int salario;
    
    @Column
    private String cargo;

    public int getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(int cd_func) {
        this.cd_funcionario = cd_func;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd_dependentes() {
        return qtddependentes;
    }

    public void setQtd_dependentes(Integer qtd_dependentes) {
        this.qtddependentes = qtd_dependentes ;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        return  "\n\n >>>> -------------------------------------------- <<<<"+
                "\n >>>> INFORMAÇÕES DE FUNCIONÁRIO <<<<"+
                "\n >>> id      : "+this.getId()+
                "\n >>> nome    : "+this.getNome()+
                "\n >>> cargo   : "+this.getCargo()+
                "\n >>> salario : "+this.getSalario()+
                "\n >>> qtdDep. : "+this.getQtd_dependentes()+
                "\n >>> entity  : "+this.getClass()+
                "\n >>>> -------------------------------------------- <<<< \n";
    }
    
}

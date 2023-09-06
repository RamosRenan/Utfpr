/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.db.atividade_6.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author renan
 */
@Entity(name = "dep_func")
@Table(name = "dep_func")
public class DepFunc  implements Serializable
{    
    @Id
    private Long id;    
  
    @OneToOne
    private Departamento iddepartamento;

    @OneToOne
    private Funcionario idfuncionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
  
    
    @Override
    public String toString()
    {
        // this.getIdfuncionario()  != null ? this.getIdfuncionario().getNome()  :
        // this.getIddepartamento() != null ? this.getIddepartamento().getNome() :
        
        String msn =  "\n\n >>>> -------------------------------------------- <<<<"+
        "\n >>>> INFORMAÇÕES DE DepFunc <<<<"+
        "\n >>> id      : "+this.getId();
        
        String msnF = "ñ existe funcioanrio";
        String msnD = "ñ existe departamento";
        
        if(this.getIddepartamento() != null)
        {
            msn += "\n >>> depart      : "+this.getIddepartamento().getNome();
        }
        else
        {
            msn += "\n >>> depart      : " + msnD;
        }
        
        if(this.getIdfuncionario() != null)
             msn += "\n >>> func      : "+this.getIdfuncionario().getNome();
        else
            msn += "\n >>> func      : " + msnF;
        

        msn += "\n >>>> -------------------------------------------- <<<< \n";
        
        return msn;
    }
}
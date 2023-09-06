package com.utfpr.db.task8.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "dep_func")
@Table(name = "dep_func")
public class DepFunc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
            msn += "\n >>> depart      : " + msnD + " " + this.getIddepartamento();
        }
        
        if(this.getIdfuncionario() != null)
             msn += "\n >>> func      : "+this.getIdfuncionario().getNome();
        else
            msn += "\n >>> func      : " + msnF + " " + this.getIdfuncionario();
        

        msn += "\n >>>> -------------------------------------------- <<<< \n";
        
        return msn;
    }
}

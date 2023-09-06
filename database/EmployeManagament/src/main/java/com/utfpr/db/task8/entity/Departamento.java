package com.utfpr.db.task8.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable
{
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	 	private Long id;
	    
	    @Column 
	    private int cd_dep;
	    
	    @Column
	    private String nome;

	    public int getCd_dep() {
	        return cd_dep;
	    }

	    public void setCd_dep(int cd_dep) {
	        this.cd_dep = cd_dep;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
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
	                "\n >>>> INFORMAÇÕES DE DEPARTAMENTO <<<<"+
	                "\n >>> id      : "+this.getId()+
	                "\n >>> nome    : "+this.getNome()+
	                "\n >>> entity  : "+this.getClass()+
	                "\n >>>> -------------------------------------------- <<<< \n"; 
	    }
}

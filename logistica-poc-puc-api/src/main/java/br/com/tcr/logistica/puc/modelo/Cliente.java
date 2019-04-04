package br.com.tcr.logistica.puc.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema="logistica-poc-puc",name="cliente")
@NamedQueries({@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")})
public class Cliente implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String apelido;
	
	private String nome;
	
	public Cliente() 
	{}
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getApelido() 
	{
		return apelido;
	}

	public void setApelido(String apelido) 
	{
		this.apelido = apelido;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

}

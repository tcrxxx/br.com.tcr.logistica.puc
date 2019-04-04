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
@Table(schema="logistica-poc-puc",name="frete")
@NamedQueries({@NamedQuery(name="Frete.findAll", query="SELECT f FROM Frete f"),
	@NamedQuery(name="Frete.findByCep", query="SELECT f FROM Frete f where f.cepOrigem = :cepOrigem and f.cepDestino = :cepDestino")})
public class Frete implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String cepOrigem;
	
	private String cepDestino;
	
	private long valor;
	
	public Frete() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

}

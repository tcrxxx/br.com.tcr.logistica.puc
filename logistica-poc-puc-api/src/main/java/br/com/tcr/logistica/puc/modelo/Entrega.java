package br.com.tcr.logistica.puc.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema="logistica-poc-puc",name="entrega")
@NamedQueries({@NamedQuery(name="Entrega.findAll", query="SELECT e FROM Entrega e"),
			   @NamedQuery(name="Entrega.findById", query="SELECT e FROM Entrega e where e.id = :id"),
			   @NamedQuery(name="Entrega.findByIdCliente", query="SELECT e FROM Entrega e where e.idCliente = :idCliente"),
			   @NamedQuery(name="Entrega.last", query="SELECT e FROM Entrega e where e.id = (SELECT max(e.id) FROM Entrega e)"),
			   @NamedQuery(name="Entrega.pendencies", query="SELECT e FROM Entrega e where e.idUltimoEstado <> 1")})
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idCliente;
	
	private String cepOrigem;
	
	private String cepDestino;
	
	private int peso;
	private int qtd;
	
	@Column(name="dtPedido")
	private String dataPedido;
	
	private int idUltimoEstado;
	
	
	public Entrega()
	{
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
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

	public int getIdUltimoEstado() {
		return idUltimoEstado;
	}

	public void setIdUltimoEstado(int idUltimoEstado) {
		this.idUltimoEstado = idUltimoEstado;
	}
	
}

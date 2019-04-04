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
@Table(schema="logistica-poc-puc",name="rl_entrega_motorista")
@NamedQueries({@NamedQuery(name="EntregaMotorista.findAll", query="SELECT e FROM EntregaMotorista e")})
public class EntregaMotorista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idEntrega;
	private int idMotorista;
	private int idUsuarioAtribuicao;
	
	public EntregaMotorista ()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}
	public int getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}
	public int getIdUsuarioAtribuicao() {
		return idUsuarioAtribuicao;
	}
	public void setIdUsuarioAtribuicao(int idUsuarioAtribuicao) {
		this.idUsuarioAtribuicao = idUsuarioAtribuicao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

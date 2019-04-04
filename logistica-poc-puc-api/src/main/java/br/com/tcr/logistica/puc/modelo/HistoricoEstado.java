package br.com.tcr.logistica.puc.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema="logistica-poc-puc",name="ht_estado_entrega")
@NamedQueries({@NamedQuery(name="HistoricoEstado.findAll", query="SELECT hf FROM HistoricoEstado hf")})
public class HistoricoEstado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idEntrega;
	
	private int idUsuario;
	
	private int idEstado;
	
	private Date dtEstado; 
	
	public HistoricoEstado() {

	}
	
	public HistoricoEstado(Entrega entrega) {
		
		this.setIdUsuario(entrega.getIdCliente());
		this.setIdEntrega(entrega.getId());
		this.setIdEstado(entrega.getIdUltimoEstado());
		this.setDtEstado(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public Date getDtEstado() {
		return dtEstado;
	}

	public void setDtEstado(Date dtEstado) {
		this.dtEstado = dtEstado;
	}

}

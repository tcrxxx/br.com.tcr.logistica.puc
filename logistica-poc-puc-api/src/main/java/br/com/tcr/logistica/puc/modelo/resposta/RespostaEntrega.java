package br.com.tcr.logistica.puc.modelo.resposta;

import br.com.tcr.logistica.puc.modelo.TipoEstadoEntrega;

public class RespostaEntrega extends RespostaPadrao {

	private int idEntrega;
	private String valor;
	private String tempoEstimado;
	private TipoEstadoEntrega estado;
	
	//private String msg;

	public RespostaEntrega() {
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(String tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public TipoEstadoEntrega getEstado() {
		return estado;
	}
	public void setEstado(TipoEstadoEntrega estado) {
		this.estado = estado;
	}
	public String getMsg() {
		return super.getMsg();
	}
	public void setMsg(String msg) {
		super.setMsg(msg);
	}

	public int getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}
	
}

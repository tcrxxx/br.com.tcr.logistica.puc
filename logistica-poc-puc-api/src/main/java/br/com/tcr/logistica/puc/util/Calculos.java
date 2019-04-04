package br.com.tcr.logistica.puc.util;

import br.com.tcr.logistica.puc.modelo.Entrega;
import br.com.tcr.logistica.puc.modelo.Frete;

public abstract class Calculos {
	
	public static long calculaValorEntrega(Entrega entrega, Frete frete) {
		return (entrega.getPeso() * frete.getValor()) * entrega.getQtd();
	}

}

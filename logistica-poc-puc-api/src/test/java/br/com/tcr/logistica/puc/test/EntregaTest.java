package br.com.tcr.logistica.puc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.tcr.logistica.puc.modelo.Entrega;
import br.com.tcr.logistica.puc.modelo.Frete;
import br.com.tcr.logistica.puc.util.Calculos;

public class EntregaTest {

	Entrega entrega;
	Frete frete; 
	
	@Before
	public void init() {
		entrega = new Entrega();
		frete = new Frete();
	}
	
	@Test
	public void testCalculoValorEntrega() {
		
		entrega.setPeso(2);
		entrega.setQtd(10);
		
		frete.setValor(5);
		
		//(Peso * ValorFrete) * Qtd
		assertEquals(Calculos.calculaValorEntrega(entrega, frete), 100);
		
	}
	
}

package br.com.tcr.logistica.puc.modelo;

public enum TipoEstadoEntrega {
	
	ENTREGUE(1),
	ATRASADO(2),
	NAO_ENTREGUE(3),
	SAIU_PARA_ENTREGA(4),
	AGUARDANDO_CAPTURA(5);
    
    private int tipo;
    
    TipoEstadoEntrega(int desc){
        this.tipo = desc;
    }
    
	public int getTipo() {
		return tipo;
	}   
	
}
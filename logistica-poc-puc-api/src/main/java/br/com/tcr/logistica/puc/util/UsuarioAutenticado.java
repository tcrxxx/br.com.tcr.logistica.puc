package br.com.tcr.logistica.puc.util;

public abstract class UsuarioAutenticado {
	
	public static boolean isUsuarioAutenticado(String key) {
		boolean retorno = true;
		
		if (key==null || !key.equals("451795E2BC54450E9EDE76C802C5BEC409C44DE962C4E5E0699579372AAE3E3B"))
		{
			retorno = false;
		}
		
		return retorno;
		
	}

}

package br.com.tcr.logistica.puc.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.tcr.logistica.puc.modelo.correios.Correios;

public abstract class CorreiosClient {

	
	public static Correios consultar(String cep) {
		
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		WebResource webResource = client
		   .resource("https://viacep.com.br/ws/"+cep+"/json/");

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		

		try {

			return response.getStatus() == 200 ? response.getEntity(Correios.class) : null;			

		} catch (Exception e) {
			
			
			throw e;
			
		} finally {
			
			response.close();
			
		}	
		

	}
	
	
	public static boolean isValido(String cep) {
		return consultar(cep)!=null?true:false;
	}
	
	
}

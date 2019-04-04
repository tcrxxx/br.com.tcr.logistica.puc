package br.com.tcr.logistica.puc.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.tcr.logistica.puc.modelo.maps.DistanceMatrix;

public abstract class GoogleDistanceMatrixClient {

	public static DistanceMatrix consultar(String origem, String destino) {
		
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(defaultClientConfig);
		
		WebResource webResource = client
		   .resource("https://maps.googleapis.com/maps/api/distancematrix/json")
		   .queryParam("origins", origem).queryParam("destinations", destino)
		   .queryParam("language", "pt-BR")
		   .queryParam("key", "")
		   ;

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		

		try {

			return response.getStatus() == 200 ? response.getEntity(DistanceMatrix.class) : null;			

		} catch (Exception e) {
			
			
			throw e;
			
		} finally {
			
			response.close();
			
		}	
		

	}
	
	
}

package br.com.tcr.logistica.puc.rest;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.tcr.logistica.puc.client.GoogleDistanceMatrixClient;
import br.com.tcr.logistica.puc.dao.DAO;
import br.com.tcr.logistica.puc.modelo.Entrega;
import br.com.tcr.logistica.puc.modelo.Frete;
import br.com.tcr.logistica.puc.modelo.HistoricoEstado;
import br.com.tcr.logistica.puc.modelo.TipoEstadoEntrega;
import br.com.tcr.logistica.puc.modelo.maps.DistanceMatrix;
import br.com.tcr.logistica.puc.modelo.resposta.RespostaEntrega;
import br.com.tcr.logistica.puc.util.Calculos;

@Path("/entrega")
@Stateless
public class EntregaResource {
	
	
	@Inject
	DAO<Entrega> daoEntrega;
	
	@Inject
	DAO<Frete> daoFrete;
	
	
	@Inject
	DAO<HistoricoEstado> daoHistoricoEstado;
	
    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + "FUCIONANDO" + "\"}";
    }
    
    @GET
    @Path("/")
    @Produces({ "application/json" })
    public Response listarEntregas() {
    	return this.listarEntregas("");
    }
    
    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public Response listarEntregas(@PathParam("id") String id) {
    	String queryName;
    	HashMap<String,Object> params = new HashMap<String,Object>();		
		
		if(id == null || id.equals("")){
			id = "";
			queryName = "Entrega.findAll";
		} else
			{
			queryName = "Entrega.findById";
			params.put("id", Integer.valueOf(id));
			}
		
		
    	
    	List<Entrega> lista = (List<Entrega>) daoEntrega.executeNamedQuery(queryName, params);
    	
    	return //"{\"result\":\"" + "FUCIONANDO" + id + lista.size() + "\"}" ;
    			Response.ok(lista).build();
    	    	
    }
    
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response criar(Entrega entrega) {
		
		RespostaEntrega resposta = new RespostaEntrega();
		
		if (entrega!=null) {
			try {
				HashMap<String,Object> params = new HashMap<String,Object>();
				params.put("cepOrigem", entrega.getCepOrigem());
				params.put("cepDestino",entrega.getCepDestino());
				List<Frete> listaFrete = (List<Frete>)  daoFrete.executeNamedQuery("Frete.findByCep", params);

				if (listaFrete!=null && listaFrete.size()>0) {
						
						entrega.setIdUltimoEstado(TipoEstadoEntrega.AGUARDANDO_CAPTURA.getTipo());
						daoEntrega.merge(entrega);
						
						List<Entrega> lista = (List<Entrega>) daoEntrega.executeNamedQuery("Entrega.last", new HashMap<String,Object>());
						
						daoHistoricoEstado.merge(new HistoricoEstado(lista.get(0)));
						
						resposta.setIdEntrega(lista.get(0).getId());
						resposta.setEstado(TipoEstadoEntrega.AGUARDANDO_CAPTURA);
						resposta.setMsg("Entrega cadastrada com sucesso!");
						
						//TODO teste unitário calculo valor de entrega
						resposta.setValor("R$" + Long.toString(Calculos.calculaValorEntrega(entrega, listaFrete.get(0))));
						
						DistanceMatrix map = GoogleDistanceMatrixClient.consultar(entrega.getCepOrigem(), entrega.getCepDestino());
						resposta.setTempoEstimado(map.rows[0].elements[0].duration.text);		
						
				}
				else resposta.setMsg("Cep não cadastrado para entrega. Consulte nossa tabela de CEPs disponíveis: " + "http://localhost:8080/logistica-poc-puc-api/rest/frete/");
				
			} catch (Exception e) {
				resposta.setMsg(e.getLocalizedMessage());
			}
		}
		
		return Response.ok(resposta).build(); 
		
	}
	
}

package br.com.tcr.logistica.puc.rest;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.tcr.logistica.puc.client.CorreiosClient;
import br.com.tcr.logistica.puc.dao.DAO;
import br.com.tcr.logistica.puc.modelo.Frete;
import br.com.tcr.logistica.puc.modelo.resposta.RespostaFrete;
import br.com.tcr.logistica.puc.util.UsuarioAutenticado;

@Path("/frete")
@Stateless
public class FretesResource {
	
	
	@Inject
	DAO<Frete> daoFrete;

	
	@GET
    @Path("/cep")
    @Produces({ "application/json" })
    public Response consultarCep(@QueryParam("cep") String cep, @HeaderParam("key") String key) throws Exception {
		return UsuarioAutenticado.isUsuarioAutenticado(key)==true?Response.ok(CorreiosClient.consultar(cep)).build():Response.status(Status.UNAUTHORIZED).build();
	}
	
    @GET
    @Path("/")
    @Produces({ "application/json" })
    public Response listarFretes() {
    	return this.listarFretes("");
    }
    
    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public Response listarFretes(@PathParam("id") String id) {
    	
    	HashMap<String,Object> params = new HashMap<String,Object>();		
		
		if(id == null){
			id = "";
		}
		
		//params.put("id", "%"+id+"%");
    	
    	List<Frete> lista = (List<Frete>) daoFrete.executeNamedQuery("Frete.findAll", params);
    	
    	return //"{\"result\":\"" + "FUCIONANDO" + id + lista.size() + "\"}" ;
    			Response.ok(lista).build();
    }
    
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response criar(Frete frete) {
		RespostaFrete resposta = new RespostaFrete();
		
		String cepIncorreto;		
		cepIncorreto = CorreiosClient.isValido(frete.getCepOrigem())==true?null:frete.getCepOrigem();
		cepIncorreto = CorreiosClient.isValido(frete.getCepDestino())==true?null:frete.getCepDestino();
		
		try {
			
			//TODO teste unitário valida CEP
			if (cepIncorreto==null) {
				daoFrete.merge(frete);
				resposta.setMsg("Frete cadastrado com sucesso!");				
			} else resposta.setMsg("Verifique os CEPs informados! Para validar seu cep navegue: " + "http://localhost:8080/logistica-poc-puc-api/rest/frete/cep?cep=" + cepIncorreto);
		} catch (Exception e) {
			resposta.setMsg("Houve um erro ao cadastrar o cep!" + e.getLocalizedMessage());
		}
		
		return Response.ok(resposta).build(); 
		
	}
	
}

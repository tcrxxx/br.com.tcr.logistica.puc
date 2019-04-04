package br.com.tcr.logistica.puc.rest;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.tcr.logistica.puc.dao.DAO;
import br.com.tcr.logistica.puc.modelo.Entrega;
import br.com.tcr.logistica.puc.modelo.HistoricoEstado;
import br.com.tcr.logistica.puc.modelo.resposta.RespostaPadrao;

@Path("/entrega")
@Stateless
public class EstadoEntregaResource {

	@Inject
	DAO<Entrega> daoEntrega;
	
	@Inject
	DAO<HistoricoEstado> daoHistoricoEstado;
	
	@GET
    @Path("estado/pendentes/")
    @Produces({ "application/json" })
    public Response listarEntregas() {
    	
		List<Entrega> lista = (List<Entrega>) daoEntrega.executeNamedQuery("Entrega.pendencies", new HashMap<String,Object>());
    	
    	return Response.ok(lista).build();
    	    	
    }
	
	@PUT
    @Path("/")
    @Produces({ "application/json" })
    public Response atualizarEstado(Entrega entrega) {
    	RespostaPadrao resposta = new RespostaPadrao();
    	
    	try {
    		daoEntrega.merge(entrega);
    		daoHistoricoEstado.merge(new HistoricoEstado(entrega));
    		resposta.setMsg("Estado da entrega foi atualizado com sucesso!");
		} catch (Exception e) {
			resposta.setMsg("Ocorreu um erro ao atualizar o estado da entrega. " + e.getLocalizedMessage());
		}
		
    	return Response.ok(resposta).build();
    	    	
    }
	
	
}

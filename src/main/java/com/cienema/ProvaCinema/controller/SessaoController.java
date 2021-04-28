package com.cienema.ProvaCinema.controller;

import com.cienema.ProvaCinema.DAO.SessaoDAO;
import com.cienema.ProvaCinema.model.Sessao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sessao")
public class SessaoController {
    @GET
    @Path("create-table")
    @Produces("application/json")
    public Response createTableSessao(){
        SessaoDAO sessaoDAO = new SessaoDAO();
        sessaoDAO.createTableSessao();
        return Response.ok(new Gson().toJson("Tabela Sessão criada com sucesso!")).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSessoes(){
        SessaoDAO sessaoDAO = new SessaoDAO();
        List<Sessao> sessoes = sessaoDAO.listSessao();
        return Response.ok(new Gson().toJson(sessoes)).build();
    }
}

package com.cienema.ProvaCinema.controller;

import com.cienema.ProvaCinema.DAO.FilmeDAO;
import com.cienema.ProvaCinema.model.Filme;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
public class FilmeController {
    @GET
    @Path("create-table")
    @Produces("application/json")
    public Response createTableFilme() {
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.createTableFilme();
        return Response.ok(new Gson().toJson("Tabela Filme criada com sucesso!")).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public Response listFilme(){
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filme> filmes = filmeDAO.listFilme();
        return Response.ok(new Gson().toJson(filmes)).build();
    }
}

package com.cienema.ProvaCinema.controller;

import com.cienema.ProvaCinema.DAO.SalaDAO;
import com.cienema.ProvaCinema.model.Sala;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sala")
public class SalaController {
    @GET
    @Path("create-table")
    @Produces("application/json")
    public Response createTableSala(){
        SalaDAO salaDAO = new SalaDAO();
        salaDAO.createTableSala();
        return Response.ok(new Gson().toJson("Tabela Sala criada com sucesso!")).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public Response listSalas(){
        SalaDAO salaDAO = new SalaDAO();
        List<Sala> salas = salaDAO.listSala();
        return Response.ok(new Gson().toJson(salas)).build();
    }
}

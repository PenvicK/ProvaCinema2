package com.cienema.ProvaCinema.DAO;

import com.cienema.ProvaCinema.factory.ConnectionFactory;
import com.cienema.ProvaCinema.model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private Connection connection;

    public SalaDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableSala();
    }

    public void createTableSala(){
        String sql = "create table if not exists sala(" +
                "idSala int primary key auto_increment," +
                "sala int not null," +
                "capacidade int not null" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Sala criada com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void insertSala(Sala sala){
        String sql = "insert into sala" +
                "(sala, capacidade)" +
                "values (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, sala.getSala());
            stmt.setInt(2, sala.getCapacidade());

            stmt.execute();
            ResultSet ids = stmt.getGeneratedKeys();
            if (ids.next()){
                int id = ids.getInt(1);
                sala.setIdSala(id);
            }
            stmt.close();
            System.out.println("Informações inserida!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Sala> listSala(){
        String sql = "select * from sala";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            List<Sala> salas = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            Sala sala;
            while (resultSet.next()){
                sala = new Sala();
                sala.setIdSala(resultSet.getInt("idSala"));
                sala.setSala(resultSet.getInt("sala"));
                sala.setCapacidade(resultSet.getInt("capacidade"));

                salas.add(sala);
            }
            return salas;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Sala findSalaById(int id){
        String sql = "select * from sala where idSala = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Sala sala = new Sala();
            while (resultSet.next()){
                sala.setIdSala(resultSet.getInt("idSala"));
                sala.setSala(resultSet.getInt("sala"));
                sala.setCapacidade(resultSet.getInt("capacidade"));

            }
            return sala;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

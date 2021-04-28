package com.cienema.ProvaCinema.DAO;

import com.cienema.ProvaCinema.factory.ConnectionFactory;
import com.cienema.ProvaCinema.model.Filme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection connection;

    public FilmeDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableFilme();
    }

    public  void createTableFilme(){
        String sql = "create table if not exists filme(" +
                "idFilme int primary key auto_increment," +
                "nome varchar(70) not null," +
                "genero varchar(50) not null," +
                "idadePermitida varchar(3) not null," +
                "idioma varchar(50) not null," +
                "duracao time not null," +
                "descricao longtext not null" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Filme criada com sucesso!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void insertFilme(Filme filme){
        String sql = "insert into filme" +
                "(nome, genero, idadePermitida, idioma, duracao, descricao)" +
                "values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getGenero());
            stmt.setString(3, filme.getIdadePermitida());
            stmt.setString(4, filme.getIdioma());
            stmt.setTime(5, filme.getDuracao());
            stmt.setString(6, filme.getDescricao());

            stmt.execute();
            ResultSet ids = stmt.getGeneratedKeys();
            if (ids.next()){
                int id = ids.getInt(1);
                filme.setIdFilme(id);
            }
            stmt.close();
            System.out.println("Informações inseridas!!");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Filme> listFilme(){
        String sql = "select * from filme";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            List<Filme> filmes = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            Filme filme;
            while (resultSet.next()){
                filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setNome(resultSet.getString("nome"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setIdadePermitida(resultSet.getString("idadePermitida"));
                filme.setIdioma(resultSet.getString("idioma"));
                filme.setDuracao(resultSet.getTime("duracao"));
                filme.setDescricao(resultSet.getString("descricao"));

                filmes.add(filme);
            }
            return filmes;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Filme findFilmeById(int id){
        String sql = "SELECT * FROM filme WHERE idFilme = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Filme filme = new Filme();

            while (resultSet.next()){
                filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setNome(resultSet.getString("nome"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setIdadePermitida(resultSet.getString("idadePermitida"));
                filme.setIdioma(resultSet.getString("idioma"));
                filme.setDuracao(resultSet.getTime("duracao"));
                filme.setDescricao(resultSet.getString("descricao"));
            }
            return filme;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

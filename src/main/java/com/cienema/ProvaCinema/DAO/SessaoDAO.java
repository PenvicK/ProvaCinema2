package com.cienema.ProvaCinema.DAO;

import com.cienema.ProvaCinema.factory.ConnectionFactory;
import com.cienema.ProvaCinema.model.Sessao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {
    private Connection connection;

    public SessaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableSessao();
    }

    public void createTableSessao(){
        String sql = "create table if not exists sessao(" +
                "idSessao int primary key auto_increment," +
                "dataSessao date not null," +
                "horario time not null," +
                "idFilme int," +
                "idSala int," +
                "valorIngresso double," +
                "foreign key (idFilme)" +
                "references filme(idFilme)," +
                "foreign key (idSala)" +
                "references sala(idSala)" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Sessão criada com sucesso!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void insertDevice(Sessao sessao){
        String sql = "INSERT INTO sessao" +
                "(dataSessao, horario, filme, sala, valorIngresso)" +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setDate(1, sessao.getDataSessao());
            stmt.setTime(2, sessao.getHorario());
            stmt.setInt(3, sessao.getFilme().getIdFilme());
            stmt.setInt(4, sessao.getSala().getIdSala());
            stmt.setDouble(5, sessao.getValorIngresso());

            stmt.execute();
            ResultSet ids = stmt.getGeneratedKeys();
            if(ids.next()){
                int id = ids.getInt(1);
                sessao.setIdSessao(id);
            }
            stmt.close();
            System.out.println("Informações inseridas!!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Sessao> listSessao(){
        String sql = "SELECT * FROM sessao";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            List<Sessao> sessoes = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            Sessao sessao;
            FilmeDAO filmeDAO = new FilmeDAO();
            SalaDAO salaDAO = new SalaDAO();
            while (resultSet.next()){
                sessao = new Sessao();
                sessao.setIdSessao(resultSet.getInt("idSessao"));
                sessao.setDataSessao(resultSet.getDate("dataSessao"));
                sessao.setHorario(resultSet.getTime("horario"));
                sessao.setFilme(filmeDAO.findFilmeById(resultSet.getInt("idFilme")));
                sessao.setSala(salaDAO.findSalaById(resultSet.getInt("idSala")));
                sessao.setValorIngresso(resultSet.getDouble("valorIngresso"));

                sessoes.add(sessao);
            }
            return sessoes;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Sessao findSessaoById(int id){
        String sql = "SELECT * FROM sessao WHERE idSessao = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Sessao sessao = new Sessao();
            FilmeDAO filmeDAO = new FilmeDAO();
            SalaDAO salaDAO = new SalaDAO();
            while (resultSet.next()){
                sessao.setIdSessao(resultSet.getInt("idSessao"));
                sessao.setDataSessao(resultSet.getDate("dataSessao"));
                sessao.setHorario(resultSet.getTime("horario"));
                sessao.setFilme(filmeDAO.findFilmeById(resultSet.getInt("idFilme")));
                sessao.setSala(salaDAO.findSalaById(resultSet.getInt("idSala")));
                sessao.setValorIngresso(resultSet.getDouble("valorIngresso"));
            }
            return sessao;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}

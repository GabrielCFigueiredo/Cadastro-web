package br.com.cadastrar.dao;

import br.com.cadastrar.infra.ConnectionFactory;
import br.com.cadastrar.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDao implements ICadastroDao {
    @Override
    public Pessoa iserir(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = ("INSERT INTO Pessoa(nomePessoa, email) VALUES(?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNomePessoa());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            pessoa.setId(Math.toIntExact(generatedId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;
        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = ("UPDATE Pessoa SET nomePessoa = ?, email = ? WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNomePessoa());
            preparedStatement.setString(2, pessoa.getEmail());
            preparedStatement.setLong(3, pessoa.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;
        return pessoa;
    }

    @Override
    public void delete(long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = ("DELETE FROM Pessoa WHERE id = ? ");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;

    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = ("SELECT * FROM Pessoa");
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nomePessoa = resultSet.getString("nomePessoa");
                String email = resultSet.getString("email");

                Pessoa pessoa = new Pessoa(id, nomePessoa, email);

                pessoas.add(pessoa);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    @Override
    public Optional<Pessoa> findById(long id) {
        Pessoa pessoa = null;
        String sql = ("SELECT * FROM Pessoa WHERE id = ?");
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long pkey = resultSet.getLong("id");
                String nomePessoa = resultSet.getString("nomePessoa");
                String email = resultSet.getString("email");

                pessoa = new Pessoa(pkey, nomePessoa, email);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pessoa);
    }
}

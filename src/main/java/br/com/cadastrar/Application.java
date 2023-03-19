package br.com.cadastrar;

import br.com.cadastrar.dao.PessoaDao;
import br.com.cadastrar.infra.ConnectionFactory;
import br.com.cadastrar.model.Pessoa;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        PessoaDao pessoaDao = new PessoaDao(connection);


    }
}

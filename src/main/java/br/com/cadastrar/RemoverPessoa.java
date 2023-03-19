package br.com.cadastrar;

import br.com.cadastrar.dao.PessoaDao;
import br.com.cadastrar.infra.ConnectionFactory;

import java.sql.Connection;

public class RemoverPessoa {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        PessoaDao pessoaDao = new PessoaDao(connection);

        pessoaDao.delete(5L);
    }
}

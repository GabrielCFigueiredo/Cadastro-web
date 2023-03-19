package br.com.cadastrar;

import br.com.cadastrar.dao.PessoaDao;
import br.com.cadastrar.infra.ConnectionFactory;
import br.com.cadastrar.model.Pessoa;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ListarPessoas {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        PessoaDao pessoaDao = new PessoaDao(connection);

        /*List<Pessoa> pessoas = pessoaDao.findAll();

        for (Pessoa pessoa : pessoas) {
            System.out.println("id: " + pessoa.getId());
            System.out.println("nome: " + pessoa.getNomePessoa());
            System.out.println("email: " + pessoa.getEmail());
        }*/

        Optional<Pessoa> pessoa = pessoaDao.findById(5L);
        pessoa.ifPresent(pessoa1 -> {
            System.out.println("id: " + pessoa1.getId());
            System.out.println("nome: " + pessoa1.getNomePessoa());
            System.out.println("email: " + pessoa1.getEmail());
        });

    }

    
}

package br.com.cadastrar;

import br.com.cadastrar.dao.PessoaDao;
import br.com.cadastrar.model.Pessoa;

import java.util.Optional;

public class AtualizarPessoa {

    public static void main(String[] args) {

        PessoaDao pessoaDao = new PessoaDao();
        Optional<Pessoa> pessoaOptional = pessoaDao.findById(5L);

        Pessoa pessoa = pessoaOptional.get();
        System.out.println("Id: " + pessoa.getId());
        System.out.println("nome: " + pessoa.getNomePessoa());
        System.out.println("email: " + pessoa.getEmail());

        pessoa.setNomePessoa("Pedro");
        pessoa.setEmail("pedro@gmail.com");

        pessoaDao.update(pessoa);
    }


}

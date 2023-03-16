package br.com.cadastrar;

import br.com.cadastrar.dao.PessoaDao;

public class RemoverPessoa {
    public static void main(String[] args) {
        PessoaDao pessoaDao = new PessoaDao();

        pessoaDao.delete(5L);
    }
}

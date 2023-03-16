package br.com.cadastrar.dao;

import br.com.cadastrar.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface ICadastroDao {
    Pessoa iserir(Pessoa pessoa);
    Pessoa update(Pessoa pessoa);


    void delete(long id);

    List<Pessoa> findAll();
    Optional<Pessoa> findById(long id);
}

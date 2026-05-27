package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Filme;

import java.util.List;

public interface FilmeDAO extends DAO<Filme, Long> {

    List<Filme> findByDuracaoMaiorQue(Integer duracaoMaior);
}
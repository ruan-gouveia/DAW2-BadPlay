package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Avaliacao;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Usuario;


import java.util.List;

public interface AvaliacaoDAO extends DAO<Avaliacao, Long> {

    List<Avaliacao> findByUsuario(Usuario usuario);
    Double getMediaNotasByConteudo(Conteudo conteudo);
}

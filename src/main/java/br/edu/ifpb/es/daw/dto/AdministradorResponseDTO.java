package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Administrador;

public record AdministradorResponseDTO(Long idAdministrador, String nome, String email) {
    public AdministradorResponseDTO(Administrador adm) {
        this(adm.getIdAdministrador(), adm.getNome(), adm.getEmail());
    }
}
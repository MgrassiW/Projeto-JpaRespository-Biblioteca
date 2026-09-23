package Projeto.Biblioteca.DTO;

import Projeto.Biblioteca.Entity.ROLE;

public record UsuarioResponse (

        Long id,
        String nome,
        String email
){}

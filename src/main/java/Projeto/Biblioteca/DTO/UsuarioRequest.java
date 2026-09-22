package Projeto.Biblioteca.DTO;

import Projeto.Biblioteca.Entity.ROLE;

public record UsuarioRequest (

        String nome,
        String email,
        ROLE role
){
}

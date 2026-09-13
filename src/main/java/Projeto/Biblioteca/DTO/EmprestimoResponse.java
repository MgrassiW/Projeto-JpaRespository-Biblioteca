package Projeto.Biblioteca.DTO;

import Projeto.Biblioteca.Entity.Livro;
import Projeto.Biblioteca.Entity.Usuario;

import java.time.LocalDateTime;

public record EmprestimoResponse (

        Long id,
        LocalDateTime dataEmprestimo,
        LocalDateTime dataDevolucao,
        UsuarioResponse usuario,
        LivroResponse livro
){}

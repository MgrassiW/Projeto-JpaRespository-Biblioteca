package Projeto.Biblioteca.DTO;

import Projeto.Biblioteca.Entity.Livro;
import Projeto.Biblioteca.Entity.Usuario;

import java.time.LocalDateTime;

public record EmprestimoRequest(

        LocalDateTime dataEmprestimo,
        LocalDateTime dataDevolucao,
        Long usuarioId,
        Long livroId
) {}

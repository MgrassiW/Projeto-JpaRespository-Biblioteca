package Projeto.Biblioteca.DTO;

public record LivroResponse (

        Long id,
        String titulo,
        String autor,
        String isbn,
        Boolean disponivel
){
}

package Projeto.Biblioteca.DTO;

public record LivroRequest(

        String titulo,
        String autor,
        String isbn,
        Boolean disponivel
) {
}

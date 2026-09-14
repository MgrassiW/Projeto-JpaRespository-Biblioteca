package Projeto.Biblioteca.Mapper;

import Projeto.Biblioteca.DTO.LivroRequest;
import Projeto.Biblioteca.DTO.LivroResponse;
import Projeto.Biblioteca.Entity.Livro;
import io.swagger.v3.oas.annotations.media.Content;

public class LivroMapper {

    public Livro toEntity(LivroRequest request) {

        return Livro.builder()
                .titulo(request.titulo())
                .autor(request.autor())
                .isbn(request.isbn())
                .disponivel(request.disponivel())
                .build();
    }
    public LivroResponse toResponse(Livro livro) {

        return new LivroResponse(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getIsbn(),
                livro.getDisponivel()
        );
    }

    public void updateEntity(LivroRequest request , Livro livro) {

        livro.setAutor(request.autor());
        livro.setTitulo(request.titulo());
        livro.setIsbn(request.isbn());
        livro.setDisponivel(request.disponivel());
    }
}

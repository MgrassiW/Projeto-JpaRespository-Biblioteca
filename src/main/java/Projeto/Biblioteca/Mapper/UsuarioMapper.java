package Projeto.Biblioteca.Mapper;

import Projeto.Biblioteca.DTO.UsuarioRequest;
import Projeto.Biblioteca.DTO.UsuarioResponse;
import Projeto.Biblioteca.Entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest request) {

        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .build();
    }

    public UsuarioResponse toResponse(Usuario usuario) {

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    public void updateEntity(UsuarioRequest request , Usuario usuario) {

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());

    }
}

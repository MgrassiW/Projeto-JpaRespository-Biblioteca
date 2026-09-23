package Projeto.Biblioteca.Service;

import Projeto.Biblioteca.DTO.UsuarioRequest;
import Projeto.Biblioteca.DTO.UsuarioResponse;
import Projeto.Biblioteca.Entity.Usuario;
import Projeto.Biblioteca.Mapper.UsuarioMapper;
import Projeto.Biblioteca.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResponse save(UsuarioRequest request) {

        Usuario usuario = usuarioMapper.toEntity(request);

        usuario.setSenha(passwordEncoder.encode(request.senha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);

    }

    public List<UsuarioResponse> findAll() {

        return usuarioRepository.findAll().stream()
                .map(usuarioMapper :: toResponse)
                .toList();

    }

    public UsuarioResponse findById(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        return usuarioMapper.toResponse(usuario);

    }

    public UsuarioResponse update(UsuarioRequest request , Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        usuarioMapper.updateEntity(request , usuario);


        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }

    public void delete(Long id) {

        usuarioRepository.deleteById(id);
    }







}

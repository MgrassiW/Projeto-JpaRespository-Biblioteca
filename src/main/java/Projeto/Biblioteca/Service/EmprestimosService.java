package Projeto.Biblioteca.Service;

import Projeto.Biblioteca.DTO.EmprestimoRequest;
import Projeto.Biblioteca.DTO.EmprestimoResponse;
import Projeto.Biblioteca.Entity.Emprestimos;
import Projeto.Biblioteca.Entity.Livro;
import Projeto.Biblioteca.Entity.Usuario;
import Projeto.Biblioteca.Mapper.EmprestimosMapper;
import Projeto.Biblioteca.Repository.EmprestimosRepository;
import Projeto.Biblioteca.Repository.LivroRepository;
import Projeto.Biblioteca.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimosService {

    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;
    private final EmprestimosRepository emprestimosRepository;
    private final EmprestimosMapper emprestimosMapper;

    public EmprestimoResponse save(EmprestimoRequest request) {

        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow();

        Livro livro = livroRepository.findById(request.livroId())
                .orElseThrow();

        Emprestimos emprestimos = emprestimosMapper.toEntity(request , livro , usuario);

        Emprestimos emprestimosSalvo = emprestimosRepository.save(emprestimos);

        return emprestimosMapper.toResponse(emprestimosSalvo);

    }

    public List<EmprestimoResponse> findAll() {


        return emprestimosRepository.findAll().stream()
                .map(emprestimosMapper :: toResponse)
                .toList();
    }

    public EmprestimoResponse findById(Long id) {

        Emprestimos emprestimos = emprestimosRepository.findById(id)
                .orElseThrow();

        return emprestimosMapper.toResponse(emprestimos);

    }

    public EmprestimoResponse update(EmprestimoRequest request , Long id) {

        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow();

        Livro livro = livroRepository.findById(request.livroId())
                .orElseThrow();

        Emprestimos emprestimos = emprestimosRepository.findById(id)
                .orElseThrow();

        emprestimosMapper.updateEntity(request , usuario , livro , emprestimos);

        Emprestimos emprestimosSalvo = emprestimosRepository.save(emprestimos);

        return emprestimosMapper.toResponse(emprestimosSalvo);
    }

    public void delete(Long id) {


        emprestimosRepository.deleteById(id);
    }



}

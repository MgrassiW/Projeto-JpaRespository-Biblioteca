package Projeto.Biblioteca.Service;

import Projeto.Biblioteca.DTO.LivroRequest;
import Projeto.Biblioteca.DTO.LivroResponse;
import Projeto.Biblioteca.Entity.Livro;
import Projeto.Biblioteca.Mapper.LivroMapper;
import Projeto.Biblioteca.Repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LivroService
{

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public LivroResponse save(LivroRequest request) {

        Livro livro = livroMapper.toEntity(request);

        Livro livroSalvo = livroRepository.save(livro);

        return livroMapper.toResponse(livroSalvo);
    }

    public List<LivroResponse> findAll() {

        return livroRepository.findAll().stream()
                .map(livroMapper :: toResponse)
                .toList();

    }

    public LivroResponse findById(Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow();

        return livroMapper.toResponse(livro);
    }

    public LivroResponse update(LivroRequest request , Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow();

        livroMapper.updateEntity(request , livro);

        Livro livroSalvo = livroRepository.save(livro);

        return livroMapper.toResponse(livroSalvo);

    }
    public void delete(Long id) {

        livroRepository.deleteById(id);
    }
}

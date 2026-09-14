package Projeto.Biblioteca.Mapper;

import Projeto.Biblioteca.DTO.EmprestimoRequest;
import Projeto.Biblioteca.DTO.EmprestimoResponse;
import Projeto.Biblioteca.Entity.Emprestimos;
import Projeto.Biblioteca.Entity.Livro;
import Projeto.Biblioteca.Entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmprestimosMapper {

    private final LivroMapper livroMapper;
    private final UsuarioMapper usuarioMapper;

    public Emprestimos toEntity(EmprestimoRequest request , Livro livro , Usuario usuario) {

        return Emprestimos.builder()
                .dataEmprestimo(request.dataEmprestimo())
                .dataDevolucao(request.dataDevolucao())
                .usuario(usuario)
                .livro(livro)
                .build();
    }

    public EmprestimoResponse toResponse(Emprestimos emprestimos) {

        return new EmprestimoResponse(
                emprestimos.getId(),
                emprestimos.getDataEmprestimo(),
                emprestimos.getDataDevolucao(),
                usuarioMapper.toResponse(emprestimos.getUsuario()),
                livroMapper.toResponse(emprestimos.getLivro())
        );
    }

    public void updateEntity(EmprestimoRequest request, Usuario usuario, Livro livro , Emprestimos emprestimos) {

        emprestimos.setDataEmprestimo(request.dataEmprestimo());
        emprestimos.setDataDevolucao(request.dataDevolucao());
        emprestimos.setLivro(livro);
        emprestimos.setUsuario(usuario);
    }
}

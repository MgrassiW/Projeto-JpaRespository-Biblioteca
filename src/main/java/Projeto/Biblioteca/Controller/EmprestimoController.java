package Projeto.Biblioteca.Controller;

import Projeto.Biblioteca.DTO.EmprestimoRequest;
import Projeto.Biblioteca.DTO.EmprestimoResponse;
import Projeto.Biblioteca.DTO.UsuarioRequest;
import Projeto.Biblioteca.DTO.UsuarioResponse;
import Projeto.Biblioteca.Service.EmprestimosService;
import Projeto.Biblioteca.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimosService emprestimosService;


    @PostMapping
    public EmprestimoResponse save(@RequestBody EmprestimoRequest request) {

        return emprestimosService.save(request);
    }

    @GetMapping
    public List<EmprestimoResponse> findAll() {

        return emprestimosService.findAll();
    }

    @GetMapping("/{id}")
    public EmprestimoResponse findById(@PathVariable Long id) {

        return emprestimosService.findById(id);
    }

    @PutMapping("/{id}")
    public EmprestimoResponse update(@RequestBody EmprestimoRequest request , @PathVariable Long id) {

        return emprestimosService.update(request , id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        emprestimosService.delete(id);
    }
}

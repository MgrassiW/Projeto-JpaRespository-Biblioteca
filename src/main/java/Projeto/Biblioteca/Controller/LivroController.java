package Projeto.Biblioteca.Controller;


import Projeto.Biblioteca.DTO.LivroRequest;
import Projeto.Biblioteca.DTO.LivroResponse;
import Projeto.Biblioteca.DTO.UsuarioRequest;
import Projeto.Biblioteca.DTO.UsuarioResponse;
import Projeto.Biblioteca.Service.LivroService;
import Projeto.Biblioteca.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;


    @PostMapping
    public LivroResponse save(@RequestBody LivroRequest request) {

        return livroService.save(request);
    }

    @GetMapping
    public List<LivroResponse> findAll() {

        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public LivroResponse findById(@PathVariable Long id) {

        return livroService.findById(id);
    }

    @PutMapping("/{id}")
    public LivroResponse update(@RequestBody LivroRequest request , @PathVariable Long id) {

        return livroService.update(request , id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        livroService.delete(id);
    }
}

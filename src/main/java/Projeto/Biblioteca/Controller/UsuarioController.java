package Projeto.Biblioteca.Controller;

import Projeto.Biblioteca.DTO.UsuarioRequest;
import Projeto.Biblioteca.DTO.UsuarioResponse;
import Projeto.Biblioteca.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public UsuarioResponse save(@RequestBody UsuarioRequest request) {

        return usuarioService.save(request);
    }

    @GetMapping
    public List<UsuarioResponse> findAll() {

        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioResponse findById(@PathVariable Long id) {

        return usuarioService.findById(id);
    }

    @PutMapping("/{usuario}/{id}")
    public UsuarioResponse update(@RequestBody UsuarioRequest request , @PathVariable Long id) {

        return usuarioService.update(request , id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        usuarioService.delete(id);
    }




}

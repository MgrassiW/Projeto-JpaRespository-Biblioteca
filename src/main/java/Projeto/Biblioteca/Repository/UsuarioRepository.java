package Projeto.Biblioteca.Repository;

import Projeto.Biblioteca.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
}

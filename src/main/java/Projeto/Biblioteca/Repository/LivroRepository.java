package Projeto.Biblioteca.Repository;

import Projeto.Biblioteca.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro , Long> {
}

package Projeto.Biblioteca.Repository;

import Projeto.Biblioteca.Entity.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosRepository extends JpaRepository<Emprestimos , Long> {
}

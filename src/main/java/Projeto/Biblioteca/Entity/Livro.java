package Projeto.Biblioteca.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livros")
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo" , nullable = false)
    private String titulo;

    @Column(name = "autor" , nullable = false)
    private String autor;

    @Column(name = "isbn" , nullable = false)
    private String isbn;

    @Column(name = "disponivel" , nullable = false)
    private Boolean disponivel;

    @OneToMany(mappedBy = "livro")
    private Set<Emprestimos> emprestimos;

}

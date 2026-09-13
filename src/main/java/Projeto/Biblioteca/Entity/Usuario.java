package Projeto.Biblioteca.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "usuario")
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome" , nullable = false)
    private String nome;

    @Column(name = "email" , unique = true)
    private String email;

    @OneToMany(mappedBy = "usuario")
    private Set<Emprestimos> emprestimos;
}

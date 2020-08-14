package io.github.monthalcantara.estudoapicdc.detalhelivro;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @URL
    private String linkGithub;

    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    public Autor(@NotBlank String nome, @NotBlank @URL String linkGithub) {
        this.nome = nome;
        this.linkGithub = linkGithub;
    }

    @Deprecated
    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", linkGithub='" + linkGithub + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

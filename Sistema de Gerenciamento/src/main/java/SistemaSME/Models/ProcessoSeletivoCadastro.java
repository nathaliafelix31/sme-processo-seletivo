package SistemaSME.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ProcessoSeletivoCadastro {

    //notEmpty

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotNull
    private String nome;
    @DateTimeFormat
    private String dataNascimento;

    @Column(unique = true)
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull
    private String rg;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
    @NotNull
    private String vaga;
    @NotNull
    private String disciplina;
    @NotNull
    private String escolaridade;
    @NotNull
    private String aperfeicoamentoProfissional;
    private Integer cargaHoraria;
    @NotNull
    private Integer tempoServico;

    @CreationTimestamp
    private LocalDateTime dataCriacao;


}

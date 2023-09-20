package SistemaSME.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

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
    private String dataNascimento;

    @Column(unique = true)
    @CPF(message = "CPF inválido!")
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String vaga;
    private String disciplina;
    private String escolaridade;
    private String aperfeicoamentoProfissional;
    private Integer cargaHoraria;
    private Integer tempoServico;

    @CreationTimestamp
    private LocalDateTime dataCriacao;


}

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
    @NotNull
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
    private String disciplina;

    private String posGraduacao;
    private String habilitado;
    private String cursandoLicenciatura;
    private String cursandoBacharelado;
    private String cursoNivelMedio;
    private String ensinoMedioCompleto;
    private String ensinoMedioIncompleto;
    private String escolaridadeMedioIncompleto;
    private String anoConclusaoEscolaridadeMedioIncompleto;
    private String ensinoFundamentalCompleto;
    private String ensinoFundamentalIncompleto;
    private String escolaridadeFundamentalIncompleto;
    private String anoConclusaoEscolaridadeFundamentalIncompleto;
    private String outro;
    @NotNull
    private String aperfeicoamentoProfissional;
    private Integer cargaHoraria;

    private Integer tempoServico;

    @CreationTimestamp
    private LocalDateTime dataCriacao;


}

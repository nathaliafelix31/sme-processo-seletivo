package SistemaSME.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
public class ProcessoSeletivoCadastro {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message = "Nome Completo não pode ser vazio!")
    private String nome;

    @NotEmpty(message = "Data de Nascimento não pode ser vazio!")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dataNascimento;

    //@Column(unique = true)
    @CPF(message = "CPF inválido!")
    private String cpf;
    @NotEmpty(message = "RG não pode ser vazio!")
    private String rg;

    @NotEmpty(message = "Email não pode ser vazio!")
    private String email;

    @NotEmpty(message = "Telefone não pode ser vazio!")
    private String telefone;

    @NotEmpty(message = "Cargo não pode ser vazio!")
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



    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime dataCriacao;



}

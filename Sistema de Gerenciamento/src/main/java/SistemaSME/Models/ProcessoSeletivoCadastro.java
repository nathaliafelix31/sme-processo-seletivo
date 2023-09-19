package SistemaSME.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class ProcessoSeletivoCadastro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String dataNascimento;

    @Column(unique = true)
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String vaga;
    private String escolaridade;
    private String aperfeicoamentoProfissional;
    private int cargaHoraria;
    private int tempoServico;

    @CreationTimestamp
    private LocalDateTime dataCriacao;


}

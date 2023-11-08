package SistemaSME.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class FormularioRecurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message = "Nome do Candidato não pode ser vazio!")
    private String nomeCandidato;
    @NotEmpty(message = "Número de Inscrição não pode ser vazio!")
    private String numeroInscricao;
    @NotEmpty(message = "Cargo Pleitado não pode ser vazio!")
    private String cargoPleitado;
    private String disciplina;
    @NotEmpty(message = "Documento de Identificação não pode ser vazio!")
    private String documentoIdentificacao;
    @NotEmpty(message = "Telefone não pode ser vazio!")
    private String telefone;
    @NotEmpty(message = "Tipo do Recurso não pode ser vazio!")
    private String tipoRecurso;
    @NotEmpty(message = "Fundamentação da Solicitação não pode ser vazio!")
    private String solicitacao;
}

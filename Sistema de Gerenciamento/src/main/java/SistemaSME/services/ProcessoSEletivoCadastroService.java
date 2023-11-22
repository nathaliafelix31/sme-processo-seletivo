package SistemaSME.services;

import SistemaSME.models.ProcessoSeletivoCadastro;

import java.util.List;

public interface ProcessoSEletivoCadastroService {


        void addCandidatos(ProcessoSeletivoCadastro candidatos);

        List< ProcessoSeletivoCadastro > getTheListCandidatos();

}

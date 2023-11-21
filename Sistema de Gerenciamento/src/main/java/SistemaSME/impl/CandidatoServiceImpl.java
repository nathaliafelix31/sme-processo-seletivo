package SistemaSME.impl;

import SistemaSME.models.ProcessoSeletivoCadastro;
import SistemaSME.repositories.ProcessoSeletivoRepository;
import SistemaSME.services.ProcessoSEletivoCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class CandidatoServiceImpl implements ProcessoSEletivoCadastroService {

        @Autowired
        ProcessoSeletivoRepository processoSeletivoRepository;


    @Override
    public void addCandidatos(ProcessoSeletivoCadastro candidatos) {
        processoSeletivoRepository.save(candidatos);
    }

    @Override
        public List< ProcessoSeletivoCadastro > getTheListCandidatos() {
            return (List<ProcessoSeletivoCadastro>) processoSeletivoRepository.findAll();
        }
    }



package SistemaSME.Controllers;


import SistemaSME.Models.ProcessoSeletivoCadastro;
import SistemaSME.Repository.ProcessoSeletivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import java.util.List;


@Controller
public class SmeController {

    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;

    @RequestMapping(value="/")
    public String sme(){

        return "/SME/index.html";
    }

    @RequestMapping(value="/processoSeletivo")
    public String processoSeletivo(){

        return "/SME/processoSeletivo/processoSeletivo.html";
    }
    @RequestMapping(value="/processoSeletivo/cadastrarCandidato")
    public String cadastrarCandidato(){

        return "/SME/processoSeletivo/cadastrarCandidato.html";
    }

    @RequestMapping(value="/processoSeletivo/cadastrarCandidato", method= RequestMethod.POST )
    public String form(ProcessoSeletivoCadastro cadastro){
        processoSeletivoRepository.save(cadastro);
        return "redirect:/processoSeletivo";
    }

    @RequestMapping(method = RequestMethod.GET, value="/processoSeletivo/listarCandidatos")
    public ModelAndView listarCandidatos(){
        ModelAndView mv = new ModelAndView("SME/processoSeletivo/listarCandidatos");
        Iterable<ProcessoSeletivoCadastro> listaCandidatos = processoSeletivoRepository.findAll();
        mv.addObject("candidatos", listaCandidatos);
        return mv;
    }
    @RequestMapping(value="/processoSeletivo/detalhesCandidato/{codigo}")
    public ModelAndView detalhesCandidato(@PathVariable("codigo") long codigo){
        ProcessoSeletivoCadastro candidato = processoSeletivoRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("SME/processoSeletivo/detalhesCandidato");
        mv.addObject("candidato", candidato);
        return mv;
    }


}

package SistemaSME.Controllers;


import SistemaSME.Models.ProcessoSeletivoCadastro;
import SistemaSME.Repository.ProcessoSeletivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SmeController {

    @Autowired
    private ProcessoSeletivoRepository ps;

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
        ps.save(cadastro);
        return "redirect:/processoSeletivo";
    }

    /*@RequestMapping(method = RequestMethod.GET, value="/processoSeletivo/listarCandidatos")
    public ModelAndView listarCandidatos(){
        ModelAndView mv = new ModelAndView("/processoSeletivo/listarCandidatos");
        Iterable<ProcessoSeletivoCadastro> listaCandidatos = ps.findAll();
        mv.addObject("candidatos", listaCandidatos);
        return mv;
    }*/
    @RequestMapping(value="/processoSeletivo/listarCandidatos")
    public String ListarCandidatos(Model model){
        model.addAttribute("candidatos", ps.findAll());
        return "/processoSeletivo/listarCandidatos";
    }

    /*@RequestMapping(value="/processoSeletivo/listarCandidatos")
    public String test(){

        return "/SME/processoSeletivo/listarCandidatos.html";
    }*/

}

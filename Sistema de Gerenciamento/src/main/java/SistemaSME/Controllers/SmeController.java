package SistemaSME.Controllers;


import SistemaSME.Models.FormularioRecurso;
import SistemaSME.Models.ProcessoSeletivoCadastro;
import SistemaSME.Repository.Comprovantes;
import SistemaSME.Repository.FormularioRecursoRepository;
import SistemaSME.Repository.ProcessoSeletivoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SmeController {

    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;
    @Autowired
    private FormularioRecursoRepository formularioRecursoRepository;

    @RequestMapping(value="/")
    public String sme(){

        return "/SME/index.html";
    }
    @RequestMapping(value="/login")
    public String login(){

        return "/SME/login.html";
    }

    @RequestMapping("/telaInicial")
    public String admin(){

        return "telaInicial";
    }

    @RequestMapping("/secure")
    public String secure(){

        return "secure";
    }

    @RequestMapping(value="/processoSeletivo")
    public String processoSeletivo(){

        return "/SME/processoSeletivo/processoSeletivo.html";
    }

    @RequestMapping(value="/processoSeletivo/vagas")
    public String vagas(){

        return "/SME/processoSeletivo/vagas.html";
    }
    @RequestMapping(value="/processoSeletivo/cadastrarCandidato")
    public String cadastrarCandidato(){

        return "/SME/processoSeletivo/cadastrarCandidato.html";
    }
    @RequestMapping(value="/processoSeletivo/listarCandidatosVagas")
    public String listarVagas(){

        return "/SME/processoSeletivo/listarCandidatosVagas.html";
    }
    @RequestMapping(value="/processoSeletivo/formularioRecurso")
    public String cadastrarRecurso(){

        return "/SME/processoSeletivo/formularioRecurso.html";
    }

    @RequestMapping(value="/processoSeletivo/listaRecurso")
    public String listaRecurso(){

        return "/SME/processoSeletivo/listarRecursos.html";
    }

    @RequestMapping(value="/processoSeletivo/detalhesRecurso")
    public String detalhesRecurso(){

        return "/SME/processoSeletivo/detalhesRecurso.html";
    }

    @RequestMapping(value="/processoSeletivo/cadastrarCandidato", method= RequestMethod.POST)
    public Object salvarCandidato(@Valid ProcessoSeletivoCadastro cadastro, BindingResult bindingResult){
       if (bindingResult.hasErrors()){
           ModelAndView modelAndView = new ModelAndView("SME/processoSeletivo/cadastrarCandidato");
           Iterable<ProcessoSeletivoCadastro> candidato = processoSeletivoRepository.findAll();
           modelAndView.addObject("candidatos", candidato);
           modelAndView.addObject("candidatoObj", cadastro);

           List<String> msg = new ArrayList<String>();
           for (ObjectError objectError : bindingResult.getAllErrors()){
               msg.add(objectError.getDefaultMessage()); // vem das anotações @NotEmpity e outras
           }
            modelAndView.addObject("msg",msg);
          return modelAndView;
       }
        processoSeletivoRepository.save(cadastro);
        Comprovantes comprovantes = new ComprovanteInscricao(cadastro);
        comprovantes.gerarCabecalho();
        comprovantes.gerarCorpo();
        comprovantes.gerarRodape();
        comprovantes.imprimir();

       return "redirect:/processoSeletivo/vagas";
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

    @RequestMapping(value="/processoSeletivo/formularioRecurso", method= RequestMethod.POST )
    public Object salvarFormularioRecurso(@Valid FormularioRecurso formulario, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("SME/processoSeletivo/formularioRecurso");
            Iterable<FormularioRecurso> formularioRecursos = formularioRecursoRepository.findAll();
            modelAndView.addObject("formularioRecursos", formularioRecursos);
            modelAndView.addObject("formularioRecursoObj", formulario);

            List<String> msg = new ArrayList<String>();
            for (ObjectError objectError : bindingResult.getAllErrors()){
                msg.add(objectError.getDefaultMessage()); // vem das anotações @NotEmpity e outras
            }
            modelAndView.addObject("msg",msg);
            return modelAndView;
        }
        formularioRecursoRepository.save(formulario);
        return "redirect:/processoSeletivo";
    }

    @RequestMapping(method = RequestMethod.GET, value="/processoSeletivo/listaRecurso")
    public ModelAndView listarRecursos(){
        ModelAndView mv = new ModelAndView("SME/processoSeletivo/listarRecursos");
        Iterable<FormularioRecurso> listaRecurso = formularioRecursoRepository.findAll();
        mv.addObject("recursos", listaRecurso);

        return mv;
    }
    @RequestMapping(value="/processoSeletivo/detalhesRecurso/{codigo}")
    public ModelAndView detalhesRecursos(@PathVariable("codigo") long codigo){
        FormularioRecurso recurso = formularioRecursoRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("SME/processoSeletivo/detalhesRecurso");
        mv.addObject("recurso", recurso);

        return mv;
    }

}

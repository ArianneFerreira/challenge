package grupomateus.challenge.controllers;


import grupomateus.challenge.models.Igreja;
import grupomateus.challenge.models.IgrejaServico;
import grupomateus.challenge.repositories.IgrejaRepository;
import grupomateus.challenge.repositories.IgrejaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class IgrejaServicoController {

    @Autowired
    private IgrejaServicoRepository igrejaServicoRepository;

    @Autowired
    private IgrejaRepository igrejaRepository;

    @RequestMapping(value = "/igreja-servicos", method = RequestMethod.POST)
    public void salvar(@RequestBody IgrejaServico igrejaServico){
        igrejaServicoRepository.save(igrejaServico);
    }

    @RequestMapping(value = "/igreja-servicos/{id_igreja}")
    public String buscar(@PathVariable("id_igreja") long idIgreja, Model model){
        Igreja church = igrejaRepository.findById(idIgreja).get();
      model.addAttribute("servicos",  igrejaServicoRepository.findAllByIgreja(church).stream().map((igrejaServico) -> {
          return igrejaServico.getServico();
            }).collect(Collectors.toList())
        );
      return "lista-servicos-igreja";
    }

    @RequestMapping(value = "/igreja-servicos/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") long id){
        igrejaServicoRepository.deleteById(id);
    }

}



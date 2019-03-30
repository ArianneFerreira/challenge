package grupomateus.challenge.controllers;

import grupomateus.challenge.models.Horario;
import grupomateus.challenge.models.IgrejaServico;
import grupomateus.challenge.repositories.HorarioRepository;
import grupomateus.challenge.repositories.IgrejaServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private IgrejaServicoRepository igrejaServicoRepository;

    @RequestMapping(value = "/horarios", method = RequestMethod.POST)
    public void salvar(@RequestBody Horario horario){
        horarioRepository.save(horario);
    }

    @RequestMapping(value = "/horarios")
    public Object buscar(){
       return horarioRepository.findAll();
    }

    @RequestMapping(value = "/horarios/{id_igreja/{id_servico}")
    public Object buscarHorarioServico(@PathVariable("id_igreja") long idIgreja, @PathVariable("id_servico") long idServico){
        IgrejaServico is = igrejaServicoRepository.findByIgrejaIdAndServicoId(idIgreja, idServico);

        return horarioRepository.findAllByIgrejaServicoId(is.getId());
    }

    @RequestMapping(value = "/horarios/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") long id, @RequestBody Horario horario) throws Exception{
        Horario hora = horarioRepository.findById(id).get();

        if( hora == null){
            throw new Exception("Horario não encontrado!");
        }

        hora.setDiaSemana(horario.getDiaSemana());
        hora.setHoraFinal(horario.getHoraFinal());
        hora.setHoraInicial(horario.getHoraInicial());
        hora.setIgrejaServico(horario.getIgrejaServico());

        horarioRepository.save(hora);
     }

    @RequestMapping(value = "/horarios/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") long id){
        horarioRepository.deleteById(id);
    }
}

package grupomateus.challenge.controllers;


import grupomateus.challenge.models.DiaSemana;
import grupomateus.challenge.repositories.DiaSemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaSemanaController {

    @Autowired
    private DiaSemanaRepository diaSemanaRepository;

    @RequestMapping(value = "/dias-semana/", method = RequestMethod.POST)
    public void salvar(@RequestBody DiaSemana diaSemana){
        diaSemanaRepository.save(diaSemana);
    }

    @RequestMapping(value = "dias-semana")
    public Object buscar(){
        return diaSemanaRepository.findAll();
    }

    @RequestMapping(value = "/dias-semana/{id}")
    public void atualizar(@PathVariable("id") long id, @RequestBody DiaSemana diaSemana) throws Exception{
        DiaSemana dia = diaSemanaRepository.findById(id).get();

        if(dia == null){
            throw new Exception("Dia não encontrado!");
        }

        dia.setDescricao(diaSemana.getDescricao());

        diaSemanaRepository.save(dia);

    }

    @RequestMapping(value = "dias-semana/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") long id){
        diaSemanaRepository.deleteById(id);
    }
}

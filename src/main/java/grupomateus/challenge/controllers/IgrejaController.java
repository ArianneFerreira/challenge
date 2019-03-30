package grupomateus.challenge.controllers;

import grupomateus.challenge.models.Igreja;
import grupomateus.challenge.repositories.IgrejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IgrejaController {

    @Autowired
    private IgrejaRepository igrejaRepository;

    @RequestMapping(value = "/igrejas", method = RequestMethod.POST)
    public void salvar(@RequestBody Igreja igreja){
        igrejaRepository.save(igreja);
    }

    @RequestMapping(value = "/igrejas")
    public Object buscar(){
        return igrejaRepository.findAll();
    }

    @RequestMapping(value = "/igrejas/{id}", method =  RequestMethod.GET)
    public Object buscarId(@PathVariable("id") long id) {
        return igrejaRepository.findById(id).orElse(new Igreja());
    }


    @RequestMapping(value = "/igrejas/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") long id, @RequestBody Igreja igreja ) throws Exception{

        Igreja church = igrejaRepository.findById(id).get();

        if( church == null){
            throw new Exception("Igreja não encontrada!");
        }
        church.setNome(igreja.getNome());
        church.setDescricao(igreja.getDescricao());
        church.setEndereco(igreja.getEndereco());
        church.setParoco(igreja.getParoco());
        church.setTelefone(igreja.getTelefone());

        igrejaRepository.save(church);
    }

    @RequestMapping(value = "/igrejas/{id}", method = RequestMethod.DELETE )
    public void deletear(@PathVariable("id") long id){
        igrejaRepository.deleteById(id);
    }

}

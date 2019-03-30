package grupomateus.challenge.controllers;

import grupomateus.challenge.models.Servico;
import grupomateus.challenge.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @RequestMapping(value = "/servicos", method = RequestMethod.POST)
    public void salvar(@RequestBody Servico servico){
        servicoRepository.save(servico);
    }

    @RequestMapping(value = "/servicos")
    public Object buscar(){
        return servicoRepository.findAll();

    }

    @RequestMapping(value = "/servicos/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable("id") long id, @RequestBody Servico servico) throws Exception{
        Servico serv = servicoRepository.findById(id).get();

        if(serv == null){
            throw new Exception("Serviço não encontrado!");
        }

        serv.setNome(servico.getNome());
        servicoRepository.save(serv);

    }

    @RequestMapping(value = "/servicos/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") long id){
        servicoRepository.deleteById(id);
    }
}

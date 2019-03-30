package grupomateus.challenge;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

    @RequestMapping(value = "/home")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/templates/{name}")
    public String templates(@PathVariable("name") String name){
        return name;

    }
}

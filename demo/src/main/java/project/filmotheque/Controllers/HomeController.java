package project.filmotheque.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = { "/", "/accueil" }, method = RequestMethod.GET)
public class HomeController {

    @RequestMapping(path = { "/", "/accueil" }, method = RequestMethod.GET)
    public String accueil() {
        return "index";
    }
}

package project.filmotheque.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfilController {

    @RequestMapping(path = "/profil", method = RequestMethod.GET)
    public String profil() {
        return "profil";
    }
}

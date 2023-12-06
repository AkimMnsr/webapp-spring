package project.filmotheque.Controllers;

import java.util.List;
import project.filmotheque.BO.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.filmotheque.Services.FilmService;

@Controller
public class FilmController {

    private FilmService filmService;

    @RequestMapping(path = "/film", method = RequestMethod.GET)
    public String film(Model model) {
        List<Film> filmsList = filmService.findAllFilms();
        model.addAttribute("films", filmsList);
        return "film";
    }

    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam("id") long id, Model filmDetail) {
        filmDetail.addAttribute("film", filmService.findFilmById(id));
        return "detail";
    }

    // @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

}

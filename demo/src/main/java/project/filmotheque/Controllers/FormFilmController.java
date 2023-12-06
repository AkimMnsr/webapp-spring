package project.filmotheque.Controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import project.filmotheque.BO.Film;
import project.filmotheque.Controllers.DTO.FilmDTO;
import project.filmotheque.Services.FilmService;

@Controller
@SessionAttributes("films")
public class FormFilmController {

    private FilmService filmService;

    public FormFilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @ModelAttribute("films")
    public List<Film> getFilms() {
        return filmService.findAllFilms();
    }

    @GetMapping({ "/addFilm" })
    public String addfilms(Model modele) {
        modele.addAttribute("film", new Film());
        return "addFilm";
    }

    @PostMapping("/film")
    public String AddFilmPost(@ModelAttribute("film") FilmDTO film,
            BindingResult validationResult,
            @ModelAttribute("films") List<Film> listFilms) {
        if (validationResult.hasErrors()) {
            return "addFilm";
        }
        long id = filmService.generateId();
        Film filmToAdd = filmService.normalizeFilmDTOtoFilm(film, new Film(), id);
        listFilms.add(filmToAdd);
        System.out.println(filmToAdd);
        return "redirect:/film";
    }

}

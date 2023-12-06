package project.filmotheque.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import project.filmotheque.BO.Film;
import project.filmotheque.BO.Genre;
import project.filmotheque.BO.Participant;
import project.filmotheque.Controllers.DTO.FilmDTO;
import project.filmotheque.Repository.FilmDAO;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmDAO filmDao;

    // @Autowired
    public FilmServiceImpl(FilmDAO filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public Optional<Film> findFilmById(long id) {
        return filmDao.findFilmById(id);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmDao.findAllFilms();
    }

    @Override
    public List<Genre> getListGenre() {
        return filmDao.getListGenre();
    }

    @Override
    public List<Participant> getParticipants() {
        return filmDao.getParticipants();
    }

    @Override
    public Genre findGenreByID(int id) {
        return filmDao.findGenreByID(id);
    }

    @Override
    public Participant findParticipantByID(int id) {
        return filmDao.findParticipantByID(id);
    }

    @Override
    public long generateId() {
        return ThreadLocalRandom.current().nextLong();
    }

    @Override
    public Film normalizeFilmDTOtoFilm(FilmDTO film, Film filmToAdd, long id) {
        BeanUtils.copyProperties(film, filmToAdd);
        filmToAdd.setId(id);
        filmToAdd.setGenre(findGenreByID(Integer.parseInt(film.getGenre())));
        filmToAdd.setRealisateur(findParticipantByID(Integer.parseInt(film.getRealisateur())));
        for (String idActeur : film.getActeurs()) {
            int ids = Integer.parseInt(idActeur);
            Participant acteur = findParticipantByID(ids);
            if (filmToAdd.getActeurs() == null) {
                filmToAdd.ajouterActeur(acteur);
            } else {
                filmToAdd.ajouterActeurs(acteur);
            }
        }
        return filmToAdd;
    }

}

package project.filmotheque.Services;

import java.util.List;
import java.util.Optional;
import project.filmotheque.BO.Film;
import project.filmotheque.BO.Genre;
import project.filmotheque.BO.Participant;
import project.filmotheque.Controllers.DTO.FilmDTO;

public interface FilmService {

    Optional<Film> findFilmById(long id);

    List<Film> findAllFilms();

    List<Genre> getListGenre();

    List<Participant> getParticipants();

    Genre findGenreByID(int id);

    Participant findParticipantByID(int id);

    Film normalizeFilmDTOtoFilm(FilmDTO film, Film filmToadd, long id);

    long generateId();

}

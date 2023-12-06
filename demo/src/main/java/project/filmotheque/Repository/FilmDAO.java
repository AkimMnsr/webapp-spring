package project.filmotheque.Repository;

import java.util.List;
import java.util.Optional;

import project.filmotheque.BO.Film;
import project.filmotheque.BO.Genre;
import project.filmotheque.BO.Participant;

public interface FilmDAO {

    Optional<Film> findFilmById(long id);

    List<Film> findAllFilms();

    public List<Genre> getListGenre();

    public List<Participant> getParticipants();

    public Genre findGenreByID(int id);

    public Participant findParticipantByID(int id);
}

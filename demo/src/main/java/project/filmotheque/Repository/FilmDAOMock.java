package project.filmotheque.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import project.filmotheque.BO.Film;
import project.filmotheque.BO.Genre;
import project.filmotheque.BO.Participant;

@Repository
public class FilmDAOMock implements FilmDAO {

        private static List<Film> lstFilms = new ArrayList<>();
        private static List<Genre> lstGenres = new ArrayList<>();
        private static List<Participant> lstParticipants = new ArrayList<>();
        private static long indexFilms = 1;

        private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
                        "Drame" };

        public FilmDAOMock() {
                simulationCoucheDALetDB();
        }

        @Override
        public Optional<Film> findFilmById(long id) {

                return lstFilms.stream().filter(film -> film.getId() == id).findFirst();
        }

        public Optional<Participant> findParticipantById(long id) {

                return lstParticipants.stream().filter(participant -> participant.getId() == id).findFirst();
        }

        @Override
        public List<Genre> getListGenre() {
                return lstGenres;
        }

        @Override
        public Genre findGenreByID(int id) {
                return lstGenres.stream()
                                .filter(genre -> genre.getId() == id)
                                .findFirst()
                                .orElse(null);
        }

        @Override
        public Participant findParticipantByID(int id) {
                return lstParticipants.stream()
                                .filter(part -> part.getId() == id)
                                .findFirst()
                                .orElse(null);
        }

        @Override
        public List<Participant> getParticipants() {
                return lstParticipants;
        }

        @Override
        public List<Film> findAllFilms() {
                return lstFilms;
        }

        /**
         * Cette méthode permet de simuler le stockage en base de données et la remontée
         * d'information
         */
        public void simulationCoucheDALetDB() {
                // Création de la liste des genres
                for (int index = 0; index < genres.length; index++) {
                        lstGenres.add(new Genre(index + 1, genres[index]));
                }

                // Création de la liste des participants aux films (acteurs et réalisateurs)
                // 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
                lstParticipants.add(new Participant(1, "Spielberg", "Steven", true));
                lstParticipants.add(new Participant(2, "Cronenberg", "David", true));
                lstParticipants.add(new Participant(3, "Boon", "Dany", true));

                // 2 acteurs par film et l'un d'eux dans 2 films
                lstParticipants.add(new Participant(4, "Attenborough", "Richard", false));
                lstParticipants.add(new Participant(5, "Goldblum", "Jeff", false));
                lstParticipants.add(new Participant(6, "Davis", "Geena", false));
                lstParticipants.add(new Participant(7, "Rylance", "Mark", false));
                lstParticipants.add(new Participant(8, "Barnhill", "Ruby", false));
                lstParticipants.add(new Participant(9, "Merad", "Kad", false));

                // Création de la liste de films
                // 4 films
                Film jurassicPark = new Film(indexFilms++,
                                "Jurassic Park",
                                "Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.",
                                128, 1993,
                                lstGenres.get(1), findParticipantById(1).get(),
                                "https://fr.web.img4.acsta.net/pictures/20/07/21/16/53/1319265.jpg");
                // Associer les acteurs
                jurassicPark.ajouterActeurs(findParticipantById(4).get(),
                                findParticipantById(5).get());
                lstFilms.add(jurassicPark);

                Film theFly = new Film(indexFilms++, "The Fly",
                                "Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.",
                                95, 1986,
                                lstGenres.get(1),
                                findParticipantById(2).get(),
                                "https://m.media-amazon.com/images/M/MV5BODcxMGMwOGEtMDUxMi00MzE5LTg4YTYtYjk1YjA4MzQxNTNlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");
                // Associer les acteurs
                theFly.ajouterActeurs(findParticipantById(5).get(),
                                findParticipantById(6).get());
                lstFilms.add(theFly);

                Film theBFG = new Film(indexFilms++, "The BFG",
                                "Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.",
                                117, 2016,
                                lstGenres.get(4),
                                findParticipantById(1).get(),
                                "https://m.media-amazon.com/images/M/MV5BNjAzOTUzNTY3Ml5BMl5BanBnXkFtZTgwMjYwNzE5ODE@._V1_FMjpg_UX1000_.jpg");

                // Associer les acteurs
                theBFG.ajouterActeurs(findParticipantById(7).get(),
                                findParticipantById(8).get());
                lstFilms.add(theBFG);

                Film bienvenueChezLesChtis = new Film(indexFilms++,
                                "Bienvenue chez les Ch'tis",
                                "Philippe Abrams est directeur de la poste de Salon-de-Provence. Il est marié à Julie, dont le caractère dépressif lui rend la vie impossible. Pour lui faire plaisir, Philippe fraude afin d'obtenir une mutation sur la Côte d'Azur. Mais il est démasqué: il sera muté à Bergues, petite ville du Nord.",
                                106, 2008, lstGenres.get(4),
                                findParticipantById(3).get(),
                                "https://fr.web.img5.acsta.net/medias/nmedia/18/64/74/53/18889951.jpg");
                // Associer les acteurs
                bienvenueChezLesChtis.ajouterActeurs(findParticipantById(3).get(),
                                findParticipantById(9).get());
                lstFilms.add(bienvenueChezLesChtis);

        }

}

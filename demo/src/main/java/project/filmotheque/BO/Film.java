package project.filmotheque.BO;

import java.util.ArrayList;
import java.util.List;

public class Film {

    private long id;
    private String titre;
    private String synopsis;
    private int duree;
    private int annee;
    private Genre genre;
    private Participant realisateur;
    private List<Participant> acteurs;
    public String image;

    public Film() {
        acteurs = new ArrayList<>();
    }

    public Film(String titre, String synopsis,
            int duree,
            int annee,
            Genre genre, Participant realisateur) {
        this();
        this.titre = titre;
        this.synopsis = synopsis;
        this.duree = duree;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
    }

    public Film(long id, String titre,
            String synopsis,
            int duree,
            int annee, Genre genre, Participant realisateur, String image) {
        this();
        this.id = id;
        this.titre = titre;
        this.synopsis = synopsis;
        this.duree = duree;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
        this.image = image;
    }

    public void ajouterActeur(Participant acteur) {
        this.acteurs.add(acteur);
    }

    public void ajouterActeurs(Participant... acteurs) {
        for (Participant acteur : acteurs) {
            this.ajouterActeur(acteur);
        }
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // @Override
    // public String toString() {
    // return "Film [id=" + id + ", titre=" + titre + ", synopsis=" + synopsis + ",
    // duree=" + duree + ", annee="
    // + annee + "]";
    // }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", titre=" + titre + ", synopsis=" + synopsis + ", duree=" + duree + ", annee="
                + annee + ", genre=" + genre + ", realisateur=" + realisateur + ", acteurs=" + acteurs + "]" + image;
    }
}

package project.filmotheque.Controllers.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class FilmDTO {

    private long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @Size(min = 20, max = 120, message = "Le synopsis doit contenir au maximum 120 caractères")
    private String synopsis;

    @Min(60)
    @NotBlank(message = "La durée est obligatoire")
    private int duree;

    @Min(1900)
    @NotBlank(message = "L'année est obligatoire")
    private int annee;

    private String genre;

    private String realisateur;

    @NotEmpty(message = "Au moins un acteur est requis")
    @Size(min = 1, message = "Au moins un acteur est requis")
    private String[] acteurs;

    @NotBlank(message = "Précisez une URL d'image")
    private String image;

    public FilmDTO() {

    }

    public FilmDTO(String titre, String synopsis,
            int duree,
            int annee,
            String genre, String realisateur, String[] acteurs, String image) {
        this.titre = titre;
        this.synopsis = synopsis;
        this.duree = duree;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.image = image;
    }

    public FilmDTO(long id, String titre,
            String synopsis,
            int duree,
            int annee, String genre, String realisateur, String[] acteurs, String image) {
        this();
        this.id = id;
        this.titre = titre;
        this.synopsis = synopsis;
        this.duree = duree;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.image = image;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setActeurs(String[] nouveauxActeurs) {
        this.acteurs = nouveauxActeurs;
    }

    public String[] getActeurs() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public String toString() {
        StringBuilder acteursList = new StringBuilder("[");
        for (int i = 0; i < acteurs.length; i++) {
            acteursList.append(acteurs[i]);
            if (i < acteurs.length - 1) {
                acteursList.append(", ");
            }
        }
        acteursList.append("]");

        return "Film [id=" + id + ", titre=" + titre + ", synopsis=" + synopsis + ", duree=" + duree + ", annee="
                + annee + ", genre=" + genre + ", realisateur=" + realisateur + ", acteurs=" + acteursList.toString() +
                " urlImage=" + image;
    }
}

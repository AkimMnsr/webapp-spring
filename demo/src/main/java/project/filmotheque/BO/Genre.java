package project.filmotheque.BO;

public class Genre {

    private long id;
    private String libelle;

    public Genre() {
    }

    public Genre(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Genre [id=" + id + ", libelle=" + libelle + "]";
    }

}

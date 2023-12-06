package project.filmotheque.BO;

public class Participant {
    private long id;
    private String prenom;
    private String nom;
    private boolean isReal;

    public Participant() {
    }

    public Participant(String prenom, String nom) {
        super();
        this.prenom = prenom;
        this.nom = nom;

    }

    public Participant(long id, String prenom, String nom, boolean isReal) {
        super();
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.isReal = isReal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsReal() {
        return isReal;
    }

    public void setIsReal(boolean isReal) {
        this.isReal = isReal;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Participant [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
    }

}

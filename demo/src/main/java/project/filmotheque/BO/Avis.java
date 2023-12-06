package project.filmotheque.BO;

public class Avis {

    private int ID;
    private int note;
    private String message;

    public Avis(int ID, int note, String message) {
        this.ID = ID;
        this.note = note;
        this.message = message;
    }

    public String toString() {
        return "Note : " + this.note + "\n" +
                "Message : " + this.message;
    }

}

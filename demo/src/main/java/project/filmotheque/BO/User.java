package project.filmotheque.BO;

public class User {

    private int ID;
    private String name;
    private String surname;
    private Boolean isAdmin;

    public User(int ID, String name, String surname, Boolean isAdmin) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

}

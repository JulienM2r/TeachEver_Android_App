package um2.ips.teachever.Entities;

import java.sql.Date;
import java.util.ArrayList;


/**
 * Création d'un um2.ips.teachever.Entities.Parent pour utilisation  de SQLite sous Android
 */
public class Parent {
    private int id;
    private String nom;
    private String prenom;
    private String Email;
    private String password;
    private ArrayList<Eleve> Enfant;


    public Parent(){}

    public Parent(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

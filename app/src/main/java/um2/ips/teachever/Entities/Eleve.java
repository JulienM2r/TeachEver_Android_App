package um2.ips.teachever.Entities;

import java.sql.Date;

/**
 * Création d'un um2.ips.teachever.Entities.Eleve pour utilisation  de SQLite sous Android
 */
public class Eleve {
    private int id;
    private String nom;
    private String prenom;
    private String Email;
    private String password;
    private String AnneeScolaire;
    private Abonnement Abonnement;


    public Eleve(){}

    public Eleve(String nom, String prenom, String email, String password, String Annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
        this.AnneeScolaire = Annee;
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

    public String getAnneeScolaire() {
        return AnneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        AnneeScolaire = anneeScolaire;
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

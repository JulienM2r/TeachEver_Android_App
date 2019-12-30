package um2.ips.teachever.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Création d'un um2.ips.teachever.Entities.Parent pour utilisation  de SQLite sous Android
 */
@Entity
public class Parent {
    @PrimaryKey
    private String id;
    private String nom;
    private String prenom;
    @NonNull
    private String Email;
    private String password;
    private ArrayList<Eleve> Enfant;


    public Parent(){}

    @Ignore
    public Parent(String nom, String prenom, String email, String password) {
        id = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
    }
    public Parent(String id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

package um2.ips.teachever.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.UUID;

/**
 * Création d'un um2.ips.teachever.Entities.Eleve pour utilisation  de SQLite sous Android
 */

@Entity(tableName = Eleve.TABLE_NAME)
public class Eleve {

    /** The name of the Eleve table. */
    public static final String TABLE_NAME = "eleves";
    /** The name of the Email column. */
    public static final String COLUMN_Email = "email";


    @PrimaryKey
    private String id;
    private String nom;
    private String prenom;
    public String name;

    /** The email of the Eleve. */
//    @NonNull
    @ColumnInfo(name = COLUMN_Email)
    private String Email;
    private String password;
    private String AnneeScolaire;
    private Abonnement Abonnement;


    public Eleve(){}

    @Ignore
    public Eleve(String nom, String prenom, String email, String password, String Annee, Abonnement Abonnement) {
        this.id = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
        this.AnneeScolaire = Annee;
        this.Abonnement = Abonnement;
    }



    public Eleve(String id, String nom, String prenom, String email, String password, String Annee, Abonnement Abonnement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
        this.AnneeScolaire = Annee;
        this.Abonnement = Abonnement;
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

    public um2.ips.teachever.Entities.Abonnement getAbonnement() {return Abonnement;
    }
    public void setAbonnement(um2.ips.teachever.Entities.Abonnement abonnement) {
        this.Abonnement = abonnement;
    }

}

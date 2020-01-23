package um2.ips.teachever.Entities;

import android.content.ContentValues;
import android.provider.BaseColumns;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * CrÃ©ation d'un Eleve pour utilisation  de SQLite sous Android
 */
@Entity(tableName = Eleve.TABLE_NAME, indices ={@Index(value=Eleve.COLUMN_Email, unique=true)})
public class Eleve {

    /** The name of the ID column. */
    public static final String COLUMN_ID = BaseColumns._ID;
    /** The name of the Eleve table. */
    public static final String TABLE_NAME = "eleves";
    /** The name of the Email column. */
    public static final String COLUMN_Email = "email";
    /** The name of the Nom column. */
    public static final String COLUMN_Nom = "nom";
    /** The name of the Prenom column. */
    public static final String COLUMN_Prenom = "prenom";
    /** The name of the Password column. */
    public static final String COLUMN_Password = "password";
    /** The name of the Anneee-Scolaire column. */
    public static final String COLUMN_AnneeScolaire = "annee_scolaire";
    /** The name of the Abonnement column. */
    public static final String COLUMN_Abonnement = "abonnement";


    /** The id of the Eleve. */
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    private long id;
    /** The nom of the Eleve. */
    @ColumnInfo(name = COLUMN_Nom)
    private String nom;
    /** The prenom of the Eleve. */
    @ColumnInfo(name = COLUMN_Prenom)
    private String prenom;
    /** The email of the Eleve. */
    @ColumnInfo(name = COLUMN_Email)
    @NonNull
    private String Email;
    /** The password of the Eleve. */
    @ColumnInfo(name = COLUMN_Password)
    public String password;
    /** The Annee_Scolaire of the Eleve. */
    @ColumnInfo(name = COLUMN_AnneeScolaire)
    private String AnneeScolaire;
    /** The Abonnement of the Eleve. */
    @ColumnInfo(name = COLUMN_Abonnement)
    private String Abonnement;


    public Eleve(){}

    @Ignore
    public Eleve(String nom, String prenom, String email, String password, String Annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
        this.AnneeScolaire = Annee;
    }



   /* public Eleve(String id, String nom, String prenom, String email, String password, String Annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.Email = email;
        this.password = password;
        this.AnneeScolaire = Annee;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAnneeScolaire() {
        return AnneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        AnneeScolaire = anneeScolaire;
    }

    /**
     * Create a new {@link Eleve} from the specified {@link ContentValues}.
     *
     * @param values A {@link ContentValues} that at least contain {@link #COLUMN_Email}.
     * @return A newly created {@link Eleve} instance.
     */
    public static Eleve fromContentValues(ContentValues values) {
        final Eleve eleve = new Eleve();
        if (values.containsKey(COLUMN_ID)) {
            eleve.id = values.getAsLong(COLUMN_ID);
        }
        if (values.containsKey(COLUMN_Email)) {
            eleve.Email = values.getAsString(COLUMN_Email);
        }
        return eleve;
    }

    public String getAbonnement() {return Abonnement;
    }
    public void setAbonnement(String abonnement) {
        this.Abonnement = abonnement;
    }

}

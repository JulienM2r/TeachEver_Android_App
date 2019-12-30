package um2.ips.teachever.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Cours {
    @PrimaryKey
    @ColumnInfo (name = "id")
    private int CoursId;
    private String nom;
    private Annee niveau;
    private Matiere Matiere;
    private ArrayList<Lecons> lecons;

}

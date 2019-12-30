package um2.ips.teachever.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Lecons {
    @PrimaryKey
    private int id;
    private String nom;
    private Annee niveau;
    private Matiere Matiere;
    private Cours Cours;
    private ArrayList<Exercice> Exos;
    private ArrayList<QCM> QCM;



}

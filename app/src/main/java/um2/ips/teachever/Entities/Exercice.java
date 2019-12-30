package um2.ips.teachever.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Exercice {
    @PrimaryKey
    private int id;
    private int num;
    private String nom;
    private Annee niveau;
    private Matiere Matiere;
    private Lecons lecons;




}

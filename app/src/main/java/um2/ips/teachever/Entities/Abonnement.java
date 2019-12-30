package um2.ips.teachever.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Abonnement {
    @PrimaryKey
    private String Type;
    private String Duree;
    private Double Montant;

}

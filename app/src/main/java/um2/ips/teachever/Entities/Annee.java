package um2.ips.teachever.Entities;

public enum Annee {
    //Objets directement construits
    CP("Cours Primaire"),
    CM1("CM1"),
    CM2("CM2"),
    CE1("CE1"),
    CE2("CE2"),
    Sixieme("6eme"),
    Cinquieme("5eme"),
    Quatrieme("4eme"),
    Troisieme("3eme"),
    Seconde("2nd"),
    Premiere("1ere"),
    Terminale("Terminale");

    private int id;
    private String annee;


    //Constructeur
    Annee(String annee){
        this.annee = annee;
    }

    public String toString(){
        return annee;
    }
}

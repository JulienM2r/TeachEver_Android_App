package um2.ips.teachever.Entities;

public enum Matiere {
    //Objets directement construits
    Math("Mathématique"),
    Geo("Géographie"),
    Chimie("Chimie"),
    Francais("Français"),
    Anglais("Anglais"),
    Bio("Biologie"),
    Histoire("Histoire");

    private int id;
    private String matiere;

    //Constructeur
    Matiere(String matiere){
        this.matiere = matiere;
    }

    public String toString(){
        return matiere;
    }
}

 public class Personnage {
     String nom;
     int pointsDeVie;
     int[] attaque;


    // Promotion de propriété possible pour éviter redondance de code
     public Personnage(String nom, int pointsDeVie, int[] attaque) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.attaque = attaque;
    }
}

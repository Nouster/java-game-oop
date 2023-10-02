import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {



    public static void main(String[] args) throws FileNotFoundException {
        LoadMap.loadMap("lvl1.map");

        Joueur.playerLocation();
        Scanner scanner = new Scanner(System.in);

        // Créer les personnages
        Personnage personnage1 = new Guerrier();
        Personnage personnage2 = new Mage();
        Personnage personnage3 = new Animal();

         
        System.out.print("\n Liste des personnages disponibles :\n \n 1. " + personnage1.nom + "\n 2. "
                + personnage2.nom + "\n 3. " + personnage3.nom + "\n ");

        Joueur.selectedPersonnage();
        
        scanner.close();
    }
    
  
}

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    String nom;
    Personnage personnage;
    int ligne;
    int colonne;

    Joueur(String nom) {
        this.nom = nom;
    }

    public void selectionnerPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public void attaquer(Joueur adversaire) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(this.personnage.nom + ", choisis ton attaque (1-4) :");

        // gestion d'erreur en cas d'entrée invalide 
        while (!scanner.hasNextInt()) {
            System.out.println(" Entre un nombre valide (1-4) : ");
            scanner.next();
        }

        int choixAttaque = scanner.nextInt();

        if (choixAttaque >= 1 && choixAttaque <= this.personnage.attaque.length) {

            // Le début de mon tableau commence à 0 mais les choix des attaques sont décalés
            int attaque = this.personnage.attaque[choixAttaque - 1];
            System.out.println(this.personnage.nom + " attaque avec " + attaque + " points de dégâts !");
            adversaire.personnage.pointsDeVie -= attaque; // Réduction des points de vie du personnage adverse
            System.out.println(adversaire.personnage.nom + " a maintenant " + adversaire.personnage.pointsDeVie
                    + " points de vie.");
        } else {
            // Je me fais une gestion d'erreur en cas d'entrée utilisateur invalide (Peut-être évacuer le scénario d'erreur dès le départ)
            // Peut-être que je pourrai throw une exception / Consommer l'entrée et redemander une saisie
            System.out.println("Choix d'attaque invalide. Tu perds un tour.");
            adversaire.attaquer(this);

        }
    }

    public static void selectedPersonnage() {
        Personnage personnage1 = new Guerrier();
        Personnage personnage2 = new Mage();
        Personnage personnage3 = new Animal();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Joueur 1, sélectionne ton personnage (1-3) : ");
        int choixJoueur1 = scanner.nextInt();
        System.out.println("Joueur 2, sélectionne ton personnage (1-3) : ");
        int choixJoueur2 = scanner.nextInt();

        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        switch (choixJoueur1) {
            case 1:
                joueur1.selectionnerPersonnage(personnage1);
                break;
            case 2:
                joueur1.selectionnerPersonnage(personnage2);
                break;
            case 3:
                joueur1.selectionnerPersonnage(personnage3);
                break;

            default:
                System.out.println("Choix invalide pour Joueur 1.");
                break;
        }

        switch (choixJoueur2) {
            case 1:
                joueur2.selectionnerPersonnage(personnage1);
                break;
            case 2:
                joueur2.selectionnerPersonnage(personnage2);
                break;
            case 3:
                joueur2.selectionnerPersonnage(personnage3);
                break;

            default:
                System.out.println("Choix invalide pour Joueur 2.");
                break;
        }
        while (joueur1.personnage.pointsDeVie > 0 && joueur2.personnage.pointsDeVie > 0) {
            joueur1.attaquer(joueur2);
            if (joueur2.personnage.pointsDeVie <= 0) {
                System.out.println(joueur1.personnage.nom + " remporte la victoire !");
                break;
            }

            joueur2.attaquer(joueur1);
            if (joueur1.personnage.pointsDeVie <= 0) {
                System.out.println(joueur2.personnage.nom + " remporte la victoire !");
                break;
            }
        }

        scanner.close();
    }

    public static void playerLocation() throws FileNotFoundException {
        ArrayList<String> map = LoadMap.getMap();

        // Parcours de la carte pour trouver la localisation du joueur
        for (int i = 0; i < map.size(); i++) {
            String line = map.get(i);
            System.out.println("[debug] la ligne est :" + line);
            for (int j = 0; j < line.length(); j++) {
                char cell = line.charAt(j);
                if (cell == 'P') {
                    System.out.println("Le joueur se trouve à la ligne " + (i + 1) + " et à la colonne " + (j + 1));
                    
                    return; // Je sors si joueur trouvé
                }
            }
        }

        // Plus tard, implémenter gestion erreur
        System.out.println("Le joueur n'a pas été trouvé sur la carte.");
    }

    public void setPosition(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

}
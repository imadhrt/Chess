package g58132.chess.view;

import g58132.chess.model.Position;
import java.util.Scanner;

/**
 *
 * @author elhar
 */
public class aaa {

    public static Position askPosition() {
        int row = LectureRobusteEntreMinEtMax(1, 8) - 1;
        int column = lectureRobusteChar();
        Position pos = new Position(row, column);
        return pos;
    }

    private static int LectutreRobusteEntier() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une ligne: ");
        while (!clavier.hasNextInt()) {
            System.out.println("Ceci n'est pas un entier!!!");
            System.out.println("Veuillez entrer un nombre entier");
            clavier.next();
        }
        return clavier.nextInt();
    }

    private static int LectureRobusteEntreMinEtMax(int min, int max) {
        int ligne = LectutreRobusteEntier();

        while (ligne < min || ligne > max) {
            System.out.println("La valeur n'est pas entre  1 et"
                    + "8!!!!!");
            System.out.println("Veuillez entrer un nombre compris entre 1 et 8:");
            ligne = LectutreRobusteEntier();
        }
        return ligne;

    }

    private static String lectureRobusteString() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une colonne:");
        String colonne = clavier.nextLine().toLowerCase();

        while (colonne.length() != 1 || !Character.isLetter(colonne.charAt(0))) {
            System.out.println("Entrez une lettre de l'alphabet de 'a' à 'h' :");
            colonne = clavier.nextLine();

        }
        return colonne;
    }

    private static int lectureRobusteChar() {

        int nb = -1;
        while (nb == 12 || nb == -1) {
            switch (lectureRobusteString().charAt(0)) {
                case 'a':
                    nb = 0;
                    break;
                case 'b':
                    nb = 1;
                    break;

                case 'c':
                    nb = 2;
                    break;

                case 'd':
                    nb = 3;
                    break;

                case 'e':
                    nb = 4;
                    break;

                case 'f':
                    nb = 5;
                    break;
                case 'g':
                    nb = 6;
                    break;
                case 'h':
                    nb = 7;
                    break;
                default:
                    nb = 12;

            }

        }

        return nb;

    }
    

    public static void main(String[] args) {
        String phrase = "Chers joueurs, Bienvenue au jeu d'échecs";
        String titre = "Echecs";
        System.out.println("=".repeat(phrase.length() + 8));
        System.out.println(" ".repeat((phrase.length() + 8) / 2)+titre);
        System.out.println("=".repeat(phrase.length() + 8));
        System.out.println("*".repeat(phrase.length() + 8));
        System.out.println("*".repeat(4) + phrase + "*".repeat(4));
        System.out.println("*".repeat(phrase.length() + 8));
        askPosition();

    }

}

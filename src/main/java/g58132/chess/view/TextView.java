package g58132.chess.view;

import g58132.chess.model.Color;
import g58132.chess.model.Model;
import g58132.chess.model.Piece;
import g58132.chess.model.Player;
import g58132.chess.model.Position;
import java.util.Objects;
import java.util.Scanner;

/**
 * Represent the view of the game to the user.
 *
 * @author elhar
 */
public class TextView implements View {

    private Model model;

    /**
     * Constructor of TextView
     *
     * Allows to initialise attribute model to value.
     *
     * @param model
     */
    public TextView(Model model) {
        this.model = model;

    }

    /**
     * Displays the title and a welcome message to the players.
     */
    @Override
    public void displayTitle() {
        String phrase = "Chers joueurs, je vous souhaite la bienvenue aux échecs.";
        String titre = "Échecs";
        System.out.println("=".repeat(phrase.length() + 8));
        System.out.println(" ".repeat((phrase.length() + 8) / 2) + titre);
        System.out.println("=".repeat(phrase.length() + 8));
        System.out.println("*".repeat(phrase.length() + 8));
        System.out.println("*".repeat(4) + phrase + "*".repeat(4));
        System.out.println("*".repeat(phrase.length() + 8));

    }

    /**
     * Displays the game board.
     */
    @Override
    public void displayBoard() {
        System.out.println(" ".repeat(3) + "-".repeat(41));
        for (int i = 8; i > 0; i--) { //i est la ligne de l'échiquier
            System.out.print(i + "  |");//j est la colonne d'échiquier
            for (int j = 0; j <= 7; j++) {

                Position pos = new Position(i - 1, j);
                Piece piece = model.getPiece(pos);
                if (piece == null) {
                    System.out.print(" ".repeat(4) + "|");
                } else if (Color.WHITE == piece.getColor()) {
                    System.out.print(" PB |");
                } else {
                    System.out.print(" PN |");
                }

            }
            System.out.println("");
            System.out.println(" ".repeat(3) + "-".repeat(41));

        }
        System.out.println(" ".repeat(5) + "a    b    c    d    e    f    g    h");

    }

    /**
     * Displays the winning player.
     */
    @Override
    public void displayWinner() {
        if (model.isGameOver()) {
            Player gagnant = model.getOppositePlayer();
            if (gagnant.getColor().equals(Color.BLACK)) {
                System.out.println("Le vainqueur de ce jeu est le joueur NOIR.");
            } else {
                System.out.println("Le vainqueur de ce jeu est le joueur BLANC.");

            }
        }

    }

    /**
     * Displays a message inviting the current player (white or black) to play.
     */
    @Override
    public void displayPlayer() {
        if (model.getCurrentPlayer().getColor().equals(Color.WHITE)) {
            System.out.println("***À votre tour, Joueur BLANC.*** ");

        } else {
            System.out.println("***À votre tour, Joueur NOIR.*** ");
        }

    }

    /**
     * Requests a valid position on the game board from the user.
     *
     * As long as the user input is not a valid position (row from 1 to 8 and
     * column from A to H
     *
     * @return a valid position
     */
    @Override
    public Position askPosition() {
        int row = LectureRobusteEntreMinEtMax(1, 8) - 1;//-1 car le tableau commence à 0
        int column = lectureRobusteChar();

        return new Position(row, column);
    }

    /**
     * Robust reading of an integer.
     *
     * As long as the user input is not an integer the method requests a new
     * input the method requests a new input
     *
     * @return the integer entered by the user
     */
    private static int LectutreRobusteEntier() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une ligne (1 à 8): ");
        while (!clavier.hasNextInt()) {
            System.out.println("Ceci n'est pas un entier!");
            System.out.println("Veuillez saisir un nombre entier:");
            clavier.next();
        }
        return clavier.nextInt();
    }

    /**
     * Robust reading of a bounded integer.
     *
     * As long as the user does not enter an integer between min and max the
     * method requests a new input.
     *
     * @param min is the minimum bound of an integer
     * @param max is the maximum bound of an integer
     * @return an integer between minimum and maximum
     */
    private static int LectureRobusteEntreMinEtMax(int min, int max) {
        int ligne = LectutreRobusteEntier();

        while (ligne < min || ligne > max) {
            System.out.println("La valeur n'est pas comprise entre 1 et 8 !");
            System.out.println("Veuillez saisir un nombre compris entre 1 et 8 :");
            ligne = LectutreRobusteEntier();
        }
        return ligne;

    }

    /**
     * Robust reading of a bounded string
     *
     * As long as the user input is not a sring of size 1 and containing a
     * letter the method requests a new input.
     *
     * @return the bounded String entered by the user
     */
    private static String lectureRobusteString() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une colonne (A à H):");
        String colonne = clavier.nextLine().toLowerCase();

        while (colonne.length() != 1 || !Character.isLetter(colonne.charAt(0))) {
            System.out.println("Entrez une lettre de A à H :");
            colonne = clavier.nextLine();

        }
        return colonne;
    }

    /**
     * Robust reading of a bounded character
     *
     * as long as the user input is not a letter of the alphabet between 'a' and
     * 'h'.
     *
     * @return a number of letters of the alphabet (corresponds to the index
     * of the table) between two bounded
     */
    private static int lectureRobusteChar() {

        int colonne = -1;
        while (colonne == 12 || colonne == -1) {
            colonne = switch (lectureRobusteString().charAt(0)) {
                case 'a' ->
                    0;
                case 'b' ->
                    1;
                case 'c' ->
                    2;
                case 'd' ->
                    3;
                case 'e' ->
                    4;
                case 'f' ->
                    5;
                case 'g' ->
                    6;
                case 'h' ->
                    7;
                default ->
                    12;
            };

        }

        return colonne;

    }

    /**
     * Displays the error message
     *
     * @param message is an error message
     */
    @Override

    public void displayError(String message) {
        System.out.println(message);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.model);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TextView other = (TextView) obj;
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return true;
    }

}

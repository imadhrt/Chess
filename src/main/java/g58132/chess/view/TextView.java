package g58132.chess.view;

import g58132.chess.model.Color;
import g58132.chess.model.Model;
import g58132.chess.model.Piece;
import g58132.chess.model.Player;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reprsent the view of the game to the user.
 *
 * @author elhar
 */
public class TextView implements View {

    private Model model;

    /**
     * Constructor of textView
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
        String phrase = "Chers joueurs, Bienvenue au jeu d'échecs";
        String titre = "Echecs";
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
        int ligne = 7;//ligne du tableau
        int colonne = 0;//colonne du tableau
        System.out.println(" ".repeat(3) + "-".repeat(40));
        for (int i = 8; i > 0; i--) { //i est la ligne de l'echequier
            System.out.print(i + "  |");//j est la colonne d'echquier
            for (int j = 0; j < 8; j++) {
                if (colonne == 8) {
                    ligne--;
                    colonne = 0;

                }
                Position pos = new Position(ligne, colonne);
                Piece piece = model.getPiece(pos);
                if (piece == null) {
                    System.out.print(" ".repeat(4) + "|");
                } else if (Color.WHITE == piece.getColor()) {
                    System.out.print(" PB |");
                } else {
                    System.out.print(" PN |");
                }

                colonne++;

            }
            System.out.println("");
            System.out.println(" ".repeat(3) + "-".repeat(40));

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
            System.out.println("Le gagnant de la partie est le joueur" + gagnant);
        }

    }

    /**
     * Displays a message inviting the current player (white or black) to play.
     */
    @Override
    public void displayPlayer() {
        if (model.getCurrentPlayer().getColor().equals(Color.WHITE)) {
            System.out.println("Vous pouvez jouer le joueur blanc " + model.getCurrentPlayer().getColor());

        } else {
            System.out.println("Vous pouvez jouer le joueur noir " + model.getCurrentPlayer().getColor());
        }

    }

    /**
     * Requests a valid position on the game board from the user.
     *
     * As long as the user input is not a valid position(row from 1 to 8 and
     * column from 'a' to 'h'
     *
     * @return a valid position
     */
    @Override
    public Position askPosition() {
        int row = LectureRobusteEntreMinEtMax(1, 8) - 1;//-1 car le tableau commence à 0
        int column = lectureRobusteChar();
        Position pos = new Position(row, column);
        return pos;
    }

    /**
     * Robust reading of an integer.
     *
     * As long as the user input is not an integer the method requests a new
     * input the methode requests a new input
     *
     * @return the integer entered by the user
     */
    private static int LectutreRobusteEntier() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une ligne: ");
        while (!clavier.hasNextInt()) {
            System.out.println("Ceci n'est pas un entier!!!");
            System.out.println("Veuillez entrer un nombre entier:");
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
            System.out.println("La valeur n'est pas entre 1 et "
                    + " 8!!!!!");
            System.out.println("Veuillez entrer un nombre compris entre 1 et 8:");
            ligne = LectutreRobusteEntier();
        }
        return ligne;

    }

    /**
     * Robust reading of a bounded string
     *
     * As long as the user input is not an Sring of size 1 and containig a
     * letter the method requests a new input.
     *
     * @return the bounded String entered by the user.
     */
    private static String lectureRobusteString() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une colonne:");
        String colonne = clavier.nextLine().toLowerCase();

        while (colonne.length() != 1 || !Character.isLetter(colonne.charAt(0))) {
            System.out.println("Entrez une lettre de 'a' à 'h' :");
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
     * @return a the number of letter of the alphabet (corresponds to the index
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
     * displays the error message
     *
     * @param message is an error message
     */
    @Override

    public void displayError(String message) {
        System.out.println(message);

    }

}

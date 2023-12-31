package g58132.chess.model;

import g58132.chess.model.pieces.Bishop;
import g58132.chess.model.pieces.King;
import g58132.chess.model.pieces.Knight;
import g58132.chess.model.pieces.Pawn;
import g58132.chess.model.pieces.Piece;
import g58132.chess.model.pieces.Queen;
import g58132.chess.model.pieces.Rook;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * represents an action on the game and shows the state of the game
 *
 * @author elhar
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    private King whiteKing;
    private King blackKing;
    private GameState state;

    /**
     * Constructor of game
     *
     * Allows to initialise attribute to instance (value)
     *
     */
    public Game() {
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
        this.board = new Board();
        this.state = GameState.PLAY;
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        this.currentPlayer = this.white;

        for (int colonne = 0; colonne < 8; colonne++) {

            optimizedStart(1, Color.WHITE);
            optimizedStart(6, Color.BLACK);

        }
        //Tour Blanc
        board.setPiece(new Rook(Color.WHITE), new Position(0, 0));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 7));
        //Tour noir
        board.setPiece(new Rook(Color.BLACK), new Position(7, 0));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 7));

        //Cavalier Blanc
        board.setPiece(new Knight(Color.WHITE), new Position(0, 1));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 6));

        //Cavalier Blanc
        board.setPiece(new Knight(Color.BLACK), new Position(7, 1));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 6));

        //Fou blanc
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 5));
        //Fou noir
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 5));
        // Reine Blanc
        board.setPiece(new Queen(Color.WHITE), new Position(0, 3));
        //Reine Noir
        board.setPiece(new Queen(Color.BLACK), new Position(7, 3));
        // initialiser roi blan et noir
        this.whiteKing = new King(Color.WHITE);
        this.blackKing = new King(Color.BLACK);

        //Roi Blanc
        board.setPiece(whiteKing, new Position(0, 4));
        //Roi Noir
        board.setPiece(blackKing, new Position(7, 4));

    }

    /**
     * Initalize pawn
     *
     * @param initialPos is a row on the board
     * @param col is a color pawn
     */
    private void optimizedStart(int initialPos, Color col) {
        for (int colonne = 0; colonne < 8; colonne++) {
            board.setPiece(new Pawn(col), new Position(initialPos, colonne));

        }

    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le"
                    + " plateau ");
        }
        return this.board.getPiece(pos);

    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        return this.currentPlayer == white ? black : white;

    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position n'est pas sur le"
                    + " plateau ");
        }
        return this.board.getPiece(pos).getColor() == currentPlayer.getColor();
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * movement is valid change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     *
     *
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if ((!board.contains(newPos)) || (!board.contains(oldPos))) {
            throw new IllegalArgumentException("La position n'est pas sur le "
                    + "plateau.");
        }
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("la position  ne "
                    + " contient pas de pièce");
        }
        if (getPiece(oldPos).getColor() != currentPlayer.getColor()) {
            throw new IllegalArgumentException("La piece n'appartient pas au "
                    + " joueur actuel");
        }
        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("Le coup n'est pas valable pour "
                    + " la pièce située à la position actuelle  ");

        }

        if (isValidMove(oldPos, newPos)) {

            this.board.setPiece(getPiece(oldPos), newPos);
            this.board.dropPiece(oldPos);
            this.currentPlayer = getOppositePlayer();
            Position posPawnWhite=board.pawnWhite();
            if(posPawnWhite!=null){
                board.dropPiece(posPawnWhite);
                board.setPiece(new Queen(Color.WHITE), posPawnWhite);
            }
            Position  posPawnBlack=board.pawnBlack();
            if(posPawnBlack!=null){
                board.dropPiece(posPawnBlack);
                board.setPiece(new Queen(Color.BLACK), posPawnBlack);
            }
           
               if (isCheckKing()) {
                state = GameState.CHECK;
                if (positionValid().isEmpty()) {
                    state = GameState.CHECK_MATE;
                }
            } else if (positionValid().isEmpty()) {
                state = GameState.STALE_MATE;

            } else {
                state = GameState.PLAY;
            }


        }}

    /**
     * Contains opposing king
     *
     * allows to check in the getCapture of the current player if it contains
     * the opponent king
     *
     * @return true if contains opposite king otherwise false
     */
    private boolean isCheckKing() {
        List<Position> pos = getCapturePositions(getOppositePlayer());
        return pos.contains(board.getPiecePosition(kingCurrentPlayer()));

    }

    /**
     * valid position in getPossibleMove
     *
     * allows to check in all the moves of a player if there are valid movements
     * and add to the list
     *
     * @return the list of all valid movements
     */
    private List<Position> positionValid() {
        List<Position> listePos = new ArrayList();
        List<Position> pos = board.getPositionOccupiedBy(this.currentPlayer);
        for (Position position : pos) {
            for (Position positionValide : this.getPiece(position).getPossibleMoves(position, board)) {
                if (isValidMove(position, positionValide)) {
                    listePos.add(positionValide);

                }

            }
        }
        return listePos;

    }

    /**
     * King of the current player
     *
     * @return whiteKing if the current player is white otherwise blackKing
     */
    private King kingCurrentPlayer() {

        return this.currentPlayer == white ? whiteKing : blackKing;
    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is in stale mate or check mate otherwise false.
     */
    @Override
    public boolean isGameOver() {
        return state == GameState.STALE_MATE || state == GameState.CHECK_MATE;

    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return this.board.getPiece(position).getPossibleMoves(position, board);

    }

    /**
     * Accessory of state
     *
     * Allows access to the value of the state attribute.
     *
     * @return the value of the state attribute
     */
    @Override
    public GameState getState() {
        return this.state;
    }

    /**
     * Is valide move
     *
     * allows to check that the movement of a piece from the oldPos position to
     * the newPos position is valid.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @return true if the move is possible or false it is not.
     * @throws IllegalArgumentException the starting position oldPos does not
     * contain piece.
     * @throws IllegalArgumentException moving the piece from oldPos to newPos
     * is not a possible move for the piece in question.
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        boolean isContainsKing = true;
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position départ ne contient aucune pièce");
        }
        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("Le coup n'est pas valable pour "
                    + " la pièce située à la position actuelle  ");
        }

        Piece stockNexpos = board.getPiece(newPos); //on verifie si newPos ne contient pas nulle
        //et pas de la même de la couleur et dans ce cas on dropPiece
        if (stockNexpos != null && stockNexpos.getColor() != this.currentPlayer.getColor()) {
            board.dropPiece(newPos);
        }
        Piece stockOldPos = getPiece(oldPos); //pour sauvegarder la oldpos car après on drop olpos

        //je simule la piece
        this.board.setPiece(stockOldPos, newPos);
        this.board.dropPiece(oldPos);

        if (getCapturePositions(getOppositePlayer()).contains(board.getPiecePosition(kingCurrentPlayer()))) {// verifie si contient le roi courant dans les getCapptures du joueur opposé
            isContainsKing = false;
        }
        //je remet les piece à l'initial
        this.board.setPiece(stockOldPos, oldPos);
        this.board.dropPiece(newPos);
        board.setPiece(stockNexpos, newPos);

        return isContainsKing;

    }

    /**
     * Current King
     *
     * allows to check the current king
     *
     * @return the black king if the current player is white and white king if
     * it is black
     */
    /**
     * Capture position
     *
     * Allows to determine all the positions in which a player can capture
     * another piece.
     *
     * @param player is a color player
     * @return all positions at which the player can capture another piece
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> listePos = new ArrayList();
        List<Position> pos = board.getPositionOccupiedBy(player);
        for (Position position : pos) {
            listePos.addAll(this.getPiece(position).getCapturePositions(position, board));

        }

        return listePos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.board);
        hash = 97 * hash + Objects.hashCode(this.white);
        hash = 97 * hash + Objects.hashCode(this.black);
        hash = 97 * hash + Objects.hashCode(this.currentPlayer);
        return hash;
    }

    /**
     * Equals
     *
     * Allows to compare if the two object are equals.
     *
     * @param obj is an object
     * @return true if theys are equals and false if they are not equals
     */
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.white, other.white)) {
            return false;
        }
        if (!Objects.equals(this.black, other.black)) {
            return false;
        }
        if (!Objects.equals(this.currentPlayer, other.currentPlayer)) {
            return false;
        }
        return true;
    }

}

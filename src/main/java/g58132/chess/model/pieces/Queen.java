package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the queen on the game.
 *
 * @author elhar
 */
public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> listePos = new ArrayList();
        listePos.addAll(queen(position, board, Direction.N));
        listePos.addAll(queen(position, board, Direction.S));
        listePos.addAll(queen(position, board, Direction.E));
        listePos.addAll(queen(position, board, Direction.W));
        listePos.addAll(queen(position, board, Direction.NE));
        listePos.addAll(queen(position, board, Direction.NW));
        listePos.addAll(queen(position, board, Direction.SE));
        listePos.addAll(queen(position, board, Direction.SW));

        return listePos;

    }

    private List<Position> queen(Position position, Board board, Direction dir) {
        List<Position> positionPossible = new ArrayList();
        Position pos = position;

        while (board.contains(pos.next(dir)) && ((board.isFree(pos.next(dir))) || board.containsOppositeColor(pos.next(dir), super.getColor()))) {
            //vérifie s'il est dans le plateau et case vide ou contient un pion opposé
            if (board.containsOppositeColor(pos.next(dir), super.getColor())) { // si le pion est de couleur opposé il ajoute dans la liste et retourne la liste pour ne pas continuer à ajouter des positions
                positionPossible.add(pos.next(dir));
                return positionPossible;
            }

            positionPossible.add(pos.next(dir));
            pos = pos.next(dir);
        }
        return positionPossible;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58132.chess.model.pieces;

import g58132.chess.model.Board;
import g58132.chess.model.Color;
import g58132.chess.model.Direction;
import g58132.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elhar
 */
public class FlyingBishop extends Piece {

    public FlyingBishop(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> positionPossible = new ArrayList();
        positionPossible.addAll(movingFlyingBishop(position, board, Direction.NW));
        positionPossible.addAll(movingFlyingBishop(position, board, Direction.NE));
        positionPossible.addAll(movingFlyingBishop(position, board, Direction.SE));
        positionPossible.addAll(movingFlyingBishop(position, board, Direction.SW));
        
        return positionPossible;

    }

    private List<Position> movingFlyingBishop(Position position, Board board, Direction dir) {
        List<Position> positionPossible = new ArrayList();
        Position pos = position;

        while (board.contains(pos.next(dir)) && ((board.isFree(pos.next(dir))) || board.containsOppositeColor(pos.next(dir), super.getColor()) || !board.isFree(pos.next(dir)))) {
            if (board.containsOppositeColor(pos.next(dir), super.getColor()) || ((board.isFree(pos.next(dir))))) {
                positionPossible.add(pos.next(dir));

            }

            pos = pos.next(dir);
        }
        return positionPossible;
    }

}

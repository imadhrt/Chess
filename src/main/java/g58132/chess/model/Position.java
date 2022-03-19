/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58132.chess.model;

/**
 * Represent the position on the game board
 * @author elhar
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructor of position
     * 
     * Allows to initialize the row and column attributes to values
     * 
     * @param row is a position in the board
     * @param column is a position in the board
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    /**
     * Accessor of row
     * 
     * Allows access to the value of the row attribute.
     * @return the value of the row attribute
     */

    public int getRow() {
        return this.row;
    }
   /**
     * Accessor of column
     * 
     * Allows access to the value of the column attribute.
     * @return the value of the column attribute
     */

    public int getColumn() {
        return this.column;
    }
    

 
    
    
    
    
    
    
}

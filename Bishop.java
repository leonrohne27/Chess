import java.util.Objects;

import static java.lang.Math.abs;

public class Bishop extends Piece{


    public Bishop(String colour) {
        super(colour);
    }

    public static boolean isDiagonalMove(Tile from, Tile to){
        return Math.abs(to.getRow() - from.getRow()) == Math.abs(to.getColumn() - from.getColumn());
    }

    public static boolean isPathClearDiagonal(Tile from, Tile to){
        int diffRow = from.getRow() - to.getRow();
        int diffcol = from.getColumn() - to.getColumn();
        int rowIndex = from.getRow() -1;
        int columnIndex = from.getColumn() - 'A';

        if(diffRow < 0 && diffcol < 0) {
            for (int i = 1; i < -diffRow; i++) {
                if (Game.board[rowIndex + i][columnIndex + i].getPiece() != null) {
                    return false;
                }
            }
        }
        if(diffRow < 0 && diffcol > 0) {
            for (int i = 1; i < -diffRow; i++) {
                if (Game.board[rowIndex + i][columnIndex - i].getPiece() != null) {
                    return false;
                }
            }
        }
        else if(diffRow > 0 && diffcol < 0) {
            for (int i = 1; i < diffRow; i++) {
                if (Game.board[rowIndex - i][columnIndex + i].getPiece() != null) {
                    return false;
                }
            }
        }
        else if(diffRow > 0 && diffcol > 0) {
            for (int i = 1; i < diffRow; i++) {
                if (Game.board[rowIndex - i][columnIndex - i].getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEnemyOrEmpty(Tile from, Tile to){
        return to.getPiece() == null || !Objects.equals(to.getPiece().getColour(), from.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        Tile currentTile = this.getTile();
        return isDiagonalMove(currentTile,targetTile)
                && isPathClearDiagonal(currentTile,targetTile)
                && isEnemyOrEmpty(currentTile,targetTile);
    }

    @Override
    public String getName() {
        if(this.getColour().equals("white")){
            return "wB";
        }
        return "bB";
    }
}

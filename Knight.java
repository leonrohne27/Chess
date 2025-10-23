import java.util.Objects;

import static java.lang.Math.abs;

public class Knight extends Piece{


    public Knight(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {

    }

    public static boolean isLShapeMove(Tile from, Tile to){
        int diffRow = abs(to.getRow() - from.getRow());
        int diffCol = abs(to.getColumn() - from.getColumn());

        return (diffRow == 2 && diffCol == 1) || (diffRow == 1 && diffCol == 2);
    }

    public static boolean isEnemyOrEmpty(Tile from, Tile to){
        return to.getPiece() == null || !Objects.equals(to.getPiece().getColour(), from.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        Tile currentTile = this.getTile();
        return isLShapeMove(currentTile,targetTile) && isEnemyOrEmpty(currentTile,targetTile);
    }
}

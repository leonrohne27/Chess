import java.util.Objects;

import static java.lang.Math.abs;

public class King extends Piece{


    public King(String colour) {
        super(colour);
    }

    public boolean isEnemyOrEmpty(Tile targetTile){
        return targetTile.getPiece() == null || !Objects.equals(this.getColour(), targetTile.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        int targetRow = targetTile.getRow();
        char targetColumn = targetTile.getColumn();
        int currentRow = this.getTile().getRow();
        char currentColumn = this.getTile().getColumn();
        int diffRow = abs(targetRow - currentRow);
        int diffColumn = abs(targetColumn - currentColumn);

        return isEnemyOrEmpty(targetTile) && diffRow <= 1 && diffColumn <= 1;

    }

    @Override
    public String getName() {
        if(this.getColour().equals("white")){
            return "wK";
        }
        return "bK";
    }
}

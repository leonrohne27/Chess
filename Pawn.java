import java.util.Objects;

public class Pawn extends Piece{

    public Pawn(String colour) {
        super(colour);
    }

    public static boolean isEnemyOrEmpty(Tile from, Tile to){
        return to.getPiece() == null || !Objects.equals(to.getPiece().getColour(), from.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        Tile currentTile = this.getTile();
        int targetRow = targetTile.getRow();
        char targetColumn = targetTile.getColumn();
        int currentRow = this.getTile().getRow();
        char currentColumn = this.getTile().getColumn();
        int rowIndex = currentRow -1;
        int columnIndex = currentColumn - 'A';


        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "white")
                && currentRow == 2
                && (targetRow == currentRow+1 || (targetRow == currentRow+2))
                && currentColumn == targetColumn){
            return true;
        }
        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "white")
                && currentRow != 2
                && targetRow == currentRow+1
                && currentColumn == targetColumn){
            return true;
        }
        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "black")
                && currentRow == 7
                && (targetRow == currentRow-1 || (targetRow == currentRow -2))
                && currentColumn == targetColumn) {
            return true;
        }
        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "black")
                && currentRow != 6
                && targetRow == currentRow-1
                && currentColumn == targetColumn){
            return true;
        }
            return false;
        }

    @Override
    public String getName() {
        if(this.getColour().equals("white")){
            return "wP";
        }
        return "bP";
    }
}

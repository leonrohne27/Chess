import java.util.Objects;

public class Pawn extends Piece{

    public Pawn(String colour) {
        super(colour);
    }


    @Override
    public boolean isLegalMove(Tile targetTile) {

        int targetRow = targetTile.getRow();
        char targetColumn = targetTile.getColumn();
        int currentRow = this.getTile().getRow();
        char currentColumn = this.getTile().getColumn();

        if(targetTile.getPiece() == null
                && Objects.equals(this.getColour(), "white")
                && currentRow == 2
                && (targetRow == currentRow+1 || (targetRow == currentRow+2))
                && currentColumn == targetColumn){
            return true;
        }
        if(targetTile.getPiece() == null
                && Objects.equals(this.getColour(), "white")
                && currentRow != 2
                && targetRow == currentRow+1
                && currentColumn == targetColumn){
            return true;
        }
        if(targetTile.getPiece() == null
                && Objects.equals(this.getColour(), "black")
                && currentRow == 7
                && (targetRow == currentRow-1 || (targetRow == currentRow -2))
                && currentColumn == targetColumn) {
            return true;
        }
        if(targetTile.getPiece() == null
                && Objects.equals(this.getColour(), "black")
                && currentRow != 7
                && targetRow == currentRow-1
                && currentColumn == targetColumn){
            return true;
        }
        if(Objects.equals(this.getColour(), "white")
                && targetTile.getPiece() != null
                && Objects.equals(targetTile.getPiece().getColour(), "black")
                && targetRow == currentRow+1
                && (targetColumn == currentColumn +1 || targetColumn == currentColumn-1)){
            return true;
        }
        if(Objects.equals(this.getColour(), "black")
                && targetTile.getPiece() != null
                && Objects.equals(targetTile.getPiece().getColour(), "white")
                && targetRow == currentRow-1
                && (targetColumn == currentColumn +1 || targetColumn == currentColumn-1)){
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

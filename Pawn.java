import java.util.Objects;

public class Pawn extends Piece{

    public Pawn(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {
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

        if(targetTile == null){
            return false;
        }
        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "white")
                && currentRow == 2
                && (targetRow == 3 || (targetRow ==4 && Game.board[rowIndex+1][columnIndex].getPiece() == null))
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
                && (targetRow == 6 || (targetRow == 5 && Game.board[currentRow-1][columnIndex].getPiece() == null))
                && currentColumn == targetColumn) {
            return true;
        }
        if(isEnemyOrEmpty(currentTile, targetTile)
                && Objects.equals(this.getColour(), "black")
                && currentRow != 7
                && targetRow == currentRow-1
                && currentColumn == targetColumn){
            return true;
        }
            return false;
        }
}

import java.util.Objects;

public class Rook extends Piece{


    public Rook(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        int targetRow = targetTile.getRow();
        char targetColumn = targetTile.getColumn();
        int currentRow = this.getTile().getRow();
        char currentColumn = this.getTile().getColumn();
        int rowIndex = currentRow -1;
        int columnIndex = currentColumn - 'A';
        boolean noAllyPiecesInWayVertical = true;
        boolean noAllyPiecesInWayHorizontal = true;

        if(currentRow < targetRow) {
            for (int i = currentRow; i < targetRow - 1; i++) {
                if (Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())) {
                    noAllyPiecesInWayVertical = false;
                    break;
                }
            }
        }
        if(currentRow > targetRow) {
            for (int i = targetRow; i < currentRow - 1; i++) {
                if (Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())) {
                    noAllyPiecesInWayVertical = false;
                    break;
                }
            }
        }
        if(currentColumn < targetColumn) {
            for (char i = currentColumn; i < targetColumn - 'A'; i++) {
                if (Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                    noAllyPiecesInWayHorizontal = false;
                    break;
                }
            }
        }
        if(currentColumn > targetColumn) {
            for (char i = targetColumn; i < currentColumn - 'A'; i++) {
                if (Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                    noAllyPiecesInWayHorizontal = false;
                    break;
                }
            }
        }

        if(targetTile == null){
            return false;
        }
        //für vertikale Züge
        if(!Objects.equals(targetTile.getPiece().getColour(), this.getColour())
                && targetColumn == currentColumn
                && noAllyPiecesInWayVertical){
            return true;
        }
        //für horizontale Züge
        if(!Objects.equals(targetTile.getPiece().getColour(), this.getColour())
                && targetRow == currentRow
                && noAllyPiecesInWayHorizontal){
            return true;
        }

        //Schmeißen noch implementieren (noEnemyPiecesInWayVertical/noEnemyPiecesInWayHoriontal)?
            return false;
    }
}

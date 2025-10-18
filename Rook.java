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
        boolean noAllyPieceInWayVertical = true;
        boolean noAllyPieceInWayHorizontal = true;
        boolean noEnemyPieceInRangeVertical = true;
        boolean noEnemyPieceInRangeHorizontal = true;

        if(targetTile == null){
            return false;
        }

        //Prüfen, ob eigene Figuren im Weg sind (vertikal+horizontal)
        if(currentRow < targetRow) {
            for (int i = currentRow; i < targetRow - 1; i++) {
                if (targetTile.getPiece() != null && !Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())){
                    noEnemyPieceInRangeVertical = false;
                    break;
                }
                if (Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())) {
                    noAllyPieceInWayVertical = false;
                    break;
                }
            }
        }
        if(currentRow > targetRow) {
            for (int i = targetRow; i < currentRow - 1; i++) {
                if (targetTile.getPiece() != null && !Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())){
                    noAllyPieceInWayVertical = false;
                    break;
                }
                if (Objects.equals(Game.board[i][columnIndex].getPiece().getColour(), this.getColour())) {
                    noAllyPieceInWayVertical = false;
                    break;
                }
            }
        }
        if(currentColumn < targetColumn) {
            for (char i = currentColumn; i < targetColumn - 'A'; i++) {
                if (targetTile.getPiece() != null && !Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                    noEnemyPieceInRangeHorizontal = false;
                    break;
                }
                if (Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                    noAllyPieceInWayHorizontal = false;
                    break;
                }
            }
        }
        if(currentColumn > targetColumn) {
            for (char i = targetColumn; i < currentColumn - 'A'; i++) {
                if (targetTile.getPiece() != null && !Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                    noEnemyPieceInRangeHorizontal = false;
                    break;
                }
                    if (Objects.equals(Game.board[rowIndex][i].getPiece().getColour(), this.getColour())) {
                        noAllyPieceInWayHorizontal = false;
                        break;
                    }
                }
            }

        //für vertikale Züge
        if(targetTile.getPiece() == null
                && targetColumn == currentColumn
                && noAllyPieceInWayVertical
                && noEnemyPieceInRangeVertical){
            return true;
        }
        //für horizontale Züge
        if(targetTile.getPiece() == null
                && targetRow == currentRow
                && noAllyPieceInWayHorizontal
                && noEnemyPieceInRangeHorizontal){
            return true;
        }

        //schmeißen vertikal
        if(targetTile.getPiece() != null
                && !Objects.equals(targetTile.getPiece().getColour(), this.getColour())
                && targetColumn == currentColumn
                && noAllyPieceInWayVertical
                && noEnemyPieceInRangeVertical){
            //schmeißen
            return true;
        }

        //schmeißen horizontal
        if(targetTile.getPiece() != null
                && !Objects.equals(targetTile.getPiece().getColour(), this.getColour())
                && targetRow == currentRow
                && noAllyPieceInWayHorizontal
                && noEnemyPieceInRangeHorizontal){
            //schmeißen
            return true;
        }
        return false;
    }
}

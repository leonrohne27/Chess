import java.util.Objects;

public class Rook extends Piece{


    public Rook(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {
    }

    public static boolean isStraightMove(Tile from, Tile to){
        return(from.getRow() == to.getRow() || from.getColumn() == to.getColumn());
    }

    public static boolean isPieceInWayHorizontal(Tile from, Tile to){
        int step = Integer.compare(to.getColumn(), from.getColumn());
        int diffCol = to.getColumn() - from.getColumn();
        int rowIndex = from.getRow() -1;
        int columnIndex = from.getColumn() - 'A';
        for(int i=step;i<diffCol;i+=step){
            if (Game.board[rowIndex][columnIndex+i].getPiece() != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPieceInWayVertical(Tile from, Tile to){
        int step = Integer.compare(to.getRow(), from.getRow());
        int diffRow = to.getRow() - from.getRow();
        int rowIndex = from.getRow() -1;
        int columnIndex = from.getColumn() - 'A';
        for(int i=step;i<diffRow;i+=step){
            if (Game.board[rowIndex+i][columnIndex].getPiece() != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPathClearStraight(Tile from, Tile to){
        return !isPieceInWayHorizontal(from, to)
                && !isPieceInWayVertical(from, to);
    }

    public static boolean isEnemyOrEmpty(Tile from, Tile to){
        return to.getPiece() == null || !Objects.equals(to.getPiece().getColour(), from.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        Tile currentTile = this.getTile();
        return isStraightMove(currentTile,targetTile)
                && isPathClearStraight(currentTile,targetTile)
                && isEnemyOrEmpty(currentTile, targetTile);
    }
}

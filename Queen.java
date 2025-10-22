public class Queen extends Piece{


    public Queen(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {

    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        Tile currentTile = this.getTile();
        return (Rook.isStraightMove(currentTile,targetTile)&&Rook.isPathClearStraight(currentTile,targetTile)&&Rook.isEnemyOrEmpty(currentTile,targetTile)) ||
                (Bishop.isDiagonalMove(currentTile,targetTile)&&Bishop.isPathClearDiagonal(currentTile,targetTile)&&Bishop.isEnemyOrEmpty(currentTile,targetTile));
    }
}

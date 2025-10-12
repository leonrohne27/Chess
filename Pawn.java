public class Pawn extends Piece{

    Tile currentTile = this.getTile();
    int currentRow = currentTile.getRow();
    char currentColumn = currentTile.getColumn();
    Tile targetTile = null;

    public Pawn(String colour) {
        super(colour);
    }

    @Override
    public void move() {
        if(isLegalMove() && 1==1) { //1==1 ergänzen um click auf Feld

            targetTile = null; //ersetzen durch Feld das angeklickt wird
            targetTile.setPiece(this);
            this.setTile(targetTile);
        }
    }

    @Override
    public boolean isLegalMove() {
        if(this.getColour() == "white" && currentRow == 2 && (targetTile == Game.board[currentRow+1][currentColumn] || targetTile == Game.board[currentRow+2][currentColumn])){
            return true;
        }
        return false;
    }
}

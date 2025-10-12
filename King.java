public class King extends Piece{

    Tile currentTile = this.getTile();
    int currentRow = currentTile.getRow();
    char currentColumn = currentTile.getColumn();
    Tile targetTile = null;

    public King(String colour) {
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
        return false;
    }
}

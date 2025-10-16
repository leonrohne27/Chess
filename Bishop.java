public class Bishop extends Piece{


    public Bishop(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {

    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        return false;
    }
}

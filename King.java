public class King extends Piece{


    public King(String colour) {
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

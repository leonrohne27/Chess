public class Queen extends Piece{


    public Queen(String colour) {
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

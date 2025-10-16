public class Knight extends Piece{


    public Knight(String colour) {
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

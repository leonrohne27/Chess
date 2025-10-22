import java.util.Objects;

public class Knight extends Piece{


    public Knight(String colour) {
        super(colour);
    }

    @Override
    public void move(Tile targetTile) {

    }



    public static boolean isEnemyOrEmpty(Tile from, Tile to){
        return to.getPiece() == null || !Objects.equals(to.getPiece().getColour(), from.getPiece().getColour());
    }

    @Override
    public boolean isLegalMove(Tile targetTile) {
        return false;
    }
}

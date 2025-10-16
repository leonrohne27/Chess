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



            return false;
    }
}

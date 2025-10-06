import java.util.HashMap;
import java.util.Map;

public class Game {

    public static void createBoard(){
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                char current_column = convertColumns.get(j);
                Tile tile = new Tile(i,current_column);
                System.out.println(tile.getRow()+""+tile.getColumn());
            }
        }
    }

    public void place(Piece piece, Tile tile){
        tile.setPiece(piece);
        piece.setTile(tile);
    }

    public static void createPieces(){
        for(char col = 'A';col <= 'H';col++){
            place
        }
    }

    static HashMap<Integer, Character> convertColumns = new HashMap<>(Map.of(
            1,'A',2,'B',3,'C',4,'D',
            5,'E',6,'F',7,'G',8,'H'
    ));

    public static void main(String[] args){
        Game.createBoard();
        Game.createPieces();
    }
}

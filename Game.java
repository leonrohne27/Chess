import java.util.HashMap;
import java.util.Map;

public class Game {

    private static final Tile[][] board = new Tile [8][8];

    public static void createBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char current_column = convertColumns.get(j);
                board[i][j] = new Tile(i+1,current_column);
            }
        }
    }

    public static void place(Piece piece, Tile tile){
        tile.setPiece(piece);
        piece.setTile(tile);
    }

    public static void createAndPlacePieces(){
        Game.place(new Rook("black"),board[0][0]);
        Game.place(new Knight("black"),board[0][1]);
        Game.place(new Bishop("black"),board[0][2]);
        Game.place(new Queen("black"),board[0][3]);
        Game.place(new King("black"),board[0][4]);
        Game.place(new Bishop("black"),board[0][5]);
        Game.place(new Knight("black"),board[0][6]);
        Game.place(new Rook("black"),board[0][7]);
        Game.place(new Rook("white"),board[7][0]);
        Game.place(new Knight("white"),board[7][1]);
        Game.place(new Bishop("white"),board[7][2]);
        Game.place(new Queen("white"),board[7][3]);
        Game.place(new King("white"),board[7][4]);
        Game.place(new Bishop("white"),board[7][5]);
        Game.place(new Knight("white"),board[7][6]);
        Game.place(new Rook("white"),board[7][7]);
        for(int j=0;j<8;j++){
            board[1][j].setPiece(new Pawn("black"));
        }
        for(int j=0;j<8;j++){
            board[6][j].setPiece(new Pawn("white"));
        }

        for(int j=0;j<8;j++){
            board[1][j].getPiece().setTile(board[1][j]);
        }
        for(int j=0;j<8;j++){
            board[6][j].getPiece().setTile(board[6][j]);
        }
    }

    static HashMap<Integer, Character> convertColumns = new HashMap<>(Map.of(
            0,'A',1,'B',2,'C',3,'D',
            4,'E',5,'F',6,'G',7,'H'
    ));

    public static void main(String[] args){
        Game.createBoard();
        board[0][0].setPiece(new Rook("black"));
        Piece whichPiece = board[0][0].getPiece();
        System.out.println(whichPiece);
    }
}

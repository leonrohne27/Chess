import javafx.scene.layout.StackPane;

import java.util.Objects;

public class GameController {

    public static boolean isGameFinished = false;
    public static boolean isWhiteTurn = true;
    private static Piece selectedPiece = null;


    public static void makeMove(Tile tile, StackPane cell) {
        cell.setOnMouseClicked(e -> {
            if (isGameFinished) {
                return;
            }
            if (selectedPiece == null) {
                if (isWhiteTurn) {
                    if (tile.getPiece() != null && Objects.equals(tile.getPiece().getColour(), "white")) {
                        selectedPiece = tile.getPiece();
                        System.out.println("Selected Piece " + selectedPiece.getName() + " on Tile " + selectedPiece.getTile().getRow() + selectedPiece.getTile().getColumn());
                    } else {
                        System.out.println("white's turn");
                    }
                } else {
                    if (tile.getPiece() != null && Objects.equals(tile.getPiece().getColour(), "black")) {
                        selectedPiece = tile.getPiece();
                        System.out.println("Selected Piece " + selectedPiece.getName() + " on Tile " + selectedPiece.getTile().getRow() + selectedPiece.getTile().getColumn());
                    } else {
                        System.out.println("black's turn");
                    }
                }
            } else {
                if (selectedPiece.isLegalMove(tile)) {
                    isWhiteTurn = !isWhiteTurn;
                }
                selectedPiece.move(tile);
                selectedPiece = null;
                if (Piece.isKingCaptured) {
                    isGameFinished = true;
                }
            }
        });

    }

    public static MoveResult performMove(Piece piece, Tile target) {
        if (!piece.isLegalMove(target)){
            return new MoveResult(piece, null, target, false);
        }

        Piece captured = target.getPiece();
        piece.move(target);
        return new MoveResult(piece,captured,target, true);
    }
}

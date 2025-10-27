import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Objects;

public class MainApp extends Application{

    public static final int TILE_SIZE = 80;
    private Piece selectedPiece = null;
    private boolean isGameFinished = false;
    private boolean isWhiteTurn = true;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Game.createBoard();
        Game.createAndPlacePieces();
        for(int row=7; row>=0;row--){
            for(int col=0; col<8;col++){

                StackPane cell = new StackPane();
                cell.setPrefSize(TILE_SIZE, TILE_SIZE);

                Tile tileObj = Game.board[row][col];
                tileObj.setCell(cell);
                cell.setUserData(tileObj);
                Color bgColor = (row + col) % 2 == 0 ? Color.BEIGE : Color.SADDLEBROWN;
                Rectangle background = new Rectangle(TILE_SIZE, TILE_SIZE, bgColor);

                ImageView pieceView = null;
                if(tileObj.getPiece() != null) {
                    String pieceName = tileObj.getPiece().getName();
                    File f = new File("out/production/Chess/pictures/" + pieceName + ".png");
                    Image pieceImage = new Image(f.toURI().toString());
                    pieceView = new ImageView(pieceImage);
                    pieceView.setFitWidth(TILE_SIZE);
                    pieceView.setFitHeight(TILE_SIZE);
                    pieceView.setPreserveRatio(true);
                    tileObj.getPiece().setImageView(pieceView);

                }

                cell.getChildren().add(background);
                if(pieceView != null){
                    cell.getChildren().add(pieceView);
                }

                cell.setOnMouseClicked(e ->{
                    if(isGameFinished){return;}

                    Tile clickedTile = tileObj;

                    if(selectedPiece == null ) {
                        if (isWhiteTurn) {
                            if (clickedTile.getPiece()!=null && Objects.equals(clickedTile.getPiece().getColour(), "white")) {
                                selectedPiece = clickedTile.getPiece();
                                System.out.println("Selected Piece " + selectedPiece.getName() + " on Tile " + selectedPiece.getTile().getRow() + selectedPiece.getTile().getColumn());
                            } else {
                                System.out.println("white's turn");
                            }
                        } else {
                            if (clickedTile.getPiece()!=null && Objects.equals(clickedTile.getPiece().getColour(), "black")) {
                                selectedPiece = clickedTile.getPiece();
                                System.out.println("Selected Piece " + selectedPiece.getName() + " on Tile " + selectedPiece.getTile().getRow() + selectedPiece.getTile().getColumn());
                            } else{
                                System.out.println("black's turn");
                            }
                        }
                    }
                    else{
                        if(selectedPiece.isLegalMove(clickedTile)){
                            isWhiteTurn = !isWhiteTurn;
                        }
                        selectedPiece.move(clickedTile);
                        selectedPiece = null;
                        if(Piece.isKingCaptured){
                            isGameFinished = true;
                        }
                    }

                });
                grid.add(cell, col, 7-row);
            }
        }


        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setTitle("Chess");
        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}

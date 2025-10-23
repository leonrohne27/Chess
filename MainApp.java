import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


import javax.swing.*;

public class MainApp extends Application{

    public static final int TILE_SIZE = 80;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Game.createBoard();
        Game.createAndPlacePieces();

        for(int row=Game.board.length-1; row>=0;row--){
            for(int col=0; col<Game.board[0].length;col++){
                Tile tileObj = Game.board[col][row];
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                boolean light = (row+col) % 2 == 0;
                tile.setFill(light ? Color.BEIGE : Color.DARKOLIVEGREEN);

                tile.setOnMouseClicked(e ->{
                    System.out.println("Clicked on " + tileObj.getRow() + " " +  tileObj.getColumn());
                    System.out.println(tileObj.getPiece());
                });

                grid.add(tile, row, 7-col);
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

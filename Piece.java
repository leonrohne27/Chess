import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public abstract class Piece {

    private String colour;
    private Tile tile;
    public ImageView imageView;

    public Piece(String colour){
        setColour(colour);
    }


    public void move(Tile targetTile){
        if(!isLegalMove(targetTile)) {
            System.out.println("Invalid move");
            return;
        }
        Tile fromTile = this.getTile();
        StackPane fromCell = fromTile.getCell();
        StackPane toCell = targetTile.getCell();
        ImageView iv = this.getImageView();

        fromTile.setPiece(null);
        targetTile.setPiece(this);
        this.setTile(targetTile);

        toCell.getChildren().add(iv);

        System.out.println("Moved " + this.getName() + " to " + targetTile.getRow() + targetTile.getColumn());

    }
    public abstract boolean isLegalMove(Tile targetTile);
    public abstract String getName();

    public void setColour(String colour){
        if (Objects.equals(colour, "white") || Objects.equals(colour, "black")){
            this.colour = colour;
        }
        else{
            System.out.println("Colour must be either 'black' or 'white'");
        }
    }
    public void setTile(Tile tile){
        this.tile = tile;
    }
    public Tile getTile(){
        return tile;
    }

    public String getColour(){
        return this.colour;
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }
    public ImageView getImageView(){
        return this.imageView;
    }

}

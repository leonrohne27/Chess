import java.util.Objects;

public abstract class Piece {

    private String colour;
    private Tile tile;

    public Piece(String colour){
        setColour(colour);
    }

    public abstract void move(Tile targetTile);
    public abstract boolean isLegalMove(Tile targetTile);

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

}

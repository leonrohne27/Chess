public class Piece {

    private PieceType type;
    private String colour;

    public Piece(PieceType type, String colour){
        this.type = type;
        setColour(colour);
    }

    public void setColour(String colour){
        if (colour == "white" || colour == "black"){
            this.colour = colour;
        }
        else{
            System.out.println("Colour must be either 'black' or 'white'");
        }
    }

    public String getColour(){
        return this.colour;
    }

}

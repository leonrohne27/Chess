public class Tile {

    public boolean isOccupiedWithEnemyPiece;
    public boolean isOccupiedWithAllyPiece;
    public boolean isEmpty;
    public int row;
    public char column;
    public Piece piece;

    public Tile(int row, char column){
        setRow(row);
        setColumn(column);
    };

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){
        return piece;
    }

    public void setRow(int row){
        if(row >= 1 && row <=8){
            this.row = row;
        }
        else{
            System.out.println("Row of Tile must be between 1 and 8");
        }
    }
    public int getRow(){
        return row;
    }

    public void setColumn(char column){
        if(column>='A' && column <='H'){
            this.column = column;
        }
        else{
            System.out.println("Column of Tile must be between 'a' and 'h'");
        }
    }
    public char getColumn(){
        return this.column;
    }
}

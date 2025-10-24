public class LegalMoveTest {


    public static void main(String[] args){
        Pawn testPawn = new Pawn("white");
        Tile testCurrentTilePawn = new Tile(1,'A');
        Tile testTargetTilePawn = new Tile(3,'A');

        testPawn.setTile(testCurrentTilePawn);
        boolean isLegal = testPawn.isLegalMove(testTargetTilePawn);
        System.out.println(isLegal);
    }

}

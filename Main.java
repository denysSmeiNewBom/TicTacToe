public class Main {
    public static void main(String[] args) {


        Player[] player = {Player.N, Player.N, Player.N, Player.N, Player.N, Player.N, Player.N, Player.N, Player.N};
        Table table = new Table(player);
        PossibleMove firstPossibleMove = new PossibleMove(table, Player.X);
        firstPossibleMove.buildTree();
        System.out.println();
        /* Helper /@
        Helper helper = new Helper();
        helper.game();
        */

        //# Table /@
        /*Player[] player = {Player.X, Player.N, Player.N, Player.N, Player.N, Player.N, Player.X, Player.N, Player.N};
        Player[] player2 = {Player.X, Player.O, Player.O, Player.X, Player.X, Player.X, Player.X, Player.O, Player.O};
        Table table2 = new Table(player2);
        Table table = new Table(player);
        Table table1 = table.madeCopyOfTheTable();


        table.makeMoveOnTheBoard(4,Player.O);
        table1.makeMoveOnTheBoard(4,Player.X);
        table1.makeMoveOnTheBoard(3,Player.X);
        table.getFigurationTable();
        table1.getFigurationTable();
        for (int i = 0; i < table1.getArrOfPossibleMoves().length; i++) {
            System.out.print(table1.getArrOfPossibleMoves()[i] + " ");
        }
        for (int i = 0; i < table2.getArrOfPossibleMoves().length; i++) {
            System.out.print(table2.getArrOfPossibleMoves()[i] + " ");
        }*/
    }
}

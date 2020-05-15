import java.util.ArrayList;

public class PossibleMove {///@
    private Table currentTable;
    private static Player computerRole;
    private Player currentPlayer;
    private ArrayList<PossibleMove> allPossibleMoves = new ArrayList<PossibleMove>();
    private int level;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getLevel() {
        return level;
    }

    public Table getTable(){///@
        return this.currentTable;
    }
    public ArrayList<PossibleMove> getAllPossibleMoves(){///@
        return this.allPossibleMoves;
    }

    PossibleMove(Table currentTable, Player computerRole){ // Перше оголошення/@
        this.currentPlayer = computerRole;
        this.computerRole = computerRole;
        this.level = 1;
        this.currentTable = currentTable;
    }

    PossibleMove(Table currentTable, Player nextRole, int level){///@
        this.currentPlayer = nextRole;
        this.level = level;
        this.currentTable = currentTable;
    }

    public void buildTree(){///@
        int[] arrOfPossibleMove = currentTable.getArrOfPossibleMoves();
        if(arrOfPossibleMove[0] != -1){
            for (int i = 0; i < arrOfPossibleMove.length; i++) {
                Table newTable = currentTable.madeCopyOfTheTable();
                newTable.makeMoveOnTheBoard(arrOfPossibleMove[i],currentPlayer);
                allPossibleMoves.add(new PossibleMove(newTable,getNextRole(),this.level+1));
            }
            for (int i = 0; i < allPossibleMoves.size(); i++) {
                allPossibleMoves.get(i).buildTree();
            }
        }
    }

    private Player getNextRole() {///@
        if (currentPlayer == Player.O) return Player.X;
        else return Player.O;
    }
}

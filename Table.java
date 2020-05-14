
public class Table {
    public Player[] boardInfo;
    public Player winner;

    Table() {//перша борда/@
        this.boardInfo = new Player[9];
        for (int i = 0; i < boardInfo.length; i++) {
            boardInfo[i] = Player.N;
        }
        winner = Player.N;
    }

    Table(Player[] boardInfo) { //Для тесту/@
        this.boardInfo = boardInfo;
        this.winner = getWinner();
    }

    public Table madeCopyOfTheTable() {//Робить копію себе і записую в ний стіл/@
        Table newTable = new Table();
        newTable.winner = this.winner;
        for (int i = 0; i < newTable.boardInfo.length; i++) {
            newTable.boardInfo[i] = this.boardInfo[i];
        }
        return newTable;
    }

    public void getFigurationTable() {//Виводить дошку/@
        for (int i = 0; i < boardInfo.length; i++) {
            if (boardInfo[i] == Player.N) System.out.print("|" + (i + 1));
            else System.out.print("|" + boardInfo[i]);
            if ((i + 1) % 3 == 0) {
                System.out.print("|\n");
            }
        }
        if (winner != Player.N) System.out.println("Winner :" + winner);
    }

    public int[] getArrOfPossibleMoves() {//Вертає масив можливих ходів /@
        if (winner != Player.N){
            int[] arr = {-1};
            return arr;
        }
        int[] arrOfPossibleMoves = {};
        for (int i = 0; i < boardInfo.length; i++) {
            if (boardInfo[i] == Player.N) {
                int[] newArr = new int[arrOfPossibleMoves.length + 1];
                for (int j = 0; j < arrOfPossibleMoves.length; j++) {
                    newArr[j] = arrOfPossibleMoves[j];
                }
                newArr[arrOfPossibleMoves.length] = i + 1;
                arrOfPossibleMoves = newArr;
            }
        }
        if (arrOfPossibleMoves.length == 0) {
            int[] arr = {-1};
            return arr;
        }
        return arrOfPossibleMoves;
    }

    public void makeMoveOnTheBoard(int move, Player player) {//Робить мув на дошці/@
        int[] arrOfMoves = getArrOfPossibleMoves();
        for (int i = 0; i < arrOfMoves.length; i++) {
            if (arrOfMoves[i] == move) {
                boardInfo[move - 1] = player;
            }
        }
        winner = getWinner();
    }

    ///////////////////////////////Вони працюють в парі /@
    private Player getWinnerInTheBoard(Player player) {//Чи є переможець на дошці і хто /@
        int[][] winnerCombination = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {4, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < winnerCombination.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardInfo[winnerCombination[i][j]] != player) break;
                if (j == 2) return player;
            }
        }
        return Player.N;
    }

    public Player getWinner() {//@
        if (getWinnerInTheBoard(Player.X) == Player.X) {
            return Player.X;
        } else if (getWinnerInTheBoard(Player.O) == Player.O) {
            return Player.O;
        }
        return Player.N;
    }
    ///////////////////////////////Вони працюють в парі
}

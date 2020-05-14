import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public Player computer = Player.N, humane = Player.N;
    protected Table mainTable = new Table();

    private void pregame() {//рандомний вибір гравців перед грою
        if (random.nextBoolean() == true) {
            this.computer = Player.O;
            this.humane = Player.X;
        } else {
            this.computer = Player.X;
            this.humane = Player.O;
        }
    }

    public void game() { //Сама гра
        pregame();
        if (computer == Player.X) {
            while (mainTable.getArrOfPossibleMoves()[0] != -1) {
                computerMakeMove();
                mainTable.winner = mainTable.getWinner();
                if (mainTable.winner != Player.N || mainTable.getArrOfPossibleMoves()[0] == -1) break;
                playerMakeMove();
                mainTable.winner = mainTable.getWinner();
                if (mainTable.winner != Player.N) break;
            }
        } else {
            while (mainTable.getArrOfPossibleMoves()[0] != -1) {
                playerMakeMove();
                mainTable.winner = mainTable.getWinner();
                if (mainTable.winner != Player.N || mainTable.getArrOfPossibleMoves()[0] == -1) break;
                computerMakeMove();
                mainTable.winner = mainTable.getWinner();
                if (mainTable.winner != Player.N) break;
            }
        }
        mainTable.getFigurationTable();
        System.out.println("Winner is: " + mainTable.getWinner());
    }

    private void playerMakeMove() {//Хід гравця/@
        mainTable.getFigurationTable();
        boolean choseIsFromAbleChose = true;
        int move = -1;
        while (choseIsFromAbleChose) {
            System.out.println("Make move");
            int m = scanner.nextInt();
            int[] arr = mainTable.getArrOfPossibleMoves();
            for (int i = 0; i < arr.length; i++) {
                if (m == arr[i]) {
                    choseIsFromAbleChose = false;
                    move = m;
                    break;
                }
            }
        }
        mainTable.makeMoveOnTheBoard(move, humane);
    }

    private void computerMakeMove() {// Хід компа
        mainTable.getFigurationTable();
        mainTable.makeMoveOnTheBoard(mainTable.getArrOfPossibleMoves()[random.nextInt(mainTable.getArrOfPossibleMoves().length)], computer);
        System.out.println("Dome Computer move");
    }
}
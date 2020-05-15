import javafx.print.PageLayout;

import java.util.ArrayList;

public class AI {
    Player computer;
    Player humane;
    PossibleMove treeOfMoves;
    Table currentTable;
    int depth = Helper.depth;

    public AI(Player computer, Player humane, PossibleMove treeOfMoves){
        this.computer = computer;
        this.humane = humane;
        this.treeOfMoves = treeOfMoves;
    }

    public int engineForMiniMax(){///@
        int max = -1;
        int maxMove = 0;
        int[] arr = new int[treeOfMoves.getAllPossibleMoves().size()];
        for (int i = 0; i < this.treeOfMoves.getAllPossibleMoves().size(); i++) {
            arr[i] = MiniMax(this.treeOfMoves.getAllPossibleMoves().get(i));
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxMove = treeOfMoves.getAllPossibleMoves().get(i).getTable().move;
            }
        }
        return maxMove;
    }

    public int MiniMax(PossibleMove possibleMove){
        if( possibleMove.getLevel() == depth || possibleMove.getAllPossibleMoves().size() == 0){
            if(possibleMove.getTable().winner == Player.N)return 0;
            else if(possibleMove.getTable().winner == computer) return 1;
            else if(possibleMove.getTable().winner == humane) return -1;
        }
        else if(possibleMove.getCurrentPlayer() == humane){
            int[] arr = new int[possibleMove.getAllPossibleMoves().size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = MiniMax(possibleMove.getAllPossibleMoves().get(i));
            }
            return getMini(arr);
        }
        if(possibleMove.getCurrentPlayer() == computer) {
            int[] arr = new int[possibleMove.getAllPossibleMoves().size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = MiniMax(possibleMove.getAllPossibleMoves().get(i));
            }
            return getMax(arr);
        }
        return -2;
    }

    private int getMini(int[] arr){///@
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }
    private int getMax(int[] arr){///@
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    /*public void getMiniMax(int[] arr){ ///@
        System.out.println(getMax(arr));
        System.out.println(getMini(arr));
    }*/


    /*public AI(Player humane,Player computer, PossibleMove treeOfMoves){
        this.computer = computer;
        this.humane = humane;
        this.treeOfMoves = treeOfMoves;
        currentTable = treeOfMoves.getTable();
    }

    public int getBestMove(PossibleMove possibleMove){
        if (checkoutPossibleMove(possibleMove)) {
            for (int i = 0; i < possibleMove.getAllPossibleMoves().size(); i++) {
                getBestMove(possibleMove.getAllPossibleMoves().get(i));
            }
        }
        return 1;///
    }

    public boolean checkoutPossibleMove(PossibleMove currentPossibleMove){
        ArrayList<PossibleMove> arrayList = currentPossibleMove.getAllPossibleMoves();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getTable().winner == humane) return false;
        }
        return true;
    }*/
    

}

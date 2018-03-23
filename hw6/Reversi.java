import java.util.*;

class State {
    char[] board;

    public State(char[] arr) {
        this.board = Arrays.copyOf(arr, arr.length);
    }

    public int getScore() {
        int score = 0;
        // TO DO: return game theoretic value of the board

        return score;
    }

    public boolean isTerminal() {
        boolean is_terminal = false;
        // TO DO: determine if the board is a terminal node or not and return boolean
        if (this.getSuccessors('1').length == 0 && this.getSuccessors('2').length == 0)
            is_terminal = true;
        return is_terminal;
    }

    private int[][] getNeighbors(char[][] arr, int i, int j, char target, boolean reverse){
        int[][] ret = new int[8][3];
        char enemy = target;
        int index = 0;
        ret[0][2] = 0;
        //For convinience, the parameter target will alwyas be the current player. 
        //if a player-owned node is wanted, pass false to search
        //if an enemyNeighbors is wanted, pass true to reverse the target
        if (reverse) {
            char ene;
            if (target == '1')
                ene = '2';
            else
                ene = '1';
            enemy = ene;
        }
        //up left
        if (j > 0 && i > 0){
            if (arr[i - 1][j - 1] == enemy){
                ret[index][0] = i - 1;
                ret[index][1] = j - 1;
                index++;
            }
        }
        //up
        if (i > 0){
            if (arr[i - 1][j] == enemy){
                ret[index][0] = i - 1;
                ret[index][1] = j;
                index++;
            }
        }
        //up right
        if (i > 0 && j < 3){
            if (arr[i -1][j+1] == enemy){
                ret[index][0] = i -1;
                ret[index][1] = j + 1;
                index++;
            }
        }
        //check right
        if (j < 3){
            if (arr[i][j + 1] == enemy){
                ret[index][0] = i;
                ret[index][1] = j + 1;
                index++;
            }
        }
        //down right
        if (j < 3 && i < 3){
            if (arr[i + 1][j + 1] == enemy){
                ret[index][0] = i+1;
                ret[index][1] = j + 1;
                index++;

            }
        }
        //down
        if (i < 3){
            if (arr[i+1][j] == enemy){
                ret[index][0] = i + 1;
                ret[index][1] = j;
                index++;
            }
        }
        //down left
        if (i < 3 && j > 0){
            if (arr[i + 1][j - 1] == enemy){
                ret[index][0] = i + 1;
                ret[index][1] = j - 1;
                index++;
            }
        }
        //left
        if (j > 0){
            if (arr[i][j - 1] == enemy){
                ret[index][0] = i;
                ret[index][1] = j - 1;
                index++;
            }
        }

        //save the total neighbors number
        ret[0][2] = index + 1;
        return ret;
    }
    private State getSuccessorOfOneNode(char[][] arr, int i, int j, int en_i, int en_j, char player){
        int[] ret = new int[2];
        int offset_i = en_i - i;
        int offset_j = en_j - j;
        char enemy;
        //get enemy
        if (player == '1')
            enemy = '2';
        else
            enemy = '1';


        //return null if exceed the boundary
        if ((en_i + offset_i) < 0 
                || (en_i + offset_i) > 3  
                || (en_j + offset_j) < 0
                || (en_j + offset_j) > 3)
            return null;
        //copy the board
        char[] newBoard = Arrays.copyOf(this.board, this.board.length);

        if (arr[en_i + offset_i][en_j + offset_j] == player){
            //if the one of the neighbor of 0 could make a line with 0 and another neighbor of distance 1
            //
            newBoard[i*4+j] = player;
            newBoard[en_i*4+en_j] = player;
            State succ = new State(newBoard);
            return succ;
        } else {
            if ((en_i + offset_i + offset_i) < 0 
                    || (en_i + offset_i + offset_i) > 3  
                    || (en_j + offset_j + offset_j) < 0
                    || (en_j + offset_j + offset_j) > 3)
                return null;
            if (arr[en_i + offset_i + offset_i][en_j + offset_j + offset_j] == player){
                newBoard[en_i*4+en_j] = player;
                newBoard[(en_i + offset_i)*4 + (en_j + offset_j)] = player;
                newBoard[i*4+j] = player;
                State succ = new State(newBoard);
                return succ;
            }
        }

        return null;
    }
    public State[] getSuccessors(char player) {
        // TO DO: get all successors and return them in proper order
        ArrayList<State> succ = new ArrayList<State>();
        char arr[][] = new char[4][4];
        //construct a new board for faster accessing
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = board[0 + i*4 + j];
            }
        }

        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if (arr[i][j] == '0'){
                    int[][] enemyNeighbors = getNeighbors(arr, i, j, player, true);
                    for(int in = 0; in < enemyNeighbors[0][2]; in++){
                        State successor = getSuccessorOfOneNode(arr,
                                i,
                                j, 
                                enemyNeighbors[in][0], 
                                enemyNeighbors[in][1],
                                player);
                        if (successor != null){
                            succ.add(successor);
                        }
                    }

                }
            }

        }
        State[] successors = new State[succ.size()];
        successors = succ.toArray(successors);
        return successors;
    }

    public void printState(int option, char player) {

        // TO DO: print a State based on option (flag)
        if (option == 1){
            State[] successors = this.getSuccessors(player);
            if (successors.length > 0){
                for (int i = 0; i < successors.length; i++)
                    System.out.println(successors[i].getBoard());
            } else if (successors.length == 0){
                if (!this.isTerminal())
                    System.out.println(this.getBoard());
            }
        }
    }

    public String getBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            builder.append(this.board[i]);
        }
        return builder.toString().trim();
    }

    public boolean equals(State src) {
        for (int i = 0; i < 16; i++) {
            if (this.board[i] != src.board[i])
                return false;
        }
        return true;
    }
}

class Minimax {
    private static int max_value(State curr_state) {

        // TO DO: implement Max-Value of the Minimax algorithm
        return 0;
    }

    private static int min_value(State curr_state) {

        // TO DO: implement Min-Value of the Minimax algorithm
        return 0;
    }

    private static int max_value_with_pruning(State curr_state, int alpha, int beta) {

        // TO DO: implement Max-Value of the alpha-beta pruning algorithm
        return 0;
    }

    private static int min_value_with_pruning(State curr_state, int alpha, int beta) {

        // TO DO: implement Min-Value of the alpha-beta pruning algorithm
        return 0;
    }

    public static int run(State curr_state, char player) {

        // TO DO: run the Minimax algorithm and return the game theoretic value
        return 0;
    }

    public static int run_with_pruning(State curr_state, char player) {

        // TO DO: run the alpha-beta pruning algorithm and return the game theoretic value
        return 0;
    }
}

public class Reversi {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.out.println("Invalid Number of Input Arguments");
            return;
        }
        int flag = Integer.valueOf(args[0]);
        char[] board = new char[16];
        for (int i = 0; i < 16; i++) {
            board[i] = args[2].charAt(i);
        }
        int option = flag / 100;
        char player = args[1].charAt(0);
        if ((player != '1' && player != '2') || args[1].length() != 1) {
            System.out.println("Invalid Player Input");
            return;
        }
        State init = new State(board);
        init.printState(option, player);
    }
}

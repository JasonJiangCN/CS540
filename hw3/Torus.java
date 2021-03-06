import java.util.*;

class State {
    int[] board;
    State parentPt;
    int depth;
    public State(int[] arr) {
        this.board = Arrays.copyOf(arr, arr.length);
        this.parentPt = null;
        this.depth = 0;
    }
    private void slideTile(int empty, int tail) {
        this.board[empty] = this.board[tail];
        this.board[tail] = 0;
    }
    
    private int compareStateInNature(State target, int i){
        if (this.board[i] < target.board[i])
            return 1;
        else if (this.board[i] > target.board[i])
            return -1;
        else if (i == 7)
            return 0;
        else
            return compareStateInNature(target, i+1);
    }
    

    public State[] getSuccessors() {
        State[] successors = new State[4];
        // TO DO: get all four successors and return them in sorted order
        int emptyIndex = -1;
        for (int i = 0; i < 4; i++){
            successors[i] = new State(this.board);
            successors[i].depth = this.depth + 1;
            successors[i].parentPt = this;

        }
        for (int i = 0; i < 9; i++){
            if (this.board[i] == 0)
                emptyIndex = i;
        }
        //System.out.println(emptyIndex);
        //move the right to the empty
        if ((emptyIndex+1) % 3 != 0)
            successors[0].slideTile(emptyIndex, emptyIndex + 1);
        else 
            successors[0].slideTile(emptyIndex, emptyIndex - 2);
        //down
        if (emptyIndex < 6) 
            successors[1].slideTile(emptyIndex, emptyIndex + 3);
        else 
            successors[1].slideTile(emptyIndex, emptyIndex - 6);
        //left
        if (emptyIndex % 3 != 0)
            successors[2].slideTile(emptyIndex, emptyIndex - 1);
        else
            successors[2].slideTile(emptyIndex, emptyIndex + 2);
        //up
        if (emptyIndex > 2)
            successors[3].slideTile(emptyIndex, emptyIndex - 3);
        else
            successors[3].slideTile(emptyIndex, emptyIndex + 6);

        for (int j = 3; j > 0; j--)
            for (int i = 0; i < j; i++) {
                State curr = successors[i];
                if (successors[i].compareStateInNature(successors[i+1], 0) == -1){
                    successors[i] = successors[i+1];
                    successors[i+1] = curr;
                }
            }

        return successors;
    }

    public void printState(int option) {
        if (option == 3){
            System.out.print(this.getBoard());
            if (this.parentPt == null) {
                int[] nullArr = {0,0,0,0,0,0,0,0,0};
                State nullState = new State(nullArr);
                System.out.println(" parent " + nullState.getBoard());
            } else {
                System.out.println(" parent " + this.parentPt.getBoard());
            }

        } else {
            System.out.println(this.getBoard());
        }

    }

    public String getBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            builder.append(this.board[i]).append(" ");
        }
        return builder.toString().trim();
    }

    public boolean isGoalState() {
        for (int i = 0; i < 9; i++) {
            if (this.board[i] != (i + 1) % 9)
                return false;
        }
        return true;
    }

    public boolean equals(State src) {
        for (int i = 0; i < 9; i++) {
            if (this.board[i] != src.board[i])
                return false;
        }
        return true;
    }
}

public class Torus {
    public static void main(String args[]) {
        if (args.length < 10) {
            System.out.println("Invalid Input");
            return;
        }
        int flag = Integer.valueOf(args[0]);
        int[] board = new int[9];
        for (int i = 0; i < 9; i++) {
            board[i] = Integer.valueOf(args[i + 1]);
        }
        int option = flag / 100;
        int cutoff = flag % 100;
        if (option == 1) {
            State init = new State(board);
            State[] successors = init.getSuccessors();
            for (State successor : successors) {
                successor.printState(option);
            }
        } else {
            State init = new State(board);
            Stack<State> stack = new Stack<>();
            List<State> prefix = new ArrayList<>();
            int goalChecked = 0;
            int maxStackSize = Integer.MIN_VALUE;
            boolean isFound = false;
            // needed for Part E
            while (true) {	
                prefix.clear();            
                stack.push(init);
                //for all situations
                while (!stack.isEmpty()){
                    //pop a state out
                    State curr = stack.pop();
                    if (curr.parentPt != null) {
                        int parent = prefix.indexOf(curr.parentPt);
                        prefix = new ArrayList<>(prefix.subList(0, parent + 1));
                    }
                    prefix.add(curr);
                    goalChecked++;
                    if (curr.isGoalState()){
                        isFound = true;
                        break;
                    }
                    if (option == 2 || option == 3)    
                        curr.printState(option);
                    if (option == 4)
                        if (curr.depth >= cutoff)
                            break; 

                    if (curr.depth < cutoff) {
                        State[] succ = curr.getSuccessors();
                        boolean isExist = false;
                        for (int i = 0; i < succ.length; i++){
                            for (int j = 0; j < prefix.size(); j++){
                                if (succ[i].equals(prefix.get(j)))
                                    isExist = true;
                            }
                            if (!isExist)
                                stack.push(succ[i]);
                            isExist = false;
                        }
                    }

                    if(maxStackSize < stack.size())
                        maxStackSize = stack.size();

                }
                if (option == 4){
                    for (int i = 0; i < prefix.size(); i++) {
                        System.out.println(prefix.get(i).getBoard());
                    }

                }
                if (option != 5)
                    break;

                if(isFound){
                    for(int i = 0; i < prefix.size(); i++){
                        prefix.get(i).printState(2);
                    }
                    System.out.println("Goal-check " + goalChecked);
                    System.out.println("Max-stack-size " + maxStackSize);
                    break;
                }else{
                    cutoff++;
                }

            }
        }
    }
}

import java.util.*;

public class successor {
    public static class JugState {
        int[] Capacity = new int[]{0,0,0};
        int[] Content = new int[]{0,0,0};
        public JugState(JugState copyFrom)
        {
            this.Capacity[0] = copyFrom.Capacity[0];
            this.Capacity[1] = copyFrom.Capacity[1];
            this.Capacity[2] = copyFrom.Capacity[2];
            this.Content[0] = copyFrom.Content[0];
            this.Content[1] = copyFrom.Content[1];
            this.Content[2] = copyFrom.Content[2];
        }
        public JugState()
        {
        }
        public JugState(int A,int B, int C)
        {
            this.Capacity[0] = A;
            this.Capacity[1] = B;
            this.Capacity[2] = C;
        }
        public JugState(int A,int B, int C, int a, int b, int c)
        {
            this.Capacity[0] = A;
            this.Capacity[1] = B;
            this.Capacity[2] = C;
            this.Content[0] = a;
            this.Content[1] = b;
            this.Content[2] = c;
        }

        public void printContent()
        {
            System.out.println(this.Content[0] + " " + this.Content[1] + " " + this.Content[2]);
        }

        public ArrayList<JugState> getNextStates(){

            ArrayList<JugState> successors = new ArrayList<>();
            for (int i = 0; i < 3; i++){
                JugState newJug;
                if (this.Content[i] != 0){
                    newJug = new JugState(this);

                    newJug.Content[i] = 0;
                    successors.add(newJug);

                }
                if (this.Content[i] < this.Capacity[i]) {
                    newJug = new JugState(this);
                    newJug.Content[i] = newJug.Capacity[i];
                    successors.add(newJug);
                    int j,k;
                    if (i == 0) {
                        j = 1;
                        k = 2;
                    } else if (i == 1){
                        j = 2;
                        k = 0;
                    } else {
                        j = 0;
                        k = 1;
                    }
                    newJug = new JugState(this);
                    if (this.Content[j] != 0){
                        if (this.Content[j] <= (this.Capacity[i] - this.Content[i])){
                            newJug.Content[i] += this.Content[j];
                            newJug.Content[j] = 0;
                        } else {
                            newJug.Content[i] = this.Capacity[i];
                            newJug.Content[j] = this.Content[j] - (this.Capacity[i] - this.Content[i]);
                        }
                        successors.add(newJug);
                    }
                    newJug = new JugState(this);
                    if (this.Content[k] != 0){
                        if (this.Content[k] <= (this.Capacity[i] - this.Content[i])){
                            newJug.Content[i] += this.Content[k];
                            newJug.Content[k] = 0;
                        } else {
                            newJug.Content[i] = this.Capacity[i];
                            newJug.Content[k] = this.Content[k] - (this.Capacity[i] - this.Content[i]);
                        }
                        successors.add(newJug);
                    }
                }
                newJug = null;
            }
            return successors;
        }
    } 

    public static void main(String[] args) {
        if( args.length != 6 )
        {
            System.out.println("Usage: java successor [A] [B] [C] [a] [b] [c]");
            return;
        }

        // parse command line arguments
        JugState a = new JugState();
        a.Capacity[0] = Integer.parseInt(args[0]);
        a.Capacity[1] = Integer.parseInt(args[1]);
        a.Capacity[2] = Integer.parseInt(args[2]);
        a.Content[0] = Integer.parseInt(args[3]);
        a.Content[1] = Integer.parseInt(args[4]);
        a.Content[2] = Integer.parseInt(args[5]);

        // Implement this function
        ArrayList<JugState> asist = a.getNextStates();

        // Print out generated successors
        for(int i=0;i< asist.size(); i++)
        {
            asist.get(i).printContent();
        }

        return;
    }
}



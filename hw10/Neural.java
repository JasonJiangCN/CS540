import java.io.*;
import java.util.*;
public class Neural {
    static double w[] ;
    public static void main(String[] args){
        int option = Integer.valueOf(args[0]) / 100;
        w = new double[9];
        for(int i = 1; i < 10; i++){
            w[i - 1] = Double.valueOf(args[i]);
        }
        //prepare for the data of option 1 - 5
        if (option < 6){
            double x1 = Double.valueOf(args[10]);
            double x2 = Double.valueOf(args[11]);
            
        }
        if (option >= 6){
            
        }
        if (option == 1){
            
       } 



    
    
    }
}

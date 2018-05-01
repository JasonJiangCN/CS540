import java.io.*;
import java.util.*;
public class Neural {
    static double w[];
    /*
     * get partial derivatives of E
     */
    private static double[] get_PD(double[] uv, double y){
        double E = 0.5 * Math.pow(uv[5] - y, 2);
        double pd_vC = uv[5] - y;
        double pd_uC = pd_vC * uv[5] * (1-uv[5]);
        return new double[] {E, pd_vC, pd_uC};
    }
    private static double[] getUV(double[] w, double x1, double x2){
        double u_A = w[0] + w[1]*x1 + w[2]*x2;
            double u_B = w[3] + w[4]*x1 + w[5]*x2;
            double v_A = Math.max(u_A, 0);
            double v_B = Math.max(u_B, 0);
            double u_C = w[6] + w[7]*v_A + w[8]*v_B;
            double v_C = (double)1/(1+Math.exp(0-u_C));
            return new double[] {u_A, v_A, u_B, v_B, u_C, v_C};
    
    }
    private static void print(double[] r){
        String res = "";
        for (double v : r){
            res += String.format("%.5f ", v);
        }
        System.out.println(res);
    }
    public static void main(String[] args){
        int option = Integer.valueOf(args[0]) / 100;
        w = new double[9];
        for(int i = 1; i < 10; i++){
            w[i - 1] = Double.valueOf(args[i]);
        }
        //prepare for the data of option 1 - 5a
        double x1 = 0.0;
        double x2 = 0.0;
        double y  = 0.0;
        if (option < 6){
            x1 = Double.valueOf(args[10]);
            x2 = Double.valueOf(args[11]);
            if (option != 1)
                y = Double.valueOf(args[12]);
        }
        if (option >= 6){

        }
        if (option == 1){
            print(getUV(w, x1, x2));
        }
        
        if (option == 2){
            print(get_PD(getUV(w, x1,x2), y));
        }





    }
}

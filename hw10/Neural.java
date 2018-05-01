import java.io.*;
import java.util.*;

public class Neural {
    private static double[] get_weight(double x1, double x2, double y, double[] w){

        double[] uv = getUV(w, x1,x2);
        /*
         * get partial derivatives
         */
        double E = 0.5 * Math.pow(uv[5] - y, 2);
        double pd_vC = uv[5] - y;
        double pd_uC = pd_vC * uv[5] * (1-uv[5]);
        /* 
         * get hidden layer 
         */
        double pd_vA = w[7]*pd_uC;
        double pd_uA = 0.0;
        if (uv[0] >= 0)
            pd_uA = pd_vA;
        else 
            pd_uA = 0;
        double pd_vB = w[8] * pd_uC;
        double pd_uB = 0.0;
        if (uv[2] >= 0)
            pd_uB = pd_vB;
        else
            pd_uB = 0;
        /*
         *
         * get weight layer
         */
        double[] pd_w = new double[9];
        pd_w[0] = pd_uA;
        pd_w[1] = x1*pd_uA;
        pd_w[2] = x2*pd_uA;
        pd_w[3] = pd_uB;
        pd_w[4] = x1*pd_uB;
        pd_w[5] = x2*pd_uB;
        pd_w[6] = pd_uC;
        pd_w[7] = uv[1]*pd_uC;
        pd_w[8] = uv[3]*pd_uC;

        return pd_w;
    }
    private static double get_error(ArrayList<double[]> arr, double[] w){
        double err = 0.0;
        for (double[] v : arr){
            double v_C = getUV(w, v[0], v[1])[5];
            err += Math.pow(v_C - v[2], 2);
        }
        err *= 0.5;
        return err;
    }
    private static void update_w_by_SGD(double[] w, double[] pd_w, double n){
        for (int i = 0; i < w.length; i++){
            w[i] = w[i] - n*pd_w[i];
        }
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
    private static ArrayList<double[]> file_to_array(String file_name){
        ArrayList<double[]> arr = new ArrayList<double[]>();
        try {
            File file = new File(file_name);
            Scanner scnr = new Scanner(file);
            while (scnr.hasNextLine()){
                String line = scnr.nextLine();
                String[] tok = line.split(" ");
                arr.add(new double[]{Double.valueOf(tok[0]), Double.valueOf(tok[1]), Double.valueOf(tok[2])});
            }
        } catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            return null;
        }

        return arr;
    }
    public static void main(String[] args){

        double w[];
        int option = Integer.valueOf(args[0]) / 100;
        w = new double[9];
        for(int i = 1; i < 10; i++){
            w[i - 1] = Double.valueOf(args[i]);
        }
        //prepare for the data of option 1 - 5a
        double x1 = 0.0;
        double x2 = 0.0;
        double y  = 0.0;
        if (option >= 1 && option <= 5){
            x1 = Double.valueOf(args[10]);
            x2 = Double.valueOf(args[11]);
            if (option != 1)
                y = Double.valueOf(args[12]);

            double[] uv = getUV(w, x1,x2);
            if (option == 1){
                print(uv);
                return;
            }
            /*
             * get partial derivatives
             */
            double E = 0.5 * Math.pow(uv[5] - y, 2);
            double pd_vC = uv[5] - y;
            double pd_uC = pd_vC * uv[5] * (1-uv[5]);
            if (option == 2){
                print(new double[] {E, pd_vC, pd_uC});
                return;
            }
            /* 
             * get hidden layer 
             */
            double pd_vA = w[7]*pd_uC;
            double pd_uA = 0.0;
            if (uv[0] >= 0)
                pd_uA = pd_vA;
            else 
                pd_uA = 0;
            double pd_vB = w[8] * pd_uC;
            double pd_uB = 0.0;
            if (uv[2] >= 0)
                pd_uB = pd_vB;
            else
                pd_uB = 0;
            if (option == 3){
                print(new double[] {pd_vA, pd_uA, pd_vB, pd_uB});
            }
            /*
             *
             * get weight layer
             */
            double[] pd_w = new double[9];
            pd_w[0] = pd_uA;
            pd_w[1] = x1*pd_uA;
            pd_w[2] = x2*pd_uA;
            pd_w[3] = pd_uB;
            pd_w[4] = x1*pd_uB;
            pd_w[5] = x2*pd_uB;
            pd_w[6] = pd_uC;
            pd_w[7] = uv[1]*pd_uC;
            pd_w[8] = uv[3]*pd_uC;
            if (option == 4){
                print(pd_w);
                return;
            }
            if (option == 5){
                double n = Double.valueOf(args[13]);
                print(w);
                System.out.println(String.format("%.5f", E));
                update_w_by_SGD(w,pd_w, n);
                print(w);
                uv = getUV(w, x1,x2);

                E = 0.5 * Math.pow(uv[5] - y, 2);
                pd_vC = uv[5] - y;
                pd_uC = pd_vC * uv[5] * (1-uv[5]);
                System.out.println(String.format("%.5f", E));
            }
        }
        if (option >= 6){
            double n = Double.valueOf(args[10]);
            ArrayList<double[]> train = file_to_array("hw2_midterm_A_train.txt");
            ArrayList<double[]> eval = file_to_array("hw2_midterm_A_eval.txt");
            if (option == 6){
                for( int i = 0; i<train.size(); i++){
                    double[] temp = train.get(i);
                    print(new double[]{temp[0], temp[1], temp[2]});
                    double[] pd_w = get_weight(temp[0], temp[1], temp[2], w);
                    update_w_by_SGD(w, pd_w, n);
                    print(w);
                    double err = get_error(eval,w);
                    System.out.printf("%.5f\n",err);
                }
            }

        }



    }
}

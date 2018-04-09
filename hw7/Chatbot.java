
import java.util.*;
import java.io.*;
/*class triple{
  int i;
  double left;
  double right;

  }*/
public class Chatbot{
    private static String filename = "./WARC201709_wid.txt";
    private static ArrayList<Integer> readCorpus(){
        ArrayList<Integer> corpus = new ArrayList<Integer>();
        try{
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                if(sc.hasNextInt()){
                    int i = sc.nextInt();
                    corpus.add(i);
                }
                else{
                    sc.next();
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found.");
        }
        return corpus;
    }

    static public int selectBasedOnDis(ArrayList<Integer> corpus, double r, boolean print){
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for (Integer a: corpus){
            if (hm.get(a)!=null){
                hm.put(a, hm.get(a)+1);
            } else {
                hm.put(a, 1);
            }
        }
        int ret = -1;
        double[] dis = new double[hm.size() + 1];
        dis[0] = 0;
        int i = 0;
        for (int in = 0; in < 4700; in++){
            if (hm.get(in) == null){
                continue;
            }
            dis[i + 1] = hm.get(in) / (double) corpus.size() + dis[i];
            // if (((Math.abs(dis[i+1] - r) < 1e-8 || dis[i+1] > r)&& dis[i] < r) 
            if((r > dis[i] && r <= dis[i+1])|| Math.abs(r) < 1e-8){
                ret = in;
                if (print){
                    System.out.println(in);
                    System.out.println(String.format("%.7f",dis[i]));
                    System.out.println(String.format("%.7f",dis[i+1]));
                }
                break;
            }
            i++;
        }

        return ret;
    }
    static public void main(String[] args){
        ArrayList<Integer> corpus = readCorpus();
        int flag = Integer.valueOf(args[0]);
        if(flag == 100){
            int w = Integer.valueOf(args[1]);
            int count = 0;
            for (Integer a : corpus){
                if (Integer.valueOf(a) == w)
                    count++;

            }
            System.out.println(count);
            System.out.println(String.format("%.7f",count/(double)corpus.size()));
        }
        else if(flag == 200){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            double r = n1/(double)n2;
            selectBasedOnDis(corpus, r, true);
        }
        else if(flag == 300){
            int h = Integer.valueOf(args[1]);
            int w = Integer.valueOf(args[2]);
            int count = 0;
            ArrayList<Integer> words_after_h = new ArrayList<Integer>();
            for (int i = 0; i < corpus.size(); i++) {
                if(corpus.get(i) == h) {
                    words_after_h.add(corpus.get(i + 1));
                    if(corpus.get(i + 1) == w)
                        count++;
                }
            }

            //output 
            System.out.println(count);
            System.out.println(words_after_h.size());
            System.out.println(String.format("%.7f",count/(double)words_after_h.size()));
        }
        else if(flag == 400){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h = Integer.valueOf(args[3]);
            ArrayList<Integer> words_after_h = new ArrayList<Integer>();
            for (int i = 0; i < corpus.size(); i++){
                if (corpus.get(i) == h)
                    words_after_h.add(corpus.get( i + 1)); 
            }
            double r = n1 / (double) n2;
            selectBasedOnDis(words_after_h, r, true);

        }
        else if(flag == 500){
            int h1 = Integer.valueOf(args[1]);
            int h2 = Integer.valueOf(args[2]);
            int w = Integer.valueOf(args[3]);
            int count = 0;
            ArrayList<Integer> words_after_h1h2 = new ArrayList<Integer>();
            for (int i = 0; i < corpus.size(); i++) {
                if(corpus.get(i) == h1 && corpus.get(i + 1) == h2) {
                    words_after_h1h2.add(corpus.get(i + 2));
                    if(corpus.get(i + 2) == w)
                        count++;
                }
            }


            //output 
            System.out.println(count);
            System.out.println(words_after_h1h2.size());
            if(words_after_h1h2.size() == 0)
                System.out.println("undefined");
            else
                System.out.println(String.format("%.7f",count/(double)words_after_h1h2.size()));
        }
        else if(flag == 600){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h1 = Integer.valueOf(args[3]);
            int h2 = Integer.valueOf(args[4]);
            ArrayList<Integer> words_after_h1h2 = new ArrayList<Integer>();
            for (int i = 0; i < corpus.size(); i++){
                if (corpus.get(i) == h1 && corpus.get(i + 1) == h2)
                    words_after_h1h2.add(corpus.get( i + 2)); 
            }
            double r = n1 / (double) n2;
            if(words_after_h1h2.size() == 0)
                System.out.println("undefined");
            else
                selectBasedOnDis(words_after_h1h2, r, true);

        }
        else if(flag == 700){
            int seed = Integer.valueOf(args[1]);
            int t = Integer.valueOf(args[2]);
            int h1=0,h2=0;

            Random rng = new Random();
            if (seed != -1) rng.setSeed(seed);

            if(t == 0){
                //  Generate first word using r

                double r = rng.nextDouble();
                h1 = selectBasedOnDis(corpus, r, false);
                System.out.println(h1);
                if(h1 == 9 || h1 == 10 || h1 == 12){
                    return;
                }

                // Generate second word using r
                r = rng.nextDouble();
                /*
                   ArrayList<Integer> temp = wordsAfter(h1, corpus);
                   h2 = selectBasedOnDis(temp, r, false);
                   */
                ArrayList<Integer> words_after_h = new ArrayList<>();
                for (int i = 0; i < corpus.size(); i++) {
                    if(corpus.get(i) == h1) {
                        words_after_h.add(corpus.get(i + 1));
                    }
                }
                h2 = selectBasedOnDis(words_after_h, r, false);
                System.out.println(h2);
            }
            else if(t == 1){
                h1 = Integer.valueOf(args[3]);
                // TODO Generate second word using r
                ArrayList<Integer> words_after_h = new ArrayList<>();
                for (int i = 0; i < corpus.size(); i++) {
                    if(corpus.get(i) == h1) {
                        words_after_h.add(corpus.get(i + 1));
                    }
                }

                double r = rng.nextDouble();
                h2 = selectBasedOnDis(words_after_h, r, false);
                System.out.println(h2);
            }
            else if(t == 2){
                h1 = Integer.valueOf(args[3]);
                h2 = Integer.valueOf(args[4]);
            }

            while(h2 != 9 && h2 != 10 && h2 != 12){
                double r = rng.nextDouble();
                int w  = 0;
                ArrayList<Integer> words_after_h1h2 = new ArrayList<Integer>();
                for (int i = 0; i < corpus.size() - 2; i++) {
                    if(corpus.get(i) == h1 && corpus.get(i + 1) == h2) {
                        words_after_h1h2.add(corpus.get(i + 2));
                    }
                }
                int ret = selectBasedOnDis(words_after_h1h2, r, false);
                if (ret != -1){
                    w = ret;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < corpus.size(); i++) {
                        if(corpus.get(i) == h1) {
                            temp.add(corpus.get(i + 1));
                        }
                    }
                    int retVal = selectBasedOnDis(temp, r, false);
                    if (retVal != -1){
                        w = retVal;
                    } else {
                        w = selectBasedOnDis(corpus, r, false);
                        //System.out.println(r);
                    }

                }

                System.out.println(w);
                h1 = h2;
                h2 = w;
            }
        }

        return;
    }
}

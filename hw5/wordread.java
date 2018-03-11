import java.util.*;
import java.io.*;
class word{
    int frequency = 1;
    String wordm;
    public word(String wordm){
        this.wordm = wordm;
    }
}

class words {
    ArrayList<word> a = new ArrayList<word>();
    public void add(String wordm) {
        for(int i = 0; i < a.size();i++)
            if(a.get(i).wordm.equals(wordm)) {
                a.get(i).frequency ++;
                return;
            }


        a.add(new word(wordm));
    }



    public void display() {
        for(int i = a.size() - 20; i < a.size();i++)
            System.out.println( (i+1) +": " + a.get(i).wordm + " " + " counts: " +  a.get(i).frequency);

    }

    public void filedisplay() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter("_out.txt", "UTF-8");
        for(int i = 0; i < a.size();i++)
            writer.printf( (i+1) + "," + a.get(i).frequency + "\n");

        writer.close();
    }

    public int length() {
        return a.size();
    }


    public void srt() {
        int n = a.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (a.get(i).frequency < a.get(k).frequency) {
                    swapNumbers(i, k);
                }
            }
        }
    }

    private void swapNumbers(int i, int j) {

        word temp;
        temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }


}

public class wordread {
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{
        int occur = 0;
        String filename = "";
        words comw = new words();  
        for (int i = 1; i < 364; i++){
            if (i < 10)
                filename = "./docs/00" + i + ".txt";
            else if (i >=10 && i < 100)
                filename = "./docs/0"+i+".txt";
            else 
                filename = "./docs/"+i + ".txt";
            File file = new File(filename);
            Scanner scnr = new Scanner(file);
            System.out.println(filename);

            while(scnr.hasNext()){
                String[] split = scnr.nextLine().trim().split(" ");
                for (int j = 0; j < split.length; j++){
                    occur++;
                    comw.add(split[j]);
                }

            }
            scnr.close();

        }

        System.out.println(occur);
    }
}

package hw5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class words {
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

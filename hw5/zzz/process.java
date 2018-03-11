package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class process {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		int occur = 0;
		words comw = new words();
		String filename = "";
		for(int i = 1; i <364; i++) {
			
			if(i < 10)
				filename = "00" + i + ".txt";
			else if(i < 100)
				filename = "0" + i + ".txt";
			else if(i < 100)
				filename = i + ".txt";
			File file = new File(filename);
			Scanner scnr = new Scanner(file);
			while(scnr.hasNext()){
	    		 String [] split = scnr.nextLine().trim().split(" ");
	             for(int j = 0; j < split.length; j ++) {
	            	 occur ++;
	            	 comw.add(split[j]);
	             }
	            	 
	         
	         }  
			scnr.close();
		}
		//comw.srt();
		//comw.filedisplay();
		System.out.println(occur);
	}

}

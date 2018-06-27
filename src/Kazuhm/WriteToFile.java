package Kazuhm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteToFile {

	public static void writeToFile( String str ) {
	         
	        BufferedWriter bufferedWriter = null;
	        try {
	            String strContent = str;
	            File myFile = new File("C:/writeToFile.txt");
	            // check if file exist, otherwise create the file before writing
	            if (!myFile.exists()) {
	                myFile.createNewFile();
	            }
	            Writer writer = new FileWriter(myFile);
	            bufferedWriter = new BufferedWriter(writer);
	            bufferedWriter.write(strContent);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally{
	            try{
	                if(bufferedWriter != null) bufferedWriter.close();
	            } catch(Exception ex){
	                 
	            }
	        }
	}
	    
	
}

package Kazuhm;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class UnitTest {


	    @Test
	    public void getHTMLTest() throws Exception {
	    		 
	    		
	    		String str = Asteroids.getHTML( "2015-09-07", "2015-09-11" );
	    		
	    		writeToFile(str);
	    		
	    		JSONParser parser = new JSONParser();
	    		Object obj = parser.parse(new FileReader("/Users/behrokh/writeToFile.txt"));
	    		
	    		JSONObject jsonObject = (JSONObject) obj;
	    		Long elementCountObj = (Long) jsonObject.get("element_count");
	    		Integer element_count = (int) (long) elementCountObj;
	    		
	        // assert statements
	    		assertEquals(51, (int) element_count);
	    }
	    
	    private static void writeToFile(String newStrs) {
			BufferedWriter bufferedWriter = null;
	        try {
	            String strContent = newStrs;
	            File myFile = new File("/Users/behrokh/writeToFile.txt");
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

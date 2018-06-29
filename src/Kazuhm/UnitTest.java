package Kazuhm;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import org.junit.runner.JUnitCore;

public class UnitTest {

//		public static void main(String[] args) throws Exception {                    
//			JUnitCore.main();  
//			
//		}

	    @Test
	    public void AsteroidsTest() throws Exception {
	    		 
	    		
	    		String str = Asteroids.getHTML( "2015-09-07", "2015-09-09" );
	    		
	    		writeToFile(str);
	    		
	    		JSONParser parser = new JSONParser();
	    		Object obj = parser.parse(new FileReader("/Users/behrokh/writeToFile.txt"));
	    		
	    		JSONObject jsonObject = (JSONObject) obj;
	    		Long elementCountObj = (Long) jsonObject.get("element_count");
	    		Integer element_count = (int) (long) elementCountObj;
	    		
	    		HashMap<String, Double> mapNameVelocity = Asteroids.mappingNameVelocity(obj);
	    		List<Pair> result = Asteroids.sortedByVelocity ( mapNameVelocity, element_count );
	    		
	        // assert statements
	    		assertEquals( 31, (int) element_count );
	    		
	    		// Testing mappingNameVelocity()
	    		assertEquals( 31, mapNameVelocity.size() );
	    		assertEquals( (Double) 44178.3303023807, mapNameVelocity.get("(2008 QV11)") );
	    		assertEquals( (Double) 2601.6909079299, mapNameVelocity.get("440012 (2002 LE27)") );
	    		
	    		// Testing sortedByVelocity()
	    		assertEquals( 31, result.size() );
	    		assertEquals( "440012 (2002 LE27)", result.get( result.size() - 1 ).name );
	    		assertEquals( (Double)  2601.6909079299, result.get( result.size() - 1 ).velocity );
	    		assertEquals( "(2008 QV11)", result.get(0).name );
	    		assertEquals( (Double)  44178.3303023807, result.get(0).velocity );
	    		
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

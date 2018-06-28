//package Kazuhm;
//
//
//import java.io.*;
//import java.net.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
//
//public class InterviewQuestion {
//	
//	public static void main ( String[] args ) throws Exception {
//		 
//		 String start_date_pattern = "2015-09-07";
//		 String end_date_pattern = "2015-09-11";
//		
////		 String newStrs = getHTML ( start_date_pattern, end_date_pattern );
////		 System.out.println(newStrs);
////		 writeToFile(newStrs);
//		 
//		 JSONParser parser = new JSONParser();
//		 Object obj = parser.parse(new FileReader("/Users/behrokh/writeToFile.txt"));
//		 
//		 // Extracting number of element in our data
//		 JSONObject jsonObject = (JSONObject) obj;
//         Long elementCountObj = (Long) jsonObject.get("element_count");
//         Integer element_count = (int) (long) elementCountObj;
//         System.out.println("element_count: " + elementCountObj);
//         
//		 HashMap<String, Double> mapNameVelocity = mappingNameVelocity(obj);
//		 
//		 List<Pair> result = sortedByVelocity ( mapNameVelocity, element_count );
//		 
//		 Iterator<Pair> it = result.iterator();
//         while ( it.hasNext() ) {
//        	 	Pair curr = it.next();
//        	 	System.out.println( curr.name + ":" + curr.velocity );
//         }
//	}
//	
//	public static HashMap<String, Double> mappingNameVelocity ( Object obj ) {
//	
//		 HashMap<String, Double> mapNameVelocity = new HashMap<>();
//		 
//         JSONObject jsonObject = (JSONObject) obj;
//         System.out.println( "JSON object has " + jsonObject.size() + " components: ");
//         for ( Object key : jsonObject.keySet() ) {
//        	 	System.out.println(key);
//         }
//         System.out.println("\n");       
//         
//         System.out.println("Interested in \"near_earth_objects\".");
// 	 	
// 	 	 JSONObject nearEarthObjs = (JSONObject) jsonObject.get("near_earth_objects");
// 	 	 
//         System.out.println("nearEarthObjs : " + nearEarthObjs.keySet());
//         System.out.println("\n");
//         
//         for ( Object key : nearEarthObjs.keySet() ) {
//        	 	
//        	 	
//        	 	JSONArray dateObject = (JSONArray) nearEarthObjs.get(key);
//        	 	System.out.println("date is: " + key + " and the number of objects in this date is : " + dateObject.size() + "." );
//        	 	
//        	 	for ( Object dateArray : dateObject ) {
//        	 		
//            	 	JSONObject dateArrayObj = (JSONObject) dateArray;
//            	 	//String neorefObjArray = (String) dateArrayObj.get("neo_reference_id");
//            	 	String name = (String) dateArrayObj.get("name");
//            	 	
//            	 	JSONArray closeApproachObjArray = (JSONArray) dateArrayObj.get("close_approach_data");
//            	 	
//            	 	for ( Object closeApproach : closeApproachObjArray ) {
//
//            	 		JSONObject closeApproachObject = (JSONObject) closeApproach;
//            	 		JSONObject reletiveVelocityObjArray = (JSONObject) closeApproachObject.get("relative_velocity");
//
//            	 		String milesperhourObj = (String) reletiveVelocityObjArray.get("miles_per_hour");
//            	 		Double velocity = Double.valueOf(milesperhourObj);
//            	 		
//                	 	if ( !mapNameVelocity.containsKey(name) ) {
//                	 		mapNameVelocity.put(name, velocity);
//                	 	}
//            	 	}
//             }
//        	 	          
//         }
//         
//         System.out.println(mapNameVelocity);
//         return mapNameVelocity;
//	}
//
//	// another method to sort by velocity 
//	public static List<Pair> sortedByVelocity ( HashMap<String, Double> mapNameVelocity, Integer element_count) {
//         // Now sorting process
//         PriorityQueue<Pair> pq = new PriorityQueue ( element_count, new VelocityComparator() );
//         
//         //HashMap<String, Double> mapNameVelocity = new HashMap<>();
//         
//         for ( Map.Entry<String, Double> entry : mapNameVelocity.entrySet() ) {
//        	 	 Pair p = new Pair(entry.getKey(), entry.getValue());
//             pq.offer(p);
//         }
//         System.out.println(pq.size());
//         
//         
//         List<Pair> result = new ArrayList<Pair>();
//         while(pq.size()>0){
//             result.add(pq.poll());
//         }
//         
//         System.out.println(result.size());
//         return result;
//	}
//         
//     
//
//
//	
//	public static String getHTML ( String start_date_pattern, String end_date_pattern ) throws Exception {
//				
//		String urlToRead = "https://api.nasa.gov/neo/rest/v1/feed?" + "start_date=" + start_date_pattern + "&end_date=" + end_date_pattern + "&api_key=DEMO_KEY";
//	  
//		URL url = new URL(urlToRead);
//	  
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	  
//		conn.setRequestMethod("GET");
//	    
//		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	    	
//		StringBuilder result = new StringBuilder();
//		String line;
//	      
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//			result.append("\n");
//		}
//	      
//		rd.close();
//	      
//		return result.toString();
//	}
//
//
//	private static void writeToFile(String newStrs) {
//		BufferedWriter bufferedWriter = null;
//        try {
//            String strContent = newStrs;
//            File myFile = new File("/Users/behrokh/writeToFile.txt");
//            // check if file exist, otherwise create the file before writing
//            if (!myFile.exists()) {
//                myFile.createNewFile();
//            }
//            Writer writer = new FileWriter(myFile);
//            bufferedWriter = new BufferedWriter(writer);
//            bufferedWriter.write(strContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            try{
//                if(bufferedWriter != null) bufferedWriter.close();
//            } catch(Exception ex){
//                 
//            }
//        }
//		
//	}
//
//}
//
//

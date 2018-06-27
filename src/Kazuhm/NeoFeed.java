package Kazuhm;

import java.text.SimpleDateFormat;

public class NeoFeed {

	String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY";
	
	String API_KEY = "DEMO_KEY";
	
	String start_date_pattern = "2018-05-01";
	SimpleDateFormat START_DATE = new SimpleDateFormat(start_date_pattern);
	
	String end_date_pattern = "2018-05-15";
	SimpleDateFormat END_DATE = new SimpleDateFormat(end_date_pattern);
	
	
	
	
}

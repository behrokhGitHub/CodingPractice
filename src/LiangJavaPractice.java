
public class LiangJavaPractice {
	/*
	 * Dec2Hex
	 */
	public static String dec2Hex ( int dec ) {
		
		String output = "";
		
		while ( dec != 0 ) {
			
			//Starting from modules
			int hexVal = dec % 16;
			
			char hexDigit = ( hexVal >= 0 && hexVal <= 9 ) ? (char) ( hexVal + '0' ) : (char) ( hexVal - 10 + 'A' );
			
			output = hexDigit + output;
			
			dec = dec / 16;
		
		}
		return output;
	}
	
	
	public static void main ( String[] args ) {
		
		int dec = 29;
		System.out.println( "hex value is :" + dec2Hex ( dec ));
	}

}

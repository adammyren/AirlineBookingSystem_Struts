package Utilities;

public class BookingUtilities {
	
	public static boolean validateDate(String date){
		String[] stringArray = date.split("-");
		try{
			int yyyy = Integer.parseInt(stringArray[0]);
			int mm = Integer.parseInt(stringArray[1]);
			int dd = Integer.parseInt(stringArray[2]);
			if(yyyy>2100||yyyy<2016||mm>12||mm<1||dd>31||dd<1)
				return false;
			
			return true;
			
		}catch (Exception e){
			return false;
		}
	}

}

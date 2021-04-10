package collectionsAndJava8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CompareDate{
	public static int compareDate(Date date1, Date date2) {
		int result = -1;
		
		if (date1.compareTo(date2) > 0) {
			  
            System.out.println("Date1 is after Date2");
        }
  
        else if (date1.compareTo(date2) < 0) {
  
            System.out.println("Date1 is before Date2");
        }
  
        else if (date1.compareTo(date2) == 0) {
  
            System.out.println("Date1 is equal to Date2");
        }
		return result;
	}
}

public class CompareDateProgram {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdformat.parse("2021-04-15");
		Date date2 = sdformat.parse("2021-04-10");
		CompareDate.compareDate(date1, date2);
	}
}

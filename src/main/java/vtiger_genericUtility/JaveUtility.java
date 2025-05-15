package vtiger_genericUtility;

import java.util.Date;
import java.util.Random;
/**
 * @author naimi
 */
public class JaveUtility {
	/**
	 * this method used to create random number
	 * @return
	 */
public int toGetRandomnumber(){
	Random r=new Random();
	int random=r.nextInt(1000);
	return random;
}
/**
 * this method is used to get sysyem date and time format
 * @return
 */

public String toGetSystemDateAndTime() {
	Date d=new Date();
	String date[]=d.toString().split(" ");
	String day=date[0];
	String month=date[1];
	String date1=date[2];
	String time=date[3].replace(":",".");
	String year=date[5];
	String finalDate=day+" "+month+" "+date1+" "+time+" "+year;
	return finalDate;
	
}
}

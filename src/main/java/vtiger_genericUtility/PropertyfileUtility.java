package vtiger_genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
*the class consist of method related to read the data from property file
*@author naimi
*/

public class PropertyfileUtility {
/**
	*This method is used to read data from property provided key
	*@param key
	*@return
	*@throws IOException
	
*/
		public String toReadDataFromPropertyFile(String key) throws IOException {
	
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Common_Data.properties");//take source from prpertis loc
		Properties prop=new Properties();
        prop.load(fis);//give connection to fis and  pfis
        String value = prop.getProperty(key);
       return value;
	}
}
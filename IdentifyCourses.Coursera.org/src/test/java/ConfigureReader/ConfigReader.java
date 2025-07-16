package ConfigureReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties property;
	static {
		try {

			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\data.properties");

			property=new Properties();
			property.load(file);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static String getProperty(String key) {
		return property.getProperty(key);
	}
}

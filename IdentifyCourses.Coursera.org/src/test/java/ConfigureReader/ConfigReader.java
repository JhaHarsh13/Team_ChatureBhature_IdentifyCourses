package ConfigureReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties property;
	static {
		try {
<<<<<<< HEAD
			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
=======

			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\data.properties");

>>>>>>> 6dc509306c7a3bf494a42661937b4385ba3f4f25
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

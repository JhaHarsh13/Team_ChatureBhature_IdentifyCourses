package ConfigureReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties property;
	static {
		try {
			FileInputStream file= new FileInputStream("C:\\Users\\2408354\\git\\Team_ChatureBhature_IdentifyCourses\\IdentifyCourses.Coursera.org\\data.properties");
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

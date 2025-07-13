package ConfigureReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties property;
	static {
		try {
			InputStream file= ConfigReader.class.getClassLoader().getSystemResourceAsStream("data.properties");
			property.load(file);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public static String getProperty(String key) {
		return property.getProperty(key);
	}
}

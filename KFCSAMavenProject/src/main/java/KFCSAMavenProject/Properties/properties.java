package KFCSAMavenProject.Properties;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class properties {
	
	 static Properties property;
	 
	 public static void loadData() throws Exception
	 {
		 property = new Properties();
		 String configPath = "./src/main/java/KFCSAMavenProject/Properties/config.properties";
		 File file = new File(System.getProperty("user.dir")+configPath);
		 FileReader read = new FileReader(file);
		 property.load(read);
	 }
	 
	 public static String getDataFromProperty(String key) throws Exception
	 {
		 loadData();
		 String propData = property.getProperty(key);
		 return propData;
		 
	 }

}

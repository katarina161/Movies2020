package rs.ac.bg.fon.nprog.Movies.configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Configuration {
	private Properties properties;
	private static Configuration instance;
	
	private Configuration() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("src\\main\\resources\\configuration.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getInstance() {
		if(instance == null)
			instance = new Configuration();
		
		return instance;
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getPort() {
        return properties.getProperty("port");
    }
    
    public void setPort(int port) throws Exception {
        properties.put("port", port + "");
        writeToFile();
    }
    
    public void setDbConfig(String username, String password, String url) throws Exception {
        properties.put("username", username);
        properties.put("password", password);
        properties.put("url", url);
        writeToFile();
    }
    
    private void writeToFile() throws Exception {
    	FileOutputStream out = new FileOutputStream("src\\main\\resources\\configuration\\configuration.properties");
    	properties.store(out, "");
    	out.close();
    }


}

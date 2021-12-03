package mavenJavaDump;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Hello world!
 *
 */
public class App 
{
	public static String Log4JPath = null;
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		initApp();
		logger.info("Hello");
	}

	public static String getLog4JPath() {
		return Log4JPath;
	}

	public static void setLog4JPath(String log4jPath) {
		Log4JPath = log4jPath;
	}

	public static Properties getApplicationProperties() {
		App application = new App();

		InputStream inputStream = null;
		Properties applicationProp = null;
		try {
			inputStream = new FileInputStream(new File("./resources/application.properties"));
			applicationProp = new Properties();
			applicationProp.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return applicationProp;
	}

	public static void initApp() {
		Properties applicationProperties = getApplicationProperties();

		setLog4JPath(applicationProperties.getProperty("LOG4J_PATH"));

		loadLog4j();
	}

	private static void loadLog4j() {

		PropertyConfigurator.configure(getLog4JPath());
	}
}

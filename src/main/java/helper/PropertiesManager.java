package helper;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	private static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
	private static ThreadLocal<String> browser = new ThreadLocal<String>();

	static Logger log;

	static {
		log = Logger.getLogger(PropertiesManager.class);
	}

	public static Properties getProperties() {
		if (props.get() == null ) {
			// this is need when running tests from IDE
			log.info("Thread has no Properties loaded, creating new one");
			props.set(new Properties());
			loadPropertiesFromResource();
		}

		log.debug("Getting instance of Properties manager"
				+ props.get().getClass());
		return props.get();
	}

	public static void loadPropertiesFromResource() {
		loadProperties("app.properties");
		browser.set(props.get().getProperty("browser").trim());
	}


	public static void loadProperties(String fileName) {

		InputStream inputStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream(fileName);

		System.out.println("***** loading property file: " + fileName);
		System.out.println("***** Input Stream: " + inputStream);
		System.out.println("***** Properties: " + props.get());

		try {
			if (inputStream != null)
				props.get().load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (inputStream == null) {
			String message = "property file '" + fileName
					+ "' not found in the classpath";
			log.error(message);

		}
	}

}

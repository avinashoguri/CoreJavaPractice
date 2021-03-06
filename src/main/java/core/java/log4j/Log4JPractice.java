package core.java.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4JPractice {

	private static final Logger LOGGER = Logger.getLogger(Log4JPractice.class);

	@Test
	public void debugLogMessages() {
		LOGGER.debug("debug message");
	}

	@Test
	public void errorLogMessage() {
		LOGGER.error("error message");
	}

	@Test
	public void logException() {
		try {
			int result = 10 / 0;
			System.out.println(result);
		} catch (Exception e) {
			LOGGER.error("Exception in divide", e);
		}
	}
}
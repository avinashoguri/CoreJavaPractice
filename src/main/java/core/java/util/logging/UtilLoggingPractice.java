package core.java.util.logging;

import java.util.logging.Logger;

import org.junit.Test;

public class UtilLoggingPractice {

	private static final Logger LOGGER = Logger.getLogger("UtilLoggingPractice");

	@Test
	public void infoLogMessage() {
		LOGGER.info("info message");
	}

}
package core.java.log4j;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MethodHandlesPractice {

	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void infoLogMessage() {
		LOGGER.info("info message");
	}

	@Test
	public void debugLogMessage() {
		LOGGER.debug("debug message");
	}
}
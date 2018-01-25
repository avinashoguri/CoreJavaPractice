package core.java.util.logging;

import java.lang.invoke.MethodHandles;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class MethodHandlesPractice {

	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());

	@Test
	public void severeMessage() {
		LOGGER.log(Level.SEVERE, "severe message");
	}
}
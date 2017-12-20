package engineers.workshop.common.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class EWLogger {
	private static Logger logger;
	public static void setLogger(Logger _logger) {
		logger = _logger;
	}

	private static String format(Object o, Object... data) {
		return String.format(String.valueOf(o), data);
	}

	private static void log(Level logLevel, Object info, Object... data) {
		if (data == null)
			data = new Object[0];
		logger.log(logLevel, format(info, data));
	}
	
	public static void log(Object info, Object...data){
		log(Level.ALL, info, data);
	}

	public static void debug(Object info, Object... data) {
		log(Level.DEBUG, info, data);
	}

	public static void warn(Object info, Object... data) {
		log(Level.WARN, info, data);
	}

	public static void info(Object info, Object... data) {
		log(Level.INFO, info, data);
	}

	public static void error(Object info, Object... data) {
		log(Level.ERROR, info, data);
	}
	
	
	public EWLogger(Object info, Object... data){
		log(info, data);
	}

	public static void stacktrace(String message) {
		try {
			throw new Exception(message != null ? message : "Stacktracing!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

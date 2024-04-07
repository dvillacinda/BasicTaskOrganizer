package mx.com.gm.spring.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
	private static final String BUNDLE_NAME = "message";
	
	public static String getMessage(String key, Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		return bundle.getString(key); 
	}
}

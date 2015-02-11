package org.senssic.util;

import java.io.InputStream;
import java.util.Properties;

public class ProUtl {

	private Properties props;
	private InputStream mailProp;

	public ProUtl() {
		this("trainurlinf.properties");
	}

	public ProUtl(String filename) {
		mailProp = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(filename);
		props = new Properties();
		try {
			props.load(mailProp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		String value = props.getProperty(key);
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

}

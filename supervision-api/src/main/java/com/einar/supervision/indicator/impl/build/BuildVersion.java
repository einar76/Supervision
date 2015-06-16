package com.einar.supervision.indicator.impl.build;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class BuildVersion extends StaticIndicator {

	@Override
	public long getId() {
		return 1301;
	}

	@Override
	public String getValue() {
		return readPropertie("Implementation-Version");
	}

	@Override
	public String getName() {
		return "BUILD_VERSION";
	}

	protected String readPropertie(String parameter) {
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "version.properties";
			input = BuildVersion.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				return "no data";
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			return prop.getProperty(parameter);

		} catch (IOException ex) {
			ex.printStackTrace();
			return "no data";
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

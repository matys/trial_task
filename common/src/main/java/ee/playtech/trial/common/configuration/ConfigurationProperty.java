package ee.playtech.trial.common.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum ConfigurationProperty {

	SERVER_HOST("trial.server.host"), SERVER_PORT("trial.server.port"), MAX_BALANCE_CHANGE(
			"trial.client.balance.change.max"), BALANCE_STRATEGY_CHANGE("trial.client.balance.change.strategy"), TRANSACTION_ID_GENERATOR("trial.client.transaction.id.generator"), USER_NAME("trial.client.user.name"), UPDATES_BREAK_LENGTH("trial.client.updates.break.length");
	

	private static final String PROPERTIES_FILE_NAME = "game-system.properties";
	private static final String PATH_SEPARATOR = "/";

	private static Properties properties = null;

	private final String key;

	private ConfigurationProperty(String key) {
		this.key = key;
	}

	public String getValue() {
		return getConfiguration().getProperty(key);
	}

	@Override
	public String toString() {
		return key;
	}

	public Properties getConfiguration() {
		if (properties == null) {
			initProperties();
		}
		return properties;
	}

	private void initProperties() {
		InputStream input = null;
		try {
			String propertiesPath = createPropertiesDirectoryPath();
			input = new FileInputStream(propertiesPath + PROPERTIES_FILE_NAME);
			properties = new Properties();
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String createPropertiesDirectoryPath() {
		String jarPath = ConfigurationProperty.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String[] directories = jarPath.split(PATH_SEPARATOR);
		String propertiesPath = "";
		for (int i = 0; i < directories.length - 3; i++) {
			propertiesPath += directories[i] + PATH_SEPARATOR;
		}
		propertiesPath += "common/";
		return propertiesPath;
	}
}
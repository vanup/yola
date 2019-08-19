package functions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileData {

	private String dataFolder;
	private String dataFile;

	public PropertyFileData(String dataFolder, String dataFile) {
		setDataFolder(dataFolder);
		setDataFile(dataFile);
	}

	public String getDataFolder() {
		return dataFolder;
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	public String getDataFile() {
		return dataFile;
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

	/**
	 * Searches for the property with the specified key in this property list.
	 * If the key is not found in this property list, the default property list,
	 * and its defaults, recursively, are then checked. The method returns null
	 * if the property is not found.
	 * 
	 * @param key
	 *            the property key.
	 * @return the value in this property list with the specified key value.
	 */
	public String getProperty(String key) {
		String value = null;

		try {
			String dataFilePath = System.getProperty("user.dir") + "/src/test/java/data/" + getDataFolder() + "/" + getDataFile();
			Properties properties = new Properties();
			properties.load(new FileInputStream(dataFilePath));
			value = properties.getProperty(key);
		} catch (IOException e) {
			System.out.println("Error reading property file.");
			e.printStackTrace();
		}
		return value;
	}

}

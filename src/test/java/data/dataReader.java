package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;

import tools.jackson.databind.ObjectMapper;

public class dataReader{
//refer Video 177 for any queries
	public void getJsonData() throws IOException {
	String json = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\data\\browser.json"), StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	}
}

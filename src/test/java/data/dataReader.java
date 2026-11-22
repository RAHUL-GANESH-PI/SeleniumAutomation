package data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;


public class dataReader{
//refer Video 177 for any queries
	public void getJsonData() throws IOException {
	String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\data\\browser.json"),
			StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> () {
	}
	);
	}
}

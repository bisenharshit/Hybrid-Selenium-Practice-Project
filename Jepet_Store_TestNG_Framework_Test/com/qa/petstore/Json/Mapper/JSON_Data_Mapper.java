package com.qa.petstore.Json.Mapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON_Data_Mapper {

	public static List<HashMap<String, String>> getJsonDataToMap() throws IOException {

		// Read Json to String
		String jsoncontent = FileUtils.readFileToString(
				new File("Jpet_Store_TestNG_Framework_Resources//JSON Data//Data.json"),
				StandardCharsets.UTF_8);

		// String to Hashmap by jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}

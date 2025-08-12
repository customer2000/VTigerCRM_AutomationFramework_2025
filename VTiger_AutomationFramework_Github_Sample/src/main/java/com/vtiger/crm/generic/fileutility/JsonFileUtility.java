package com.vtiger.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileUtility {
	public String getDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./appConfigData/CommonData.json"));
		JSONObject jobj=(JSONObject)obj;
		String data = (String)jobj.get(key);
		return data;
	}
}

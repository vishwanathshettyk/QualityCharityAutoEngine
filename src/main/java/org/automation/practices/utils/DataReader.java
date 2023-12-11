package org.automation.practices.utils;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.automation.practices.factory.BaseTest;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataReader {

    private String jsonData;
    private final String FILE_NAME = "src/test/resources/elements/controllers.yml";
    private final String YML_FILE_NAME = "src/test/resources/elements/";

    public DataReader() throws IOException {
        jsonData = Files.readString(Paths.get(FILE_NAME));
    }

    public String getValue(String key) throws IOException {
        JSONObject jsonObject = new JSONObject(jsonData);
        return  (String) jsonObject.getJSONObject(key).get("value");
    }

    public String getLocator(String key) throws IOException {
        JSONObject jsonObject = new JSONObject(jsonData);
        return  (String) jsonObject.getJSONObject(key).get("locator");
    }

    public Map loadData() throws FileNotFoundException, YamlException {
        File folder = new File(YML_FILE_NAME);
        File[] listOfFiles = folder.listFiles();
        Map x = new HashMap();
        for (File file : listOfFiles)
        {
            YamlReader yamlReader = new YamlReader(new FileReader(file));
            Map y =  (Map) yamlReader.read();
            x.putAll(y);
        }
        return x;
    }

    public Map getPageObjects(Map pageData, String pageName) throws FileNotFoundException, YamlException {
        return (Map) pageData.get(pageName);
    }
}


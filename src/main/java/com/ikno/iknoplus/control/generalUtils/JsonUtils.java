package com.ikno.iknoplus.control.generalUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

public class JsonUtils {

    /**
     * Convert json file to any type of object
     * 
     * @param <T>
     * @param path
     * @param objectClass
     * @return
     * @throws IOException
     */
    public static <T> T readObjectFromJsonFile(String path, Class<T> objectClass) throws IOException {

        // FileReader fileReader = new FileReader(path);
        // BufferedReader reader = new BufferedReader(fileReader);

        BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8));

        // StringBuilder sb = new StringBuilder();

        // String line = "";
        // while ((line = reader.readLine()) != null) {
        // sb.append(line);
        // }

        // fileReader.close();

        Gson gson = new Gson();
        var object = gson.fromJson(reader, objectClass);

        reader.close();

        // Gson gson = new Gson();
        // return gson.fromJson(sb.toString(), objectClass);
        return object;
    }

    public static void writeObjectToJsonFile(Object object, String path) throws IOException {

        Gson gson = new Gson();
        String batchString = gson.toJson(object);

        FileWriter writer = new FileWriter(path, StandardCharsets.UTF_8);
        writer.write(batchString);
        writer.flush();
        writer.close();

    }

}

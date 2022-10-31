package StartAtGoogle.week2.exceptions;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private HashMap<String, String> mapConfig;

    public Configuration() {
        this.mapConfig = new HashMap<>();
    }

    public Map<String, String> getMap() {
        if ( mapConfig == null) {
            throw new NullPointerException("the configuration map is not initialized!");
        }
        return mapConfig;
    }

    public void readFromFile(String filename) {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filename)) {

            // Convert JSON File to HashMap
            mapConfig = gson.fromJson(reader, HashMap.class);

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException ex: "+ e);
            writeToFile("src/main/java/startAtGoogle/week2/exceptions/defaultConfig.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName) {
        System.out.println("writing to default file... ");
        Gson gson = new Gson();

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            mapConfig = new HashMap<>();
            mapConfig.put("id", "17");
            mapConfig.put("kobe", "Bryant");
            mapConfig.put("Number", "8");

            String defaultConfig = gson.toJson(mapConfig);
            oos.writeObject(defaultConfig);

            System.out.println("Successfully wrote to the file.");
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException ex: "+ ex);
        } catch (IOException ex) {
            System.out.println("IOException ex: "+ ex);
        }
    }

    public String getValueOfKey(String key) {
        if (mapConfig.get(key) != null) {
            return mapConfig.get(key);
        }
        throw new IllegalArgumentException("the key...");
    }

}

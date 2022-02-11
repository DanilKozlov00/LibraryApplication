package dao;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryXmlData implements DictionaryData {

    private final String dictionaryPath;
    private final String separator;

    public DictionaryXmlData(String dictionaryPath, String separator) {
        this.dictionaryPath = dictionaryPath;
        this.separator = separator;
    }

    public Map<String, String> readDictionary() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.dictionaryPath), StandardCharsets.UTF_8))) {
            String line;
            Map<String, String> dictionaryPairs = new LinkedHashMap<>();
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split(this.separator);
                dictionaryPairs.put(lineWords[0], lineWords[1]);
            }
            return dictionaryPairs;
        } catch (IOException e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }

    public void writeDictionary(Map<String, String> dictionaryPairs) {
        try (BufferedWriter writerStream = new BufferedWriter(new FileWriter(this.dictionaryPath))) {
            for (Map.Entry<String, String> pair : dictionaryPairs.entrySet()) {
                writerStream.write(pair.getKey() + this.separator + pair.getValue() + "\n");
                writerStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

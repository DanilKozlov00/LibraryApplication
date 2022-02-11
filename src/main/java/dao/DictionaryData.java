package dao;

import java.util.Map;

public interface DictionaryData {

    Map<String, String> readDictionary();

    void writeDictionary(Map<String, String> dictionaryPairs);
}

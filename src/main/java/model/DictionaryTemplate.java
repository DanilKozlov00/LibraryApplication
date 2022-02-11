package model;

import dao.DictionaryData;

import java.util.Map;

public interface DictionaryTemplate {

    String addPair(String key, String value);

    String deletePair(String key);

    String findPair(String key);

    Map<String, String> readPairs();

    DictionaryData getDictionaryData();

    Map<String, String> getDictionaryPairs();

    String getDictionaryName();
}

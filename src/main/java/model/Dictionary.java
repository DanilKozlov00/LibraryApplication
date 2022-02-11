package model;

import dao.DictionaryData;
import dao.DictionaryXmlData;
import utils.Validator;
import utils.configuration.Config;

import java.util.Map;

public class Dictionary implements DictionaryTemplate {

    private final Map<String, String> dictionaryPairs;
    private final DictionaryXmlData dictionaryXmlData;
    private final Validator validator;
    private final String dictionaryName;

    public Dictionary(Config libraryConfig) {
        this.dictionaryXmlData = new DictionaryXmlData(libraryConfig.getDictionaryPath(), libraryConfig.getSeparator());
        this.validator = new Validator(libraryConfig.getKeyPattern(), libraryConfig.getValuePattern());
        this.dictionaryPairs = this.dictionaryXmlData.readDictionary();
        this.dictionaryName = libraryConfig.getDictionaryName();
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    @Override
    public String addPair(String key, String value) {
        this.dictionaryXmlData.readDictionary();
        if (validator.isValidKey(key)) {
            if (validator.isValidValue(value)) {
                dictionaryPairs.put(key, value);
                dictionaryXmlData.writeDictionary(dictionaryPairs);
                return "Pair added";
            } else return "Invalid value pattern";
        } else return "Invalid key pattern";
    }

    @Override
    public String deletePair(String key) {
        this.dictionaryXmlData.readDictionary();
        if (dictionaryPairs.remove(key) != null) {
            dictionaryXmlData.writeDictionary(dictionaryPairs);
            return "Pair is deleted";
        }
        return "Pair not deleted";
    }

    @Override
    public String findPair(String key) {
        String value = dictionaryPairs.get(key);
        if (value == null) {
            return "Not find pair";
        } else return "Find: Key" + key + ". Value" + value;
    }

    @Override
    public Map<String, String> readPairs() {
        this.dictionaryXmlData.readDictionary();
        return this.dictionaryPairs;
    }

    @Override
    public DictionaryData getDictionaryData() {
        return this.dictionaryXmlData;
    }

    @Override
    public Map<String, String> getDictionaryPairs() {
        return null;
    }

}

package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;
import utils.configuration.Config;
import utils.configuration.LibraryConfig;

import java.util.LinkedList;
import java.util.List;

@Component
public class DictionaryFactory {

    LibraryConfig libraryConfig;

    @Autowired
    public DictionaryFactory(LibraryConfig libraryConfig) {
        this.libraryConfig = libraryConfig;
    }

    public List<Dictionary> getDictionary() {
        List<Dictionary> dictionaryList = new LinkedList<>();
        NodeList dictionaryConfigList = libraryConfig.readConfig();
        for (int i = 0; i < dictionaryConfigList.getLength(); i++) {
            dictionaryList.add(new Dictionary(new Config(dictionaryConfigList.item(i))));
        }
        return dictionaryList;
    }
}

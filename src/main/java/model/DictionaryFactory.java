package model;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.configuration.Config;
import utils.configuration.LibraryConfig;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DictionaryFactory {

    LibraryConfig libraryConfig;

    public DictionaryFactory(LibraryConfig libraryConfig) {
        this.libraryConfig = libraryConfig;
    }

    public List<Dictionary> getDictionary() throws ParserConfigurationException, IOException, SAXException {
        List<Dictionary> dictionaryList = new LinkedList<>();
        NodeList dictionaryConfigList = libraryConfig.readConfig();
        for (int i = 0; i < dictionaryConfigList.getLength(); i++) {
            dictionaryList.add(new Dictionary(new Config(dictionaryConfigList.item(i))));
        }
        return dictionaryList;
    }
}

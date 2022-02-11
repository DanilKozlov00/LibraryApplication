package utils.configuration;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Config {

    private final String separator;
    private final String dictionaryName;
    private final String dictionaryPath;
    private final String keyPattern;
    private final String valuePattern;

    public Config(Node dictionaryList) {
        NamedNodeMap dictionaryAttributes = dictionaryList.getAttributes();
        NodeList keyAndValue = dictionaryList.getChildNodes();
        NamedNodeMap keyAttributes = keyAndValue.item(0).getAttributes();
        NamedNodeMap valueAttributes = keyAndValue.item(1).getAttributes();

        this.keyPattern = keyAttributes.getNamedItem("keyPattern").getTextContent() + keyAttributes.getNamedItem("keyLength").getTextContent();
        this.valuePattern = valueAttributes.getNamedItem("valuePattern").getTextContent() + valueAttributes.getNamedItem("valueLength").getTextContent();
        this.separator = dictionaryAttributes.getNamedItem("separator").getTextContent();
        this.dictionaryName = dictionaryAttributes.getNamedItem("dictionaryName").getTextContent();
        this.dictionaryPath = dictionaryAttributes.getNamedItem("dictionaryPath").getTextContent();
    }

    public String getSeparator() {
        return separator;
    }

    public String getDictionaryPath() {
        return dictionaryPath;
    }

    public String getKeyPattern() {
        return keyPattern;
    }

    public String getValuePattern() {
        return valuePattern;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

}

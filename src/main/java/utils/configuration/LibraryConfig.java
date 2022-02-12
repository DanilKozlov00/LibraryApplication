package utils.configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LibraryConfig {

    static final String CONFIG_FILE = "src/main/resources/LibraryConfiguration.xml";

    public NodeList readConfig() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(CONFIG_FILE));
            removeWhitespace(document);
            return document.getDocumentElement().getElementsByTagName("Dictionary");
        } catch (ParserConfigurationException | SAXException xmlException) {
            System.err.println("Error while parse config file");
        } catch (IOException ioException) {
            System.err.println("Error while read file");
        }
        return null;
    }

    public static void removeWhitespace(Document document) {
        Set<Node> toRemove = new HashSet<>();
        DocumentTraversal t = (DocumentTraversal) document;
        NodeIterator it = t.createNodeIterator(document, NodeFilter.SHOW_TEXT, null, true);

        for (Node n = it.nextNode(); n != null; n = it.nextNode()) {
            if (n.getNodeValue().trim().isEmpty()) {
                toRemove.add(n);
            }
        }

        for (Node n : toRemove) {
            n.getParentNode().removeChild(n);
        }
    }


}

import controller.Controller;
import model.Dictionary;
import model.DictionaryFactory;
import utils.configuration.LibraryConfig;
import view.View;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            DictionaryFactory dictionaryFactory = new DictionaryFactory(new LibraryConfig());
            List<Dictionary> dictionaryList = dictionaryFactory.getDictionary();
            View view = new View();
            Controller controller = new Controller(dictionaryList, view);
            controller.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

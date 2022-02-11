package view.actions;

import model.DictionaryTemplate;

import java.util.Map;

public class ReadPairs implements Action {

    private static final String actionName = "4.Read pairs";

    @Override
    public void executeAction(DictionaryTemplate dictionary) {
        for (Map.Entry<String, String> pair : dictionary.readPairs().entrySet()) {
            System.out.println("Key: " + pair.getKey() + "; Value: " + pair.getValue());
        }
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

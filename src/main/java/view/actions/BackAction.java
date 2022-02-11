package view.actions;

import model.DictionaryTemplate;

public class BackAction implements Action {

    private static final String actionName = "5.Back to dictionaries choice";

    @Override
    public void executeAction(DictionaryTemplate dictionary) {
        System.out.println("Saving dictionary result");
        dictionary.getDictionaryData().writeDictionary(dictionary.getDictionaryPairs());
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

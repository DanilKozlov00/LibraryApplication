package view.actions;

import model.DictionaryTemplate;

public class ExitAction implements Action {

    private final static String actionName = "6.Exit application";


    @Override
    public void executeAction(DictionaryTemplate dictionary) {
        System.out.println("Shutdown application");
        dictionary.getDictionaryData().writeDictionary(dictionary.getDictionaryPairs());
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

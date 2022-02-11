package view.actions;

import model.Dictionary;
import model.DictionaryTemplate;
import view.View;

public class DeletePair implements Action {

    private static final String actionName = "2.Delete pair";

    @Override
    public void executeAction(DictionaryTemplate dictionary) {
        System.out.println("Enter key pair");
        String key = View.input.next();
        System.out.println(dictionary.deletePair(key));
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

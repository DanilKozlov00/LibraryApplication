package view.actions;

import model.Dictionary;
import model.DictionaryTemplate;
import view.View;

public class FindPair implements Action {

    private static final String actionName = "3.Find pair";

    @Override
    public void executeAction(DictionaryTemplate dictionary) {
        System.out.println("Enter pair key:");
        String key = View.input.next();
        System.out.println(dictionary.findPair(key));
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

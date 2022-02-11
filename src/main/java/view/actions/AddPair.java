package view.actions;

import model.DictionaryTemplate;
import view.View;

public class AddPair implements Action {

    private static final String actionName = "1.Add pair";

    public void executeAction(DictionaryTemplate dictionary) {
        String[] input = new String[2];
        System.out.println("Enter key:");
        input[0] = View.input.next();
        System.out.println("Enter value:");
        input[1] = View.input.next();
        System.out.println(dictionary.addPair(input[0], input[1]));
    }

    @Override
    public String getActionName() {
        return actionName;
    }
}

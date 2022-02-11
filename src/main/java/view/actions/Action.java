package view.actions;

import model.DictionaryTemplate;

public interface Action {

    void executeAction(DictionaryTemplate dictionary);

    String getActionName();
}

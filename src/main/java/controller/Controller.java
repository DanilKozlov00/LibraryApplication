package controller;

import model.DictionaryTemplate;
import view.ViewTemplate;
import view.actions.*;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    private final List<? extends DictionaryTemplate> dictionaries;
    private DictionaryTemplate dictionary;
    private final ViewTemplate view;
    private final List<Action> actionList = new LinkedList<>() {{
        add(new AddPair());
        add(new DeletePair());
        add(new FindPair());
        add(new ReadPairs());
        add(new BackAction());
        add(new ExitAction());
    }};


    public Controller(List<? extends DictionaryTemplate> dictionaries, ViewTemplate view) {
        this.dictionaries = dictionaries;
        this.view = view;
    }

    public void setDictionaryNumber() {
        this.dictionary = view.showDictionaries(dictionaries);
    }

    public Action showActions() {
        return this.view.showActions(actionList);
    }

    public void run() {
        Action currentAction = null;
        while (checkExit(currentAction)) {
            setDictionaryNumber();
            while (!(currentAction = showActions()).getClass().equals(BackAction.class) && checkExit(currentAction)) {
                currentAction.executeAction(dictionary);
            }
        }
    }

    private boolean checkExit(Action action) {
        if (action == null) {
            return true;
        } else  {
            return !action.getClass().equals(ExitAction.class);
        }
    }


}

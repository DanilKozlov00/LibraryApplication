package view;

import model.DictionaryTemplate;
import view.actions.Action;

import java.util.List;

public interface ViewTemplate {

    Action showActions(List<Action> actionList);

    DictionaryTemplate showDictionaries(List<? extends DictionaryTemplate> dictionaryList);
}

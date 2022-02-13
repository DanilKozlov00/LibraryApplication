package view;

import model.DictionaryTemplate;
import org.springframework.stereotype.Component;
import view.actions.Action;

import java.util.List;
import java.util.Scanner;

@Component
public class View implements ViewTemplate {

    public static final Scanner input = new Scanner(System.in);

    @Override
    public Action showActions(List<Action> actionList) {
        System.out.println("Please select action:");
        for (Action action : actionList) {
            System.out.println(action.getActionName());
        }
        int key = input.nextInt();
        return actionList.get(key - 1);
    }

    @Override
    public DictionaryTemplate showDictionaries(List<? extends DictionaryTemplate> dictionaryList) {
        System.out.println("Please select dictionary:");
        int i = 0;
        for (DictionaryTemplate dictionary : dictionaryList) {
            i++;
            System.out.println(i + "." + dictionary.getDictionaryName());
        }
        int dictionary = input.nextInt()-1;
        return dictionaryList.get(dictionary);
    }

}

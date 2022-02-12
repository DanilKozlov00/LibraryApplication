package spring;

import controller.MainController;
import model.Dictionary;
import model.DictionaryFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.configuration.LibraryConfig;
import view.View;

import java.util.List;

@SpringBootApplication
public class SpringRunner implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringRunner.class, args).close();
    }

    @Override
    public void run(String... args) {
            DictionaryFactory dictionaryFactory = new DictionaryFactory(new LibraryConfig());
            List<Dictionary> dictionaryList = dictionaryFactory.getDictionary();
            View view = new View();
            MainController mainController = new MainController(dictionaryList, view);
            mainController.run();
    }
}


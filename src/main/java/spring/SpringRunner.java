package spring;

import controller.MainController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"model","utils","controller","view"})
@SpringBootApplication
public class SpringRunner implements CommandLineRunner {

    static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(SpringRunner.class);
        SpringApplication.run(SpringRunner.class, args).close();
    }

    @Override
    public void run(String... args) {
            MainController mainController = context.getBean(MainController.class);
            mainController.run();
    }
}


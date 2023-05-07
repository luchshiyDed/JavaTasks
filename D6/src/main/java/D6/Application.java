package D6;

import org.jooq.codegen.GenerationTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // for the first run to generate classes
//        try {
//            GenerationTool.generate(
//                    Files.readString(
//                            Path.of("jooq-config.xml")
//                    )
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(Application.class, args);
    }
}

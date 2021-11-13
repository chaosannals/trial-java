package trial.java.asmdemo;

import java.nio.file.*;
import org.apache.logging.log4j.*;

public class App {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("asm start");
        try {
            byte[] bytes = AsmNewClass.newClass();
            Path t = Path.of("./runtimes/asm/AsmNewClassDemo.class");
            Path d = t.getParent();
            if (!Files.isDirectory(d)) {
                Files.createDirectories(d);
            }
            Files.write(Path.of("./runtimes/asm/AsmNewClassDemo.class"), bytes);
            AsmNewClass.execNewClass();
        }
        catch(Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}

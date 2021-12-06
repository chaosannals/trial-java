package trial.java.exe4jutil;

import java.io.*;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.*;

public class LogUtil {
    public static Logger newLogger(Class<?> c, String path) {
        try {
            InputStream is = c.getResourceAsStream(path);
            ConfigurationSource cs = new ConfigurationSource(is);
            Configurator.initialize(null, cs);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Logger logger = LogManager.getLogger(c);
        return logger;
    }
}

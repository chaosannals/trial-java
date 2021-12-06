package trial.java.exe4jboot;

import java.io.*;
import org.apache.logging.log4j.*;
import trial.java.exe4jutil.*;

public class App {
    public static final Logger LOG = LogUtil.newLogger(App.class, "/exe4jboot/log4j2.xml");

    public static void main(String[] args) {
        LOG.info("启动器");
        try {
            String jwp = new File("jdk-16/bin/javaw.exe").getAbsolutePath();
            String scmd = String.format("%s -cp ./lib/* -Dfile.encoding=UTF-8 trial.java.exe4jstart.App", jwp);
            LOG.info("启动界面命令: {}", scmd);
            String sr = CommandUtil.run(scmd);
            LOG.info(sr);
            // 这个不会阻塞，不能用。
            // ProcessUtil.run(jwp, "-cp", "./lib/*", "-Dfile.encoding=UTF-8", "trial.java.exe4jstart.App");
            String wcmd = String.format("%s -cp ./lib/* -Dfile.encoding=UTF-8 trial.java.exe4jwork.App", jwp);
            LOG.info("作业器命令: {}", wcmd);
            String wr = CommandUtil.run(wcmd);
            LOG.info(wr);
            LOG.info("启动器关闭");
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        LOG.info("启动器完结");
    }
}

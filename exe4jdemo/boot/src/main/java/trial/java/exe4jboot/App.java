package trial.java.exe4jboot;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.*;
import trial.java.exe4jutil.*;

public class App {
    public static final Logger LOG = LogUtil.newLogger(App.class, "/exe4jboot/log4j2.xml");

    public static void main(String[] args) {
        LOG.info("启动器");
        try {
            String jwp = new File("jdk-16/bin/javaw.exe").getAbsolutePath();

            Properties p = new Properties();
            p.load(new FileInputStream("app.properties"));

            // 启动界面
            String ss = p.getProperty("start", "${javaw} -cp ./lib/* -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 trial.java.exe4jstart.App");
            String scmd = ss.replace("${javaw}", jwp);
            LOG.info("启动界面命令: {}", scmd);
            ArrayList<String> senv = CommandUtil.getEnvs();
            LOG.info("env count: {}", senv.size());
            senv.add("AAAA=123456");
            String sr = CommandUtil.run(scmd, senv.toArray(new String[senv.size()]), null);
            LOG.info(sr);

            // 这个不会阻塞，不能用。
            // ProcessUtil.run(jwp, "-cp", "./lib/*", "-Dfile.encoding=UTF-8",
            // "trial.java.exe4jstart.App");

            // 作业器
            String ws = p.getProperty("work", "${javaw} -cp ./lib/* -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 trial.java.exe4jwork.App");
            String wcmd = ws.replace("${javaw}", jwp);
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

package trial.java.exe4jwork;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.apache.logging.log4j.*;
import trial.java.exe4jutil.*;

public class App {
    public static final Logger LOG = LogUtil.newLogger(App.class, "/exe4jwork/log4j2.xml");
    public static void main(String[] args) {
        LOG.info("打开作业器");
        JFrame jframe = new JFrame();
        jframe.setTitle("作业器");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LOG.info("关闭作业器");
            }
        });
        jframe.setVisible(true);
    }
}

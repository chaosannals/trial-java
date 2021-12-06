package trial.java.exe4jstart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.apache.logging.log4j.*;
import trial.java.exe4jutil.*;

public class App {
    public static final Logger LOG = LogUtil.newLogger(App.class, "/exe4jstart/log4j2.xml");

    public static void main(String[] args) {
        LOG.info("打开开始面板");
        JFrame jframe = new JFrame();
        jframe.setTitle("开始面板");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LOG.info("关闭开始面板");
            }
        });
    }
}

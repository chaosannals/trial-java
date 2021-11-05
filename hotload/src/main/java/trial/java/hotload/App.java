package trial.java.hotload;

import java.io.*;
import java.net.*;
import trial.java.hotlib.*;

public class App {
    public static void main(String[] args) {
        try{
            HotManager hm = new HotManager();

            while (true) {
                File f = new File("./hotdemo.jar");
                String url = f.toURL().toString();
                hm.load(url);
                System.out.println(url);
                System.out.println("load");
                for(URL u : hm.getURLs()) {
                    System.out.println("hm url: " + u.toString());
                }
                HotPluginable hp = (HotPluginable)hm.newHotInstance("trial.java.hotdemo.HotPlugin");
                if (hp == null) {
                    System.out.println("failed");
                }
                else {
                    hp.doSome();
                }
                hm.unload(url);
                System.out.println("unload");
                Thread.sleep(5000);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

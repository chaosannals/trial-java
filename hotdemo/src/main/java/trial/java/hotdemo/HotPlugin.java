package trial.java.hotdemo;

import trial.java.hotlib.*;

public class HotPlugin implements HotPluginable {

    @Override
    public void doSome() {
        System.out.println("hot plugin 3.0");
    }
}

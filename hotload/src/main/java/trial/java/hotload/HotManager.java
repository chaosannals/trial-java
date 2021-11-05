package trial.java.hotload;

import java.io.*;
import java.net.*;
import java.util.*;

public class HotManager {
    private HotLoader loader;

    public HotManager() {
        loader = new HotLoader(new URL[] {});
    }

    public void load(String url) throws IOException {
        URL u = new URL(url);
        loader.addHotURL(u);
    }

    public void unload(String url) throws IOException {
        ArrayList<URL> urls = new ArrayList<URL>();
        for(URL u : loader.getURLs()) {
            if (!u.toString().equals(url)) {
                urls.add(u);
            }
        }
        loader.close(); // 这里 JAVA7 才加入，老版本的话需要保存 jar 文件然后关闭。比较麻烦。
        URL[] rs = new URL[urls.size()];
        System.out.println("close loader");
        System.out.println(urls.size());
        urls.toArray(rs);
        loader = new HotLoader(rs);
    }

    public Class<?> getHotClass(String name) throws  ClassNotFoundException {
        return loader.getHotClass(name);
    }

    public Object newHotInstance(String cls) throws  ClassNotFoundException, InstantiationException, IllegalAccessException {
        return loader.newHotInstance(cls);
    }

    public URL[] getURLs() {
        return loader.getURLs();
    }
}

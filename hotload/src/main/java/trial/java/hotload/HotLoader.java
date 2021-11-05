package trial.java.hotload;

import java.net.*;
import java.util.*;
import java.io.*;

public class HotLoader extends URLClassLoader {
    public HotLoader(URL[] urls) {
        super(urls, findParentClassLoader());
    }

    public Class<?> getHotClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }

    public Object newHotInstance(String cls) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Class<?> c = loadClass(cls); // 老版本的函数
        Class<?> c = findClass(cls); 
        return c.newInstance();
    }

    public void addHotURL(URL u) {
        addURL(u);
    }

    public static ClassLoader findParentClassLoader() {
        ClassLoader parent = HotLoader.class.getClassLoader();
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        if (parent == null) {
            parent = Thread.currentThread().getContextClassLoader();
        }
        return parent;
    }
}

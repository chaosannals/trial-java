/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trial.java.jnidemo;

import trial.java.libdemo.*;

public class App {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.someLibraryMethod();
        System.out.println(JniUtil.getpid());
        System.out.println("jni");
    }
}

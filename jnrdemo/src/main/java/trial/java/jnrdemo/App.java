package trial.java.jnrdemo;

import jnr.ffi.*;

public class App {
    public static void main(String[] args) {
        Kernel32 lib = LibraryLoader
            .create(Kernel32.class)
            .load("Kernel32.dll");
        int pid = lib.GetCurrentProcessId();
        System.out.println(pid);
        System.out.println("jna");
    }
}

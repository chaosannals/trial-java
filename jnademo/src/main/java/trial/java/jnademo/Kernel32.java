package trial.java.jnademo;

import com.sun.jna.*;

public interface Kernel32 extends Library {
    Kernel32 INSTANCE = Native.loadLibrary("Kernel32.dll", Kernel32.class);
    
    int GetCurrentProcessId();
}
